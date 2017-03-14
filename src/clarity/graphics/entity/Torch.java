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
    setSpeedValues(0, 0, 0, 0, 0, 0, 0);
    setSpriteValues(SpriteSheet.TORCH, 15, 30, 100, 100);
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
}
