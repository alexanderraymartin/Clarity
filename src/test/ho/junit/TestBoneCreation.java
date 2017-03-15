package test.ho.junit;

import clarity.graphics.entity.MobId;
import clarity.graphics.entity.projectile.Bone;
import org.junit.Test;

/**
 * Test written by Calvin Ho.
 */
public class TestBoneCreation {

  @Test
  public void testBoneNotNull() {
    Bone testBone = new Bone(MobId.getEntity(MobId.SKELETON), MobId.DUMMY);
    assert (testBone != null);
  }
}

