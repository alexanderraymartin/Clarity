package clarity.graphics.entity;

import clarity.state.Level;
import clarity.utilities.input.Keyboard;

public class Player extends Entity {

  private double lightSource = 100;


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

  }

}
