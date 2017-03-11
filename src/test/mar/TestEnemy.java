package test.mar;


import clarity.graphics.entity.MobId;
import clarity.graphics.entity.enemy.Ghost;

import org.junit.Test;


public class TestEnemy {

  @Test
  public void testGhostCreation() {
    Ghost enemy = new Ghost(MobId.GHOST);

    assert (enemy != null);
  }

}
