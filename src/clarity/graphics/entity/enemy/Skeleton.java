package clarity.graphics.entity.enemy;

import clarity.graphics.entity.SpriteSheet;

public class Skeleton extends Enemy {
  
  private static final int DAMAGE = 40;

  public Skeleton(int mobId) {
    super(mobId, DAMAGE);
  }

  @Override
  public void move() {
    // TODO Auto-generated method stub

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
    setFallSpeed(0.15);
    maxFallSpeed = 4.0;
    // jumping speeds
    jumpStart = -6.0;
    stopJumpSpeed = 0.5;
    facingRight = false;
    currentHealth = maxHealth = 100;
    currentEnergy = maxEnergy = 100;
  }

}
