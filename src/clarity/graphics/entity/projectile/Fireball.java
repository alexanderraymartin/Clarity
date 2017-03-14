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
  }

  @Override
  protected void createParticleSpawner() {
    new ParticleSpawner((int) xcoord, (int) ycoord, 5000, 2, 10, new Color[] {Color.RED});
  }

  @Override
  protected void defineDamage() {
    damage = 100;
  }

  @Override
  protected void defineSpriteSheet() {
    spriteSheet = SpriteSheet.FIREBALL;
  }

  @Override
  protected void defineCollisionWidth() {
    collisionWidth = 15;
  }

  @Override
  protected void defineCollisionHeight() {
    collisionHeight = 15;
  }

  @Override
  protected void defineMoveSpeed() {
    moveSpeed = 1;
  }

  @Override
  protected void defineMaxSpeed() {
    maxSpeed = 5;
  }

  @Override
  protected void defineStopSpeed() {
    stopSpeed = 5;
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
    jumpStart = -6.0;
  }

  @Override
  protected void defineStopJumpSpeed() {
    stopJumpSpeed = 0.5;
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
