package test.mar.junit;

import static org.junit.Assert.assertEquals;

import clarity.graphics.entity.Player;
import clarity.state.StateManager;
import clarity.utilities.input.Keyboard;

import org.junit.Test;

// Jason Mar

public class TestPlayer {

  @Test
  public void testPlayer() {
    Player player = new Player(new StateManager(new Keyboard()));
    double oldHealth = player.getHealth();
    int damage = 10;
    oldHealth -= damage;
    player.hit(damage);
    double newHealth = player.getHealth();
    assertEquals((double) oldHealth, newHealth, 0);
  }

}
