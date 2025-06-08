import puppeteer from "puppeteer";
import {v4 as uuidv4} from 'uuid';
import {selectors} from "./selectors.js";
import {clients} from "./clients.js";
import {actions} from "./actions.js";
import {config} from "./config.js";

let activeClient = 0;

async function delay(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

async function connectToServer(page, gameCode) {
  await page.keyboard.press('Escape');
  await page.locator(selectors.serverConnectionButton).click();
  await page.locator(selectors.hostInput).fill(config.server.host);
  await page.locator(selectors.portInput).fill(config.server.port);
  await page.locator(selectors.gameCodeInput).fill(gameCode);
  await page.locator(selectors.connectButton).click();
  await page.keyboard.press('Escape');
}

async function doAction(action) {
  const client = clients[action.client];
  const page = client.page;
  if (activeClient !== action.client) {
    activeClient = action.client;
    await page.bringToFront();
    await delay(500);
  }
  if (action.action === 'initiative') {
    await page.locator(selectors.nextInitiativeInput).fill(action.value);
    await page.keyboard.press('Escape');
  } else if (action.action === 'fill') {
    await page.locator(action.selector).fill(action.value);
  } else if (action.action === 'click') {
    await page.locator(action.selector).click();
  } else if (action.action === 'press') {
    await page.keyboard.press(action.value);
  } else if (action.action === 'draw') {
    await page.keyboard.press('n');
    await delay(1000);
  } else if (action.action === 'goToNextTurn') {
    await goToNextTurn();
  }
}

async function goToNextTurn() {
  const page = clients[activeClient].page;
  const figureCount = Array.from(await page.$$('.cdk-drop-list'));
  for (let i = 0; i <= figureCount.length + 2; i++) { // This is a bit excessive and can get reduced if the number of turns taken is tracked
    await page.keyboard.press('Tab');
  }
  await page.keyboard.press('n');
}

async function runTest() {
  const gameCode = uuidv4();
  const browser = await puppeteer.launch({headless: false});
  let connected = false;
  for (const client of clients) {
    const page = await browser.newPage();
    await page.goto(config.client.url);
    await page.waitForSelector(selectors.menuHint);
    if (!connected) {
      // The first client connects, and the others will be set to auto-connect
      await connectToServer(page, gameCode);
      connected = true;
    }
    await delay(1000);
    await page.waitForSelector(selectors.menuButton);
    await page.locator(selectors.menuButton).click();
    await page.locator(selectors.addCharacter).click();
    await page.locator(client.classSelector).click();
    await page.keyboard.press('Escape');
    client.page = page;
  }
  activeClient = clients.length - 1;
  for (const action of actions) {
    await doAction(action);
  }
  console.log(`All actions executed, waiting for 30 seconds before closing the browser...`);
  await delay(30000);
  await browser.close();
}

runTest()
  .then(() => console.log('Test completed successfully'))
  .catch(err => console.error('Test failed:', err));