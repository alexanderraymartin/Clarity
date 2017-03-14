package clarity.graphics.entity.projectile;

import clarity.graphics.entity.MobId;
import clarity.graphics.entity.SpriteSheet;
import clarity.graphics.entity.particle.ParticleSpawner;
import clarity.state.Level;

import java.awt.Color;

public class Fireball extends Projectile {

  public static final int ENERGY_COST = 20;

  public Fireball() {
    super(Level.getPlayer(), MobId.DUMMY);
    init();
  }

  @Override
  protected void init() {
    this.currentHealth = maxHealth = 100;

    this.spriteSheet = SpriteSheet.FIREBALL;
    this.collisionWidth = this.collisionHeight = 15;
    this.damage = 100;

    this.moveSpeed = 1;
    this.maxSpeed = 5;
    this.stopSpeed = 5;
    this.fallSpeed = 0;
    this.maxFallSpeed = 0;
  }

  @Override
  protected void createParticleSpawner() {
    new ParticleSpawner((int) xcoord, (int) ycoord, 5000, 2, 3, Color.RED, Color.RED, Color.RED);
  }
}
