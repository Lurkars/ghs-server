import {selectors} from './selectors.js';

export const actions = {
  serverTest: serverTest(),
  clientTest: clientTest(),
}

function clientTest() {
  return [
    {
      client: 0,
      action: 'addCharacter',
      value: 'blinkblade'
    },
    {
      client: 0,
      action: 'addCharacter',
      value: 'bannerspear'
    },
    {
      client: 0,
      action: 'press',
      value: 'Escape'
    },
    {
      client: 0,
      action: 'click',
      selector: selectors.setScenarioButton
    },
    {
      client: 0,
      action: 'click',
      selector: selectors.scenarioOneButton
    },
    {
      client: 0,
      action: 'initiative',
      value: '1'
    },
    {
      client: 0,
      action: 'initiative',
      value: '1'
    },
    {
      client: 0,
      action: 'draw',
    },
    {
      client: 0,
      action: 'endRound',
    },
  ];
}

function serverTest() {
  return [
    {
      client: 0,
      action: 'connect',
    },
    {
      client: 0,
      action: 'addCharacter',
      value: 'blinkblade'
    },
    {
      client: 1,
      action: 'addCharacter',
      value: 'deathwalker'
    },
    {
      client: 2,
      action: 'addCharacter',
      value: 'bannerspear'
    },
    {
      client: 3,
      action: 'addCharacter',
      value: 'boneshaper'
    },
    {
      client: 0,
      action: 'press',
      value: 'Escape'
    },
    {
      client: 0,
      action: 'click',
      selector: selectors.setScenarioButton
    },
    {
      client: 0,
      action: 'click',
      selector: selectors.scenarioOneButton
    },
    {
      client: 3,
      action: 'initiative',
      value: '1'
    },
    {
      client: 1,
      action: 'initiative',
      value: '1'
    },
    {
      client: 0,
      action: 'initiative',
      value: '1'
    },
    {
      client: 2,
      action: 'initiative',
      value: '1'
    },
    {
      client: 0,
      action: 'draw',
    },
    {
      client: 1,
      action: 'endRound',
    },
  ];
}