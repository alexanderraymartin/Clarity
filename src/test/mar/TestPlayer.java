package test.mar;

import static org.junit.Assert.assertEquals;

import clarity.graphics.entity.Player;
import clarity.state.StateManager;
import clarity.utilities.input.Keyboard;

import org.junit.Test;


public class TestPlayer {

  @Test
  public void testHealth() {
    Player player = new Player(new StateManager(new Keyboard()));
    int change = 10;
    double newHealth = change + player.getHealth();
    player.gainHealth(change);

    assertEquals((double) newHealth, player.getHealth(), 0);
  }

}
