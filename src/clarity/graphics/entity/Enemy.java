package clarity.graphics.entity;

import java.util.Random;

public class Enemy extends Entity {
  protected SpriteSheet attack;
  private static final int UP = 1;
  private static final int RIGHT = 2;
  private static final int DOWN = 3;
  private static final int LEFT = 4;

  /**
   * Move the enemy.
   */
  public void move() {
    Random move = new Random();
    int next = move.nextInt(5);
    if (next == UP) {
      ycoord += moveSpeed;
    }
    if (next == DOWN) {
      ycoord -= moveSpeed;
    }
    if (next == RIGHT) {
      xcoord += moveSpeed;
    }
    if (next == LEFT) {
      xcoord += moveSpeed;
    }
    if (xcoord < 0) {
      xcoord = 0;
    }
    if (ycoord < 0) {
      ycoord = 0;
    }
  }

  protected void init() {

  }

}
