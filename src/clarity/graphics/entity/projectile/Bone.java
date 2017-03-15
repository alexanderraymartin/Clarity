package clarity.graphics.entity.projectile;

import clarity.graphics.entity.Entity;
import clarity.graphics.entity.SpriteSheet;
import clarity.graphics.entity.particle.ParticleSpawner;

import java.awt.Color;

public class Bone extends Projectile {

  public static final int ENERGY_COST = 20;

  /**
   * @param source The source entity.
   * @param mobId The projectile's mob ID.
   */
  public Bone(Entity source, int mobId) {
    super(source, mobId);
    setSpeedValues(1.0, 2.5, 5.0, 0.1, 4.0, -6.0, 0.5);
    setSpriteValues(SpriteSheet.BONE, 15, 15, 100, 100);
    setDamage(20);
    dy = -4;
  }

  @Override
  protected void createParticleSpawner() {
    new ParticleSpawner((int) xcoord, (int) ycoord, 5000, 2, 10, new Color[] {Color.WHITE});
  }
}
