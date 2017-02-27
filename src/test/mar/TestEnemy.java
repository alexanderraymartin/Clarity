package test.mar;


import static org.junit.Assert.assertEquals;

import clarity.graphics.entity.Enemy;

import org.junit.Test;


public class TestEnemy {

  @Test
  public void testRandomMoveUp() {
    Enemy enemy = new Enemy();
    long seed = 1;  // 1 down
    enemy.xcoord = 0;
    enemy.ycoord = 0;
    enemy.move(seed);

    assertEquals(enemy.ycoord, 1, 0);
  }
  
  @Test
  public void testRandomMoveLeft() {
    Enemy enemy = new Enemy();
    long seed = 3;  // 3 up
    enemy.xcoord = 0;
    enemy.ycoord = 0;
    enemy.move(seed);

    assertEquals(enemy.xcoord, 0, 0);
  }
  
  @Test
  public void testRandomMoveRight() {
    Enemy enemy = new Enemy();
    long seed = 123; // 123 right
    enemy.xcoord = 0;
    enemy.ycoord = 0;
    enemy.move(seed);

    assertEquals(enemy.xcoord, 1, 0);
  }
  
  @Test
  public void testRandomMove() {
    Enemy enemy = new Enemy();
    long seed = 12332123; // 123 down
    enemy.xcoord = 0;
    enemy.ycoord = 0;
    enemy.move(seed);

    assertEquals(enemy.xcoord, 1, 0);
  }
}
