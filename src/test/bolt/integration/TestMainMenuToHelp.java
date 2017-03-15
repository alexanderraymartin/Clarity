package test.bolt.integration;

import clarity.state.StateManager;
import clarity.ui.Help;
import clarity.ui.MainMenu;
import clarity.utilities.input.Keyboard;

import org.junit.Test;

// Dustin Bolt

public class TestMainMenuToHelp {

  @Test
  public void testHelp() {
    StateManager manager = new StateManager(new Keyboard());
    manager.loadNextState(new MainMenu(manager));
    manager.loadNextState(new Help(manager));
    assert (manager.getCurrentState() instanceof Help);
  }


}
