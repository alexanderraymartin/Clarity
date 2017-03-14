package clarity.graphics.entity;

import clarity.graphics.entity.particle.ParticleSpawner;
import clarity.graphics.entity.projectile.Fireball;
import clarity.state.Level;
import clarity.state.StateManager;
import clarity.utilities.Timer;
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

  private StateManager manager;

  /**
   * Player constructor.
   */
  public Player(StateManager manager) {
    super();
    this.manager = manager;
    facingRight = true;
    setPlayerControlled(true);
    setSpeedValues(0.3, 1.75, 0.4, 0.18, 4.0, -6.0, 0.5);
    setSpriteValues(SpriteSheet.PLAYER, 18, 30, 100, 100);

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
      new ParticleSpawner((int) xcoord, (int) ycoord, 1000, 1, 10, new Color[] {Color.RED});
    }
  }

  private void checkWin() {
    if ((int) (xcoord / tileSize) == Level.getWinLocation().getX() / tileSize
        && (int) (ycoord / tileSize) == Level.getWinLocation().getY() / tileSize) {
      Level.setLevelComplete(true);
    }
  }

  private void movePlayer() {
    if (manager.getKeyboard().leftPressed() && !manager.getKeyboard().rightPressed()) {
      setLeft(true);
    } else {
      setLeft(false);
    }
    if (manager.getKeyboard().rightPressed() && !manager.getKeyboard().leftPressed()) {
      setRight(true);
    } else {
      setRight(false);
    }
    if (manager.getKeyboard().upPressed()) {
      setJumping(true);
    } else {
      setJumping(false);
    }
    if (manager.getKeyboard().downPressed()) {
      setDown(true);
    } else {
      setDown(false);
    }
  }

  private void checkAbilities() {
    // Shooting a fireball
    if (Mouse.getMouse().buttonClickAndRelease() && getEnergy() - Fireball.ENERGY_COST >= 0) {
      setEnergy(getEnergy() - Fireball.ENERGY_COST);
      new Fireball();
    }
  }

}
