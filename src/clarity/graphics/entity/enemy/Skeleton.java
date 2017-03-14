package clarity.graphics.entity.enemy;

import clarity.graphics.entity.MobId;
import clarity.graphics.entity.SpriteSheet;
import clarity.graphics.entity.projectile.Bone;
import clarity.graphics.tile.TileSet;
import clarity.state.Level;
import clarity.utilities.Timer;

public class Skeleton extends Enemy {
  private static final int DAMAGE = 40;
  private Timer boneAttackTimer = new Timer();
  private static final int DELAY = 500;

  public Skeleton(int mobId) {
    super(mobId, DAMAGE);
    boneAttackTimer = new Timer();
  }

  @Override
  public void move() {
    if (Math.abs(Level.player.getX() - xcoord) < TileSet.getTileSize() * CHASE_RANGE) {
      if (Level.player.getX() < xcoord) {
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
    if (getEnergy() - Bone.ENERGY_COST >= 0) {
      setEnergy(getEnergy() - Bone.ENERGY_COST);
      MobId.getEntity(MobId.BONE);
    }

  }

  @Override
  protected void init() {
    spriteSheet = SpriteSheet.SKELETON;
    collisionWidth = 25;
    collisionHeight = 30;
    // movement speeds
    moveSpeed = 0.2;
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
    // currentEnergy = maxEnergy = 100;
  }

}
