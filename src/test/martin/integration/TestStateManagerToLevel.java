package test.martin.integration;

import clarity.state.Level;
import clarity.state.StateManager;
import clarity.utilities.input.Keyboard;

import org.junit.Test;

// Alex Martin

public class TestStateManagerToLevel {

  @Test
  public void testLevelCreation() {
    StateManager manager = new StateManager(new Keyboard());
    manager.setCurrentLevelIndex(0);
    Level level = new Level(manager);

    assert (level != null);
  }

}
