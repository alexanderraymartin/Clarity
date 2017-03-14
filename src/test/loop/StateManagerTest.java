package test.loop;

import static org.junit.Assert.assertEquals;

import clarity.state.StateManager;

import org.junit.Test;

import java.util.ArrayList;

public class StateManagerTest {

  @Test
  public void testgetLevels() {
    ArrayList<String> actual = new ArrayList<String>();
    actual.add("level1.level");
    actual.add("level2.level");
    actual.add("level3.level");
    actual.add("level4.level");
    actual.add("level5.level");
    actual.add("level6.level");
    StateManager statemanager = new StateManager();
    assertEquals(actual, statemanager.getLevels());
  }

}
