import puppeteer from "puppeteer";
import {actions} from './actions.js';
import {runActions} from "./actionRunner.js";
import {delay} from "./utils.js";

async function runTests() {
  const args = process.argv.slice(2);
  if (args.length === 0) {
    console.error('No test specified');
    console.log('Please re-run with a test name like "node test.js serverTest"');
    console.log(`Available tests: ${Object.keys(actions).join(', ')}`);
    return;
  }
  const testNames = args.filter(name => Object.keys(actions).includes(name));
  if (testNames.length === 0) {
    console.error('No valid test names provided');
    console.log(`Available tests: ${Object.keys(actions).join(', ')}`);
    return;
  }
  for (const testName of testNames) {
    console.log(`Running test: ${testName}`);
    await runTest(actions[testName]);
  }
}

async function runTest(actions) {
  const browser = await puppeteer.launch({headless: false});
  await runActions(browser, actions);
  console.log(`All actions executed, waiting for 30 seconds before closing the browser...`);
  await delay(30000);
  await browser.close();
}

runTests()
    .then()
    .catch(err => console.error('Test failed:', err));