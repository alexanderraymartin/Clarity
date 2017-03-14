package clarity.graphics.entity;

import clarity.graphics.entity.particle.ParticleSpawner;
import clarity.graphics.entity.projectile.Fireball;
import clarity.state.Level;
import clarity.utilities.Timer;
import clarity.utilities.input.Keyboard;
import clarity.utilities.input.Mouse;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player extends Entity {
  /**
   * Duration of temporary immunity when the player is hit by an enemy.
   */
  private static final int TEMP_IMMUNITY_DURATION = 1000; // milliseconds

  /**
   * Timer for tracking the temporary immunity of the player.
   */
  public static final Timer TEMP_IMMUNITY_TIMER = new Timer();

  public Player() {
    super();
  }

  /**
   * (non-Javadoc)
   * 
   * @see clarity.graphics.entity.Entity#update()
   */
  public void update() {
    checkWin();
    checkImmunity();
    movePlayer();
    checkAbilities();
    super.update();
  }

  /**
   * @param graphics The graphics.
   */
  public void render(Graphics2D graphics) {
    super.render(graphics);
    if (isImmune()) {
      displayImmunity(graphics);
    }

  }

  private void checkImmunity() {
    if (TEMP_IMMUNITY_TIMER.hasElapsed(TEMP_IMMUNITY_DURATION)) {
      setImmune(false);
    }
  }

  private void displayImmunity(Graphics2D graphics) {
    graphics.setColor(Color.WHITE);
    graphics.drawOval((int) (xcoord + xmap - spriteWidth / 2),
        (int) (ycoord + ymap - spriteHeight / 2), spriteWidth, spriteHeight);
  }

  /**
   * @param damage Amount of damage entity takes.
   */
  public void hit(int damage) {
    if (!isImmune() && !isDead) {
      setImmune(true);
      TEMP_IMMUNITY_TIMER.reset();
      currentHealth -= damage;
      if (currentHealth <= 0) {
        isDead = true;
      }
      new ParticleSpawner((int) xcoord, (int) ycoord, 1000, 1, 3, Color.RED, Color.RED, Color.RED);
    }
  }

  private void checkWin() {
    if ((int) (xcoord / tileSize) == Level.getWinLocation().getX() / tileSize) {
      if ((int) (ycoord / tileSize) == Level.getWinLocation().getY() / tileSize) {
        Level.levelComplete = true;
      }
    }
  }

  private void movePlayer() {
    if (Keyboard.leftPressed() && !Keyboard.rightPressed()) {
      setLeft(true);
    } else {
      setLeft(false);
    }
    if (Keyboard.rightPressed() && !Keyboard.leftPressed()) {
      setRight(true);
    } else {
      setRight(false);
    }
    if (Keyboard.upPressed()) {
      setJumping(true);
    } else {
      setJumping(false);
    }
    if (Keyboard.downPressed()) {
      setDown(true);
    } else {
      setDown(false);
    }
  }

  private void checkAbilities() {
    // Shooting a fireball
    if (Mouse.buttonClickAndRelease()) {
      if (getEnergy() - Fireball.ENERGY_COST >= 0) {
        setEnergy(getEnergy() - Fireball.ENERGY_COST);
        new Fireball();
      }
    }
  }

  /**
   * @param boost The amount of health gained.
   */
  public void gainHealth(int boost) {
    currentHealth += boost;
  }

  protected void init() {
    spriteSheet = SpriteSheet.PLAYER;
    collisionWidth = 18;
    collisionHeight = 30;
    // movement speeds
    moveSpeed = 0.3;
    maxSpeed = 1.75;
    stopSpeed = 0.4;
    // falling speeds
    fallSpeed = 0.18;
    maxFallSpeed = 4.0;
    // jumping speeds
    jumpStart = -6.0;
    stopJumpSpeed = 0.5;
    facingRight = true;
    currentHealth = maxHealth = 100;
    currentEnergy = maxEnergy = 100;
    setPlayerControlled(true);
  }

}
