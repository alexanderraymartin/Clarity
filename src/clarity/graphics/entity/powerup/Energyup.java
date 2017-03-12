package clarity.graphics.entity.powerup;

import clarity.graphics.entity.Player;

public class Energyup implements Powerup {

  public static final int ENERGY_BOOST = 10;

  @Override
  public void update(Player player) {
    player.setEnergy(player.getEnergy() + ENERGY_BOOST);
  }

}
