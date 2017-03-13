package clarity.graphics.entity.powerup;

import clarity.graphics.entity.Projectile;
import clarity.graphics.entity.SpriteSheet;
import clarity.state.Level;

public class Fireball extends Projectile {

  public static final int ENERGY_COST = 10;

  public Fireball(int mobId) {
    super(mobId);
    init();
  }

  @Override
  protected void init() {
    this.source = Level.player;
    this.xcoord = source.getX();
    this.ycoord = source.getY();
    this.currentHealth = maxHealth = 100;

    this.spriteSheet = SpriteSheet.TORCH;
    this.collisionWidth = this.collisionHeight = 15;
    this.facingRight = this.source.isFacingRight();
    this.damage = 20;

    this.moveSpeed = 0.5;
    this.maxSpeed = 2;
    this.stopSpeed = 5;
    this.fallSpeed = 0;
    this.maxFallSpeed = 0;
    this.shouldExplode = false;
  }
}