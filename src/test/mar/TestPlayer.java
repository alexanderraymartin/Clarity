package test.mar;

import clarity.graphics.entity.Player;
import clarity.state.StateManager;
import clarity.utilities.input.Keyboard;

import org.junit.Test;


public class TestPlayer {

  @Test
  public void testPlayer() {
    Player player = new Player(new StateManager(new Keyboard()));

    assert (player != null);
  }

}
