package clarity.graphics.entity.powerup;

import clarity.graphics.entity.Player;

public class Energyup implements Powerup {
  public static int energyBoost = 10;
  
  @Override
  public void update(Player player) {
    // TODO Auto-generated method stub
    player.currentEnergy = player.currentEnergy + energyBoost;
  }

}
