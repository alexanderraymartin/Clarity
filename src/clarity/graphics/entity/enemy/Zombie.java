package clarity.graphics.entity.enemy;

import clarity.graphics.entity.SpriteSheet;
import clarity.graphics.tile.TileSet;
import clarity.state.Level;

public class Zombie extends Enemy {

  private static final int DAMAGE = 40;
  private double previousX = 0;

  public Zombie(int mobId) {
    super(mobId, DAMAGE);
  }

  @Override
  public void move() {
    if (Math.abs(Level.player.getX() - xcoord) < TileSet.getTileSize() * CHASE_RANGE) {
      double changeX = Math.abs(previousX - xcoord);
      if (Level.player.getX() < xcoord) {
        isRight = false;
        isLeft = true;
      } else {
        isLeft = false;
        isRight = true;
      }
      if (checkTileCollision()
          || Math.abs(Level.player.getX() - xcoord) < TileSet.getTileSize() * JUMP_RANGE) {
        if (dy == 0 && changeX < 1) {
          setJumping(true);
        } else {
          setJumping(false);
        }

        previousX = xcoord;
      }

    }
  }

  @Override
  protected void init() {
    spriteSheet = SpriteSheet.ZOMBIE;
    collisionWidth = 25;
    collisionHeight = 30;
    // movement speeds
    moveSpeed = 0.1;
    maxSpeed = 1.5;
    stopSpeed = 0.4;
    // falling speeds
    fallSpeed = 0.15;
    maxFallSpeed = 4.0;
    // jumping speeds
    jumpStart = -6.0;
    stopJumpSpeed = 0.5;
    facingRight = false;
    currentHealth = maxHealth = 100;
//    currentEnergy = maxEnergy = 100;
  }
}
