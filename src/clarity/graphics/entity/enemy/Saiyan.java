package clarity.graphics.entity.enemy;

import clarity.graphics.entity.SpriteSheet;
import clarity.graphics.tile.TileSet;
import clarity.state.Level;

import java.util.Random;

public class Saiyan extends Enemy {

  private int counter = 0;

  public Saiyan(int mobId) {
    super(mobId);
  }

  @Override
  public void move() {
    if (Math.abs(Level.getPlayer().getX() - xcoord) < TileSet.getTileSize() * CHASE_RANGE) {
      counter += 1;
      if (counter == 10) {
        counter = 0;
        Random rand = new Random();
        int movement = rand.nextInt(6);
        if (movement == 0) {
          isRight = false;
          isLeft = true;
          setJumping(false);
        }
        if (movement == 1) {
          isLeft = false;
          isRight = true;
          setJumping(false);
        }
        if (movement == 2) {
          setJumping(true);
        }
      }
    } else {
      isLeft = false;
      isRight = false;
      setJumping(false);
    }

  }

  @Override
  protected void defineAttackDamage() {
    attackDamage = 100;
  }

  @Override
  protected void defineSpriteSheet() {
    spriteSheet = SpriteSheet.SAIYAN;
  }

  @Override
  protected void defineCollisionWidth() {
    collisionWidth = 15;
  }

  @Override
  protected void defineCollisionHeight() {
    collisionHeight = 30;
  }

  @Override
  protected void defineMoveSpeed() {
    moveSpeed = 0.2;
  }

  @Override
  protected void defineMaxSpeed() {
    maxSpeed = 1.5;
  }

  @Override
  protected void defineStopSpeed() {
    stopSpeed = 0.4;
  }

  @Override
  protected void defineFallSpeed() {
    fallSpeed = 0.15;
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
