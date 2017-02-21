package test.martin;

import clarity.state.Level;
import clarity.state.State;
import clarity.state.StateManager;

import org.junit.Test;

public class TestState {

  @Test
  public void testConstructor() {
    StateManager stateManager = new StateManager();
    State currentState = new Level(stateManager);

    assert (currentState instanceof Level);
  }

}
