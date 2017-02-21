package clarity.graphics.entity;

import java.util.Random;

public class Enemy extends Entity {
  private Sprite attack;
  static final int UP = 1;
  static final int RIGHT = 2;
  static final int DOWN = 3;
  static final int LEFT = 4;

  public void move() {
    Random move = new Random();
    int next = move.nextInt(5);
    if(next == UP) {
      yLocation += movementSpeed;
    }
    if(next == DOWN) {
      yLocation -= movementSpeed;
    }
    if(next == RIGHT) {
      xLocation +=  movementSpeed;
    }
    if(next == LEFT) {
      xLocation += movementSpeed;
    }
    if(xLocation < 0) {
      xLocation = 0;
    }
    if(yLocation < 0) {
      yLocation = 0;
    }
  }

}
