package clarity.graphics.entity.powerup;

import clarity.graphics.entity.Player;

public class Healthup implements Powerup {

  public static final int HEALTH_PACK = 10;

  @Override
  public void update(Player player) {
    player.setHealth(player.getHealth() + HEALTH_PACK);
  }

}
