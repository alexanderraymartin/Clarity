package clarity.graphics.entity;

import clarity.graphics.entity.particle.ParticleSpawner;
import clarity.state.Level;

import java.awt.Color;

public class Torch extends Entity {

  private static final float LIGHT_AMOUNT = 1f;

  /**
   * @param mobId The mob ID.
   */
  public Torch(int mobId) {
    super(mobId);
    facingRight = true;
    setImmune(true);
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
    if (intersection(Level.getPlayer())) {
      Level.getLight().increaseLight(LIGHT_AMOUNT);
      isDead = true;
    }
  }

  @Override
  protected void createParticleSpawner() {
    new ParticleSpawner((int) xcoord, (int) ycoord, 5000, 2, 600, new Color[] {Color.YELLOW});
  }

  @Override
  protected void defineSpriteSheet() {
    spriteSheet = SpriteSheet.TORCH;
  }

  @Override
  protected void defineCollisionWidth() {
    collisionWidth = 15;
  }

  @Override
  protected void defineCollisionHeight() {
    collisionHeight = 30;
  }

  @Override
  protected void defineMoveSpeed() {
    moveSpeed = 0;
  }

  @Override
  protected void defineMaxSpeed() {
    maxSpeed = 0;
  }

  @Override
  protected void defineStopSpeed() {
    stopSpeed = 0;
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
    jumpStart = 0;
  }

  @Override
  protected void defineStopJumpSpeed() {
    stopJumpSpeed = 0;
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
