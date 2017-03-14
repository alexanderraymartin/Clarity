package clarity.graphics.entity.enemy;

import clarity.graphics.entity.SpriteSheet;

public class Ghost extends Enemy {

  /**
   * @param mobId The mobID.
   */
  public Ghost(int mobId) {
    super(mobId);
    setSpeedValues(0.2, 1.5, 0.4, 0, 0, -6.0, 0.5);
    setSpriteValues(SpriteSheet.GHOST, 20, 15, 100, 100);
    isRight = true;
  }

  /**
   * Enemy movement is walking back and forth.
   */
  @Override
  public void move() {
    if (checkTileCollision()) {
      if (isLeft) {
        isLeft = false;
        isRight = true;
      } else {
        isLeft = true;
        isRight = false;
      }
    }

  }

  @Override
  protected void defineAttackDamage() {
    attackDamage = 40;
  }
}
