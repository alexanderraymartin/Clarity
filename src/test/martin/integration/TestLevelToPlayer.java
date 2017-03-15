package test.martin.integration;

import clarity.graphics.entity.Player;
import clarity.state.Level;
import clarity.state.StateManager;
import clarity.utilities.input.Keyboard;

import org.junit.Test;

public class TestLevelToPlayer {

  @Test
  public void testLevelCreation() {
    StateManager manager = new StateManager(new Keyboard());
    manager.setCurrentLevelIndex(0);
    new Level(manager);

    Player player = new Player(manager);

    assert (player != null);
  }


}
