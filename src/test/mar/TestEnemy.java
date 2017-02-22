package test.mar;

import static org.junit.Assert.assertNotEquals;

import clarity.graphics.entity.Enemy;

import org.junit.Test;

public class TestEnemy {

  @Test
  public void testRandomMove() {
    Enemy enemy = new Enemy();
    enemy.xlocation = 20;
    enemy.ylocation = 20;
    enemy.move();

    assertNotEquals(enemy.xlocation, 20);
    assertNotEquals(enemy.ylocation, 20);
  }
}
