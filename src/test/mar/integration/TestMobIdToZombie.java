package test.mar.integration;

import clarity.graphics.entity.MobId;
import clarity.graphics.entity.enemy.Zombie;

import org.junit.Test;

// Jason Mar

public class TestMobIdToZombie {
  
  @Test
  public void TestMobtoZombie() {
    Zombie zombie = (Zombie) MobId.getEntity(MobId.ZOMBIE);
    assert(zombie instanceof Zombie);
  }
}

