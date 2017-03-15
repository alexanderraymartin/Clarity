package test.he.integration;

import static org.junit.Assert.assertEquals;

import clarity.graphics.Map;
import clarity.state.Level;
import clarity.state.StateManager;
import clarity.utilities.input.Keyboard;

import org.junit.Test;

import java.awt.Graphics2D;

/**
 * 
 * Test written by Wenmin He.
 *
 */

public class TestLevelToMap {

  private transient Graphics2D graphics;

  @Test
  public void testForLevelToMap() {
    StateManager statemanager = new StateManager(new Keyboard());
    statemanager.setCurrentLevelIndex(0);
    new Level(statemanager);
    Map map = new Map();
    map.initMap(0, 0);
    map.render(graphics);
    Level.setMap(map);

    assertEquals(0, Level.getMap().getNumOfCols(), 0);
  }

}
