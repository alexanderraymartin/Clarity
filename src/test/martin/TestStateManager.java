package test.martin;

import clarity.state.State;
import clarity.state.StateManager;
import clarity.ui.MainMenu;
import clarity.utilities.input.Keyboard;

import org.junit.Test;

public class TestStateManager {

  @Test
  public void testConstructor() {
    StateManager stateManager = new StateManager(new Keyboard());
    State currentState;
    currentState = stateManager.getCurrentState();

    assert (currentState instanceof MainMenu);
  }

}
