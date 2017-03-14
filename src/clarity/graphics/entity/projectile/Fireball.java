package clarity.graphics.entity.projectile;

import clarity.graphics.entity.MobId;
import clarity.graphics.entity.SpriteSheet;
import clarity.graphics.entity.particle.ParticleSpawner;
import clarity.state.Level;

import java.awt.Color;

public class Fireball extends Projectile {

  public static final int ENERGY_COST = 20;

  /**
   * Create a fireball.
   */
  public Fireball() {
    super(Level.getPlayer(), MobId.DUMMY);
    setSpeedValues(1.0, 5.0, 5.0, 0, 0, -6.0, 0.5);
    setSpriteValues(SpriteSheet.FIREBALL, 15, 15, 100, 100);
    setDamage(100);
  }

  @Override
  protected void createParticleSpawner() {
    new ParticleSpawner((int) xcoord, (int) ycoord, 5000, 2, 10, new Color[] {Color.RED});
  }
}
