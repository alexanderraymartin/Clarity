package test.mar;

import static org.junit.Assert.assertEquals;

import clarity.graphics.entity.MobId;
import clarity.graphics.entity.Player;

import org.junit.Test;


public class TestPlayer {

  @Test
  public void testHealth() {
    Player player = new Player(MobId.PLAYER);
    // p.gainHealth(10);
    int change = 10;
    double newHealth = change + player.getHealth();
    player.gainHealth(change);

    assertEquals((double) newHealth, player.getHealth(), 0);
  }

  @Test
  public void testLight() {
    Player player = new Player(MobId.PLAYER);
    player.gainLightSource(10);

    assertEquals((double) player.getLight(), 110, 0);
  }
}
