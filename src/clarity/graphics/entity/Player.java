package clarity.graphics.entity;

import clarity.graphics.entity.particle.ParticleSpawner;
import clarity.state.Level;
import clarity.utilities.Timer;
import clarity.utilities.input.Keyboard;

public class Player extends Entity {
  /**
   * Duration of temporary immunity when the player is hit by an enemy.
   */
  private static final int TEMP_IMMUNITY_DURATION = 2000; // milliseconds

  /**
   * Timer for tracking the temporary immunity of the player.
   */
  public Timer tempImmunityTimer = new Timer();

  private double lightSource = 100;

  public Player(int mobId) {
    super(mobId);
  }

  /**
   * (non-Javadoc)
   * 
   * @see clarity.graphics.entity.Entity#update()
   */
  public void update() {
    checkWin();
    movePlayer();
    super.update();
  }

  /**
   * @param damage Amount of damage entity takes.
   */
  public void hit(int damage) {
    if (!isImmune) {
      isImmune = true;
      tempImmunityTimer.reset();
      currentHealth -= damage;
      if (currentHealth <= 0) {
        isDead = true;
      }
      new ParticleSpawner((int) xcoord, (int) ycoord, 1000, 1, 10);
    }
    // TODO Differentiate between temporary immunity from being hit and power up
    if (tempImmunityTimer.hasElapsed(TEMP_IMMUNITY_DURATION)) {
      isImmune = false;
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

  /**
   * @param boost The amount of health gained.
   */
  public void gainHealth(int boost) {
    currentHealth += boost;
  }

  /**
   * @param light Value added to current lightSource value.
   */
  public void gainLightSource(int light) {
    lightSource += light;
  }


  public double getLight() {
    return lightSource;
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
    fallSpeed = 0.15;
    maxFallSpeed = 4.0;
    // jumping speeds
    jumpStart = -6.0;
    stopJumpSpeed = 0.5;
    facingRight = true;
    currentHealth = maxHealth = 100;
    currentEnergy = maxEnergy = 100;
    isPlayerControlled = true;
  }

}
