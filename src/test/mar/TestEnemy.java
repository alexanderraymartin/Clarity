package test.mar;

import clarity.graphics.entity.Enemy;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestEnemy {

  @Test
  public void TestRandomMove() {
    Enemy e = new Enemy();
    e.xLocation = 20;
    e.yLocation = 20;
    e.move();
    
    assertNotEquals (e.xLocation, 20);
    assertNotEquals (e.yLocation, 20);
  }
}
