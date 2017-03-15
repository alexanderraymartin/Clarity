package test.ho.integration;

import static org.junit.Assert.assertEquals;

import clarity.graphics.entity.Entity;
import clarity.graphics.entity.MobId;
import org.junit.Test;

/**
 * This test was written by Calvin Ho.
 */
public class TestSkeletonMobId {

  @Test
  public void checkSkeletonMobId() {
    Entity testSkeleton = MobId.getEntity(MobId.SKELETON);
    assertEquals(MobId.SKELETON, testSkeleton.getMobId());
  }

}
