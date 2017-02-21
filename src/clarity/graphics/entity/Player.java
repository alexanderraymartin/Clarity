package clarity.graphics.entity;

public class Player extends Entity {

  private double movementSpeed;
  private double health;
  private double lightSource;
  private boolean left;
  private boolean right;
  private boolean up;
  private boolean down;

  public Player() {

  }

  /**
   * @param newLeft left input value.
   */
  public void setLeft(boolean newLeft) {
    left = newLeft;
  }

  /**
   * @param newUp up input value.
   */
  public void setUp(boolean newUp) {
    up = newUp;
  }

  /**
   * @param newDown down input value.
   */
  public void setDown(boolean newDown) {
    down = newDown;
  }

  /**
   * @param newRight right input value.
   */
  public void setRight(boolean newRight) {
    right = newRight;
  }

  public void update() {
    move();
  }

  private void move() {
    if (left) {
      xLocation = xLocation - movementSpeed;
    }
    if (right) {
      xLocation = xLocation + movementSpeed;
    }
    if (up) {
      yLocation = yLocation - movementSpeed;
    }
    if (down) {
      yLocation = yLocation + movementSpeed;
    }
  }

  /**
   * @return The x location.
   */
  public double getX() {
    return xLocation;
  }

  /**
   * @return The y location.
   */
  public double getY() {
    return yLocation;
  }
  
  /**
   * 
   * @param light value added to current lightSource value
   */
  private void gotLightSource(int light) {
    lightSource += light;
  }
  
  /*
   * health gained
   */
   private void gainHealth(int boost) {
     health += boost;
   }
   
   private void loseHealth(int damage) {
     health -= damage;
   }

}
