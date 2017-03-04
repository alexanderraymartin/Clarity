package clarity.graphics.entity.powerup;

import clarity.graphics.entity.Player;

public class Healthup implements Powerup {
  public static int healthPack = 10;

  @Override
  public void update(Player player) {
    // TODO Auto-generated method stub
    player.currentHealth = player.currentHealth + healthPack;
  }

}
