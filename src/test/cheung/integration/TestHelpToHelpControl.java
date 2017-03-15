package test.cheung.integration;

import static org.junit.Assert.assertTrue;

import clarity.state.StateManager;
import clarity.ui.Help;
import clarity.ui.HelpControl;
import clarity.utilities.input.Keyboard;

import org.junit.Test;

// Liang Cheung

public class TestHelpToHelpControl {

  @Test
  public void test() {
    StateManager manager = new StateManager(new Keyboard());
    manager.loadNextState(new Help(manager));
    // Stimulating state switch from Help to HelpControl
    manager.loadNextState(new HelpControl(manager));
    assertTrue(manager.getCurrentState() instanceof HelpControl);

  }

}
