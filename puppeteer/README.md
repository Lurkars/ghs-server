# puppeteer

## Purpose

This module is to run automated tests using [Puppeteer](https://pptr.dev/).

## How to use

You first need to make sure that the ghs-server is running, with `ghs-server.public=true`, and with a current client installed.
In the puppeteer directory, run `npm install` to install the dependencies, then run the tests with `node test.js <testName>`.
Tests are located in the actions.js file.
Currently there are only two tests setup: serverTest and clientTest.

## Configuration

There are 3 files:
- `actions.js`: This file contains the actions to be performed by the clients. Each named set of actions can be run independently, depending on what arguments are passed in the run command.
- `selectors.js`: This file contains the selectors for the elements that the clients will interact with. It is used to find elements on the page. Reference [here](https://pptr.dev/guides/page-interactions).
- `config.js`: This file contains server configurations.

## Known issues

Each test run creates a unique game code so that the state will always be clean on startup. This will result in your sqlite database having a lot of test entries.