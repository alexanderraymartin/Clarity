package clarity.graphics.entity;

import java.util.Random;

public class Enemy extends Entity {
  protected Sprite attack;
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
      ylocation += movementSpeed;
    }
    if (next == DOWN) {
      ylocation -= movementSpeed;
    }
    if (next == RIGHT) {
      xlocation += movementSpeed;
    }
    if (next == LEFT) {
      xlocation += movementSpeed;
    }
    if (xlocation < 0) {
      xlocation = 0;
    }
    if (ylocation < 0) {
      ylocation = 0;
    }
  }

}
