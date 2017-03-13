package clarity.graphics.entity;

import clarity.graphics.entity.particle.ParticleSpawner;
import clarity.state.Level;

import java.awt.Color;

public class Torch extends Entity {

  private static final float LIGHT_AMOUNT = 1f;

  public Torch(int mobId) {
    super(mobId);
  }

  /**
   * (non-Javadoc)
   * 
   * @see clarity.graphics.entity.Entity#update()
   */
  public void update() {
    playerCollisionCheck();
    super.update();
  }

  /**
   * Check for collision with the player.
   */
  public void playerCollisionCheck() {
    if (intersection(Level.player)) {
      Level.getLight().increaseLight(LIGHT_AMOUNT);
      isDead = true;
    }
  }

  @Override
  protected void createParticleSpawner() {
    new ParticleSpawner((int) xcoord, (int) ycoord, 5000, 2, 200, Color.YELLOW, Color.YELLOW,
        Color.YELLOW);
  }

  @Override
  protected void init() {
    spriteSheet = SpriteSheet.TORCH;
    collisionWidth = 15;
    collisionHeight = 30;
    // movement speeds
    moveSpeed = 0;
    maxSpeed = 0;
    stopSpeed = 0;
    // falling speeds
    fallSpeed = 0;
    maxFallSpeed = 0;
    // jumping speeds
    stopJumpSpeed = 0;
    facingRight = true;
    currentHealth = maxHealth = 100;
    currentEnergy = maxEnergy = 100;
    setImmune(true);
  }

}
