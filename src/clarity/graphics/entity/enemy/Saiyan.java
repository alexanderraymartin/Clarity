package clarity.graphics.entity.enemy;

import clarity.graphics.entity.SpriteSheet;
import clarity.graphics.tile.TileSet;
import clarity.state.Level;

import java.util.Random;

public class Saiyan extends Enemy {

  private int counter = 0;

  /**
   * @param mobId The mobID.
   */
  public Saiyan(int mobId) {
    super(mobId);
    setSpeedValues(0.2, 1.5, 0.4, 0.15, 4.0, -6.0, 0.5);
    setSpriteValues(SpriteSheet.SAIYAN, 15, 30, 100, 100);
  }

  @Override
  public void move() {
    if (Math.abs(Level.getPlayer().getX() - xcoord) < TileSet.getTileSize() * CHASE_RANGE) {
      counter += 1;
      if (counter == 10) {
        counter = 0;
        Random rand = new Random();
        int movement = rand.nextInt(6);
        if (movement == 0) {
          isRight = false;
          isLeft = true;
          setJumping(false);
        }
        if (movement == 1) {
          isLeft = false;
          isRight = true;
          setJumping(false);
        }
        if (movement == 2) {
          setJumping(true);
        }
      }
    } else {
      isLeft = false;
      isRight = false;
      setJumping(false);
    }

  }

  @Override
  protected void defineAttackDamage() {
    attackDamage = 100;
  }
}
