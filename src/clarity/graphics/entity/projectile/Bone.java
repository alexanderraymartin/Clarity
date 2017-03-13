package clarity.graphics.entity.projectile;

import clarity.graphics.entity.SpriteSheet;
import clarity.graphics.entity.particle.ParticleSpawner;
import clarity.state.Level;

import java.awt.Color;

public class Bone extends Projectile {

  public static final int ENERGY_COST = 20;

  public Bone(int mobId) {
    super(Level.player, mobId);
    init();
  }

  @Override
  protected void init() {
    this.currentHealth = maxHealth = 20;

    this.spriteSheet = SpriteSheet.BONE;
    this.collisionWidth = this.collisionHeight = 15;
    this.damage = 100;

    this.moveSpeed = 1;
    this.maxSpeed = 3;
    this.stopSpeed = 5;
    this.fallSpeed = 0.18;
    this.maxFallSpeed = 4.0;
    this.dy = -3;
  }

  @Override
  protected void createParticleSpawner() {
    new ParticleSpawner((int) xcoord, (int) ycoord, 5000, 2, 10, Color.WHITE, Color.WHITE,
        Color.WHITE);
  }
}
