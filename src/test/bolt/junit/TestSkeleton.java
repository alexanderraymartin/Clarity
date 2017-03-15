package test.bolt.junit;

// Dustin Bolt

import clarity.graphics.entity.MobId;
import clarity.graphics.entity.enemy.Skeleton;

import org.junit.Test;

public class TestSkeleton {
  @Test
  public void testSkeletonCreation() {
    Skeleton enemy = new Skeleton(MobId.SKELETON);

    assert (enemy != null);
  }


}
