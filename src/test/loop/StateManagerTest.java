package test.loop;

import static org.junit.Assert.assertEquals;

import clarity.state.StateManager;

import org.junit.Test;

import java.util.ArrayList;

public class StateManagerTest {

  @Test
  public void testgetLevels() {
    StateManager statemanager = new StateManager();
    ArrayList<String> actual = new ArrayList<String>();
    actual.add("level1.level");
    actual.add("level2.level");
    assertEquals(actual, statemanager.getLevels());
  }

}
