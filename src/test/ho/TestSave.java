package test.ho;

import clarity.state.Level;
import clarity.state.State;
import clarity.state.StateManager;
import clarity.utilities.Save;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestSave
{

  @Test
  public void testConstructor() {
    StateManager stateManager = new StateManager();
    State currentState = new Level(stateManager);
    Save save = new Save("", currentState);

    assertEquals("", save.getPath());
  }



  @Test
  public void testSetPath() {
    StateManager stateManager = new StateManager();
    State currentState = new Level(stateManager);
    Save save = new Save("", currentState);

    save.setPath("test");
    assertEquals("test", save.getPath());
  }

}
