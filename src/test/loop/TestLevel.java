package test.loop;

import clarity.state.Level;
import clarity.state.StateManager;
import clarity.utilities.input.Keyboard;

import org.junit.Test;

public class TestLevel {

  @Test
  public void testLevelupdate() {
    StateManager statemanager = new StateManager(new Keyboard());
    statemanager.setCurrentLevelIndex(0);
    Level level = new Level(statemanager);
    level.update();
  }

}
