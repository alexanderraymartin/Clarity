package clarity.graphics.entity.powerup;

import clarity.graphics.entity.Player;

public class Immunity implements Powerup {

  @Override
  public void update(Player player) {
    // TODO Auto-generated method stub
    player.isImmune = true;
    player.immunityTimer = 0;
  }

}
