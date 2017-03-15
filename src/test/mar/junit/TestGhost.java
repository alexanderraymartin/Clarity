package test.mar.junit;


import clarity.graphics.entity.MobId;
import clarity.graphics.entity.enemy.Ghost;

import org.junit.Test;

// Jason Mar

public class TestGhost {

  @Test
  public void testGhostCreation() {
    Ghost enemy = new Ghost(MobId.GHOST);

    assert (enemy != null);
  }

}
