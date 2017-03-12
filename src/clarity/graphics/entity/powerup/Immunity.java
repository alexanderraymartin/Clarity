package clarity.graphics.entity.powerup;

import clarity.graphics.entity.Player;

public class Immunity implements Powerup {

  @Override
  public void update(Player player) {
    player.setImmune(true);
    player.setImmunityTimer(0);
  }

}
