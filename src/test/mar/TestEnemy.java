package test.mar;

import static org.junit.Assert.assertNotEquals;

import clarity.graphics.entity.Enemy;

import org.junit.Test;

public class TestEnemy {

  @Test
  public void testRandomMove() {
    Enemy enemy = new Enemy();
    enemy.xcoord = 20;
    enemy.ycoord = 20;
    enemy.move();

    assertNotEquals(enemy.xcoord, 20);
    assertNotEquals(enemy.ycoord, 20);
  }
}
