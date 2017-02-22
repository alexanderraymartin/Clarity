package clarity.graphics.entity;

public class Player extends Entity {

  private double movementSpeed;
  private double health = 100;
  private double lightSource = 100;
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
  public void gotLightSource(int light) {
    lightSource += light;
  }
  
  /*
   * health gained
   */
   public void gainHealth(int boost) {
     health += boost;
   }
   
   private void loseHealth(int damage) {
     health -= damage;
   }
   
   public double getHealth() {
     return health;
   }
   
   public double getLight(){
     return lightSource;
   }

}
