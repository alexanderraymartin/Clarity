package clarity.graphics.entity.powerup;

import clarity.graphics.entity.Projectile;
import clarity.graphics.entity.SpriteSheet;
import clarity.graphics.entity.particle.ParticleSpawner;
import clarity.state.Level;

import java.awt.Color;

public class Fireball extends Projectile {

  public static final int ENERGY_COST = 20;

  public Fireball(int mobId) {
    super(Level.player, mobId);
    init();
  }

  @Override
  protected void init() {
    this.source = Level.player;
    this.xcoord = source.getX();
    this.ycoord = source.getY();
    this.currentHealth = maxHealth = 100;

    this.spriteSheet = SpriteSheet.FIREBALL;
    this.collisionWidth = this.collisionHeight = 15;
    this.facingRight = this.source.isFacingRight();
    this.damage = 100;

    this.moveSpeed = 1;
    this.maxSpeed = 5;
    this.stopSpeed = 5;
    this.fallSpeed = 0;
    this.maxFallSpeed = 0;
    this.shouldExplode = false;
  }

  @Override
  protected void createParticleSpawner() {
    new ParticleSpawner((int) xcoord, (int) ycoord, 5000, 2, 10, Color.WHITE, Color.WHITE,
        Color.WHITE);
  }
}
