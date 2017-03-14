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

  /**
   * @param mobId The mobID.
   */
  public Skeleton(int mobId) {
    super(mobId);
    setSpeedValues(0.2, 1.5, 0.4, 0.15, 4.0, -6.0, 0.5);
    setSpriteValues(SpriteSheet.SKELETON, 20, 30, 100, 100);
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
}
