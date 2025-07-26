import {selectors} from "./selectors.js";
import {v4 as uuidv4} from 'uuid';
import {config} from "./config.js";
import {delay} from "./utils.js";

const gameCode = uuidv4();
const clients = new Map();
let activeClient = -1;

export async function runActions(browser, actions) {
  for (const action of actions) {
    await doAction(action, browser);
  }
}

async function doAction(action, browser) {
  let client = clients[action.client];
  if (!client) {
    client = await createClient(clients, action.client, browser);
    await delay(1000);
  }
  const page = client.page;
  if (!action.client !== activeClient) {
    await page.bringToFront();
    await delay(500);
  }
  activeClient = action.client;
  switch (action.action) {
    case 'connect':
      await connectToServer(page, gameCode);
      break;
    case 'disconnect': // Eventually this needs to just disconnect from the server, but for now it just closes the page
      await page.close();
      clients.delete(action.client);
      break;
    case 'addCharacter':
      await addCharacter(action, page);
      break;
    case 'initiative':
      // This needs to be reworked. It works in the serverTest, but not in the clientTest
      await page.locator(selectors.nextInitiativeInput).fill(action.value);
      await page.keyboard.press('Escape');
      break;
    case 'fill':
      await page.locator(action.selector).fill(action.value);
      break;
    case 'click':
      await page.locator(action.selector).click();
      break;
    case 'press':
      await page.keyboard.press(action.value);
      break;
    case 'draw':
      await page.keyboard.press('n');
      await delay(1000);
      break;
    case 'endRound':
      await endRound(page);
      break;
  }
}

async function connectToServer(page, gameCode) {
  await page.keyboard.press('Escape');
  await page.locator(selectors.serverConnectionButton).click();
  await page.locator(selectors.hostInput).fill(config.server.host);
  await page.locator(selectors.portInput).fill(config.server.port);
  await page.locator(selectors.gameCodeInput).fill(gameCode);
  await page.locator(selectors.connectButton).click();
  await page.keyboard.press('Escape');
  await delay(1000);
}

async function createClient(clients, clientId, browser) {
  const newPage = await browser.newPage();
  await newPage.goto(config.client.url);
  await newPage.waitForSelector(selectors.menuHint);
  const client = {
    page: newPage,
  }
  clients[clientId] = client;
  return client;
}

async function addCharacter(action, page) {
  await page.keyboard.press('Escape');
  await page.locator(selectors.addCharacter).click();
  const characterSelector = selectors.classes[action.value];
  await page.locator(characterSelector).click();
  await page.keyboard.press('Escape');
}

async function endRound(page) {
  const figureCount = Array.from(await page.$$('.cdk-drop-list'));
  for (let i = 0; i <= figureCount.length + 2; i++) { // This is a bit excessive and can get reduced if the number of turns taken is tracked
    await page.keyboard.press('Tab');
  }
  await page.keyboard.press('n');
}
