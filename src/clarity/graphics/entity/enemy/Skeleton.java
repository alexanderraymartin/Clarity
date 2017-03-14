package clarity.graphics.entity.enemy;

import clarity.graphics.entity.MobId;
import clarity.graphics.entity.SpriteSheet;
import clarity.graphics.entity.projectile.Bone;
import clarity.graphics.tile.TileSet;
import clarity.state.Level;
import clarity.utilities.Timer;

public class Skeleton extends Enemy {

  private static final int DELAY = 1000;

  private Timer boneAttackTimer = new Timer();

  public Skeleton(int mobId) {
    super(mobId);
    boneAttackTimer = new Timer();
  }

  @Override
  public void move() {
    if (Math.abs(Level.getPlayer().getX() - xcoord) < TileSet.getTileSize() * CHASE_RANGE) {
      if (Level.getPlayer().getX() < xcoord) {
        isRight = false;
        isLeft = true;
      } else {
        isLeft = false;
        isRight = true;
      }
    }
    if (boneAttackTimer.hasElapsed(DELAY)) {
      throwBone();
      boneAttackTimer.reset();
    }

  }

  private void throwBone() {
    if (boneAttackTimer.hasElapsed(DELAY)) {
      new Bone(this, MobId.DUMMY);
      boneAttackTimer.reset();
    }
  }

  @Override
  protected void defineAttackDamage() {
    attackDamage = 10;
  }

  @Override
  protected void defineSpriteSheet() {
    spriteSheet = SpriteSheet.SKELETON;
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
    moveSpeed = 0.2;
  }

  @Override
  protected void defineMaxSpeed() {
    maxSpeed = 1.5;
  }

  @Override
  protected void defineStopSpeed() {
    stopSpeed = 0.4;
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
    jumpStart = -6.0;
  }

  @Override
  protected void defineStopJumpSpeed() {
    stopJumpSpeed = 0.5;
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
