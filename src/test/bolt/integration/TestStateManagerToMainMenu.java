package test.bolt.integration;

import clarity.state.StateManager;
import clarity.ui.MainMenu;
import clarity.utilities.input.Keyboard;

import org.junit.Test;

// Dustin Bolt

public class TestStateManagerToMainMenu {

  @Test
  public void testMainMenu() {
    StateManager manager = new StateManager(new Keyboard());
    manager.loadNextState(new MainMenu(manager));
    assert (manager.getCurrentState() instanceof MainMenu);
  }

}
