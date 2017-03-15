package test.loop;

import static org.junit.Assert.assertEquals;

import clarity.state.StateManager;
import clarity.utilities.input.Keyboard;

import org.junit.Test;

import java.util.ArrayList;

public class TestStateManager {

  @Test
  public void testGetLevels() {
    ArrayList<String> actual = new ArrayList<String>();
    actual.add("level1.level");
    actual.add("level2.level");
    actual.add("level3.level");
    actual.add("level4.level");
    actual.add("level5.level");
    actual.add("level6.level");
    StateManager statemanager = new StateManager(new Keyboard());
    assertEquals(actual, statemanager.getLevels());
  }

}
