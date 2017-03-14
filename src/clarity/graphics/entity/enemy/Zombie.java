package clarity.graphics.entity.enemy;

import clarity.graphics.entity.SpriteSheet;
import clarity.graphics.tile.TileSet;
import clarity.state.Level;

public class Zombie extends Enemy {

  private double previousX = 0;

  public Zombie(int mobId) {
    super(mobId);
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
  protected void defineAttackDamage() {
    attackDamage = 30;
  }

  @Override
  protected void defineSpriteSheet() {
    spriteSheet = SpriteSheet.ZOMBIE;
  }

  @Override
  protected void defineCollisionWidth() {
    collisionWidth = 20;
  }

  @Override
  protected void defineCollisionHeight() {
    collisionHeight = 30;
  }

  @Override
  protected void defineMoveSpeed() {
    moveSpeed = 0.1;
  }

  @Override
  protected void defineMaxSpeed() {
    maxSpeed = 1.75;
  }

  @Override
  protected void defineStopSpeed() {
    stopSpeed = 0.1;
  }

  @Override
  protected void defineFallSpeed() {
    fallSpeed = 0.15;
  }

  @Override
  protected void defineMaxFallSpeed() {
    maxFallSpeed = 4.0;
  }

  @Override
  protected void defineJumpStart() {
    jumpStart = -10.0;
  }

  @Override
  protected void defineStopJumpSpeed() {
    stopJumpSpeed = 0.1;
  }

  @Override
  protected void defineCurrentAndMaxHealth() {
    currentHealth = maxHealth = 100;
  }

  @Override
  protected void defineCurrentAndMaxEnergy() {
    currentEnergy = maxEnergy = 100;
  }
}
