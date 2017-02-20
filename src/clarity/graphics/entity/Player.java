package clarity.graphics.entity;

public class Player extends Entity {

  private double size;
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
      xlocation = xlocation - movementSpeed;
    }
    if (right) {
      xlocation = xlocation + movementSpeed;
    }
    if (up) {
      ylocation = ylocation - movementSpeed;
    }
    if (down) {
      ylocation = ylocation + movementSpeed;
    }
  }

  /**
   * @return The x location.
   */
  public double getX() {
    return xlocation;
  }

  /**
   * @return The y location.
   */
  public double getY() {
    return ylocation;
  }

}
