package clarity.graphics.entity.projectile;

import clarity.graphics.entity.Entity;
import clarity.graphics.entity.SpriteSheet;
import clarity.graphics.entity.particle.ParticleSpawner;

import java.awt.Color;

public class Bone extends Projectile {

  public static final int ENERGY_COST = 20;

  public Bone(Entity source, int mobId) {
    super(source, mobId);
    init();
  }

  @Override
  protected void init() {
    this.currentHealth = maxHealth = 100;

    this.spriteSheet = SpriteSheet.BONE;
    this.collisionWidth = this.collisionHeight = 15;
    this.damage = 20;

    this.moveSpeed = 1;
    this.maxSpeed = 2.5;
    this.stopSpeed = 5;
    this.fallSpeed = 0.10;
    this.maxFallSpeed = 4.0;
    this.dy = -4;
  }

  @Override
  protected void createParticleSpawner() {
    new ParticleSpawner((int) xcoord, (int) ycoord, 5000, 2, 10, new Color[] {Color.WHITE});
  }
}
