package clarity.graphics.entity;

import clarity.state.Level;
import clarity.utilities.input.Keyboard;

public class Player extends Entity {

  private double lightSource = 100;


  public Player(int mobId) {
    super(mobId);
  }

  // TODO REMOVE for test cases
  public Player() {

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
    spriteSheet = SpriteSheet.player;
    collisionWidth = 20;
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
