package clarity.graphics.entity.enemy;

import clarity.graphics.entity.SpriteSheet;

public class Ghost extends Enemy {

  public Ghost(int mobId) {
    super(mobId);
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

  @Override
  protected void defineSpriteSheet() {
    spriteSheet = SpriteSheet.GHOST;
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
    fallSpeed = 0;
  }

  @Override
  protected void defineMaxFallSpeed() {
    maxFallSpeed = 0;
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
