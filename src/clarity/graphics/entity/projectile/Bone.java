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
    dy = -4;
  }

  @Override
  protected void createParticleSpawner() {
    new ParticleSpawner((int) xcoord, (int) ycoord, 5000, 2, 10, new Color[] {Color.WHITE});
  }

  @Override
  protected void defineDamage() {
    damage = 20;
  }

  @Override
  protected void defineSpriteSheet() {
    spriteSheet = SpriteSheet.BONE;
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
    maxSpeed = 2.5;
  }

  @Override
  protected void defineStopSpeed() {
    stopSpeed = 5;
  }

  @Override
  protected void defineFallSpeed() {
    fallSpeed = 0.10;
  }

  @Override
  protected void defineMaxFallSpeed() {
    maxFallSpeed = 4.0;
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
