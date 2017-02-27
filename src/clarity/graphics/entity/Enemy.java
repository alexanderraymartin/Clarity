package clarity.graphics.entity;

import java.util.Random;

public class Enemy extends Entity {
  protected SpriteSheet attack;
  private static final int UP = 0;
  private static final int RIGHT = 1;
  private static final int DOWN = 2;
  private static final int LEFT = 3;

  /**
   * Move the enemy.
   */

  public void move(long seed) {
    Random move = new Random();
    move.setSeed(seed);
    int next = Math.abs(move.nextInt());
    if (next % 4 == UP) {
      System.out.println("up");
      ycoord += moveSpeed;
    } else if (next % 4 == DOWN) {
      System.out.println("down");
      ycoord -= moveSpeed;
    } else if (next % 4 == RIGHT) {
      System.out.println("right");
      xcoord += moveSpeed;
    } else if (next % 4 == LEFT) {
      System.out.println("left");

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
