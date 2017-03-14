package clarity.graphics.entity.enemy;

import clarity.graphics.entity.SpriteSheet;
import clarity.graphics.tile.TileSet;
import clarity.state.Level;

import java.util.Random;

public class Saiyan extends Enemy {

  private static final int DAMAGE = 100;
  private int counter = 0;

  public Saiyan(int mobId) {
    super(mobId, DAMAGE);
  }

  @Override
  public void move() {
    if (Math.abs(Level.player.getX() - xcoord) < TileSet.getTileSize() * CHASE_RANGE) {
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
  protected void init() {
    spriteSheet = SpriteSheet.SAIYAN;
    collisionWidth = 15;
    collisionHeight = 30;
    moveSpeed = 0.2;
    maxSpeed = 1.5;
    stopSpeed = 0.4;
    fallSpeed = 0.15;
    maxFallSpeed = 4.0;
    jumpStart = -6.0;
    stopJumpSpeed = 0.5;
    facingRight = false;
    currentHealth = maxHealth = 100;
    currentEnergy = maxEnergy = 100;
  }

}
