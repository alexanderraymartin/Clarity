package test.loop;

import clarity.state.Level;
import clarity.state.StateManager;
import clarity.utilities.input.Keyboard;

import org.junit.Test;

import java.awt.Graphics2D;

public class LevelTests {

  private transient Graphics2D graphics;
  
  @Test
  public void testLevelupdate() {
    StateManager statemanager = new StateManager(new Keyboard());
    statemanager.setCurrentLevelIndex(0);
    Level level = new Level(statemanager);
    level.update();
  }

}
