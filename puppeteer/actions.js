import {selectors} from './selectors.js';

export const actions =
    [
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
        client:0,
        action: 'draw',
      },
      {
        client: 1,
        action: 'goToNextTurn',
      },
    ]