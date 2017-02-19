package clarity.graphics.entity;

public class Player extends Entity {

  private double size;
  private double movementSpeed;
  private double health;
  private double lightSource;
  private boolean left, right, up, down;

  public Player() {
    
  }
  
  /**
   * @param newLeft left input value
   */
  public void setLeft(boolean newLeft) {
     left = newLeft; 
  }
  
  /**
   * @param newUp up input value
   */
  public void setUp(boolean newUp) {
     up = newUp;
  }
  
  /**
   * @param newDown down input value
   */
  public void setDown(boolean newDown) {
     down = newDown;
  }
  
  /**
   * @param newRight right input value
   */
  public void setRight(boolean newRight) {
     right = newRight;
  }
  
  public void update() {
    move();
  }
  
  private void move() {
    if(left){
      xLocation = xLocation - movementSpeed;
    }
    if(right){
      xLocation = xLocation + movementSpeed;
    }
    if(up){
      yLocation = yLocation - movementSpeed;
    }
    if(down){
      yLocation = yLocation + movementSpeed;
    }
  }
  
  public double getX(){
    return xLocation;
 }

 public double getY(){
    return yLocation;
 }

}
