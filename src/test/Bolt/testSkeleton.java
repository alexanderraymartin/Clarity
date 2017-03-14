package test.Bolt;

import org.junit.Test;

import clarity.graphics.entity.MobId;
import clarity.graphics.entity.enemy.Skeleton;

public class testSkeleton {
	  @Test
	  public void testSkeletonCreation() {
	    Skeleton enemy = new Skeleton(MobId.SKELETON);

	    assert (enemy != null);
	  }


}
