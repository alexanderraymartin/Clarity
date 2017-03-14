package clarity.graphics.entity.enemy;

import clarity.graphics.entity.SpriteSheet;
import clarity.graphics.tile.TileSet;
import clarity.state.Level;

public class Zombie extends Enemy {

  private static final int DAMAGE = 30;
  private double previousX = 0;

  public Zombie(int mobId) {
    super(mobId, DAMAGE);
  }

  @Override
  public void move() {
    if (Math.abs(Level.getPlayer().getX() - xcoord) < TileSet.getTileSize() * CHASE_RANGE) {
      double changeX = Math.abs(previousX - xcoord);
      if (Level.getPlayer().getX() < xcoord) {
        isRight = false;
        isLeft = true;
      } else {
        isLeft = false;
        isRight = true;
      }
      double ydistance = Math.abs(Level.getPlayer().getY()) - Math.abs(ycoord);
      boolean ycheck = ydistance > TileSet.getTileSize() * MAX_JUMP_RANGE
          && ydistance < TileSet.getTileSize() * MIN_JUMP_RANGE && ydistance < 0;
      if ((checkTileCollision() && dy == 0 && changeX < 1) || ycheck) {
        setJumping(true);
      } else {
        setJumping(false);
      }

      previousX = xcoord;
    }
  }

  @Override
  protected void init() {
    spriteSheet = SpriteSheet.ZOMBIE;
    collisionWidth = 20;
    collisionHeight = 30;
    moveSpeed = 0.1;
    maxSpeed = 1.75;
    stopSpeed = 0.1;
    fallSpeed = 0.15;
    maxFallSpeed = 4.0;
    jumpStart = -10.0;
    stopJumpSpeed = 0.1;
    facingRight = false;
    currentHealth = maxHealth = 100;
    currentEnergy = maxEnergy = 100;
  }
}
