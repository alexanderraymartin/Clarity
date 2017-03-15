package test.mar.integration;

import clarity.graphics.entity.MobId;
import clarity.graphics.entity.enemy.Ghost;

import org.junit.Test;

// Jason Mar

public class TestMobIdToGhost {

  @Test
  public void testMobToGhost() {
    Ghost ghost = (Ghost) MobId.getEntity(MobId.GHOST);
    assert (ghost instanceof Ghost);
  }

}
