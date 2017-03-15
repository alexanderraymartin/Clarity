package test.ho.junit;

import static org.junit.Assert.assertEquals;

import clarity.graphics.entity.MobId;
import clarity.graphics.entity.projectile.Bone;
import org.junit.Test;

/**
 * Test written by Calvin Ho.
 */
public class TestBone {

  @Test
  public void testBoneNotNull() {
    Bone testBone = new Bone(MobId.getEntity(MobId.SKELETON), MobId.DUMMY);
    assert (testBone != null);
  }

  @Test
  public void testBoneEnergy() {
    Bone testBone = new Bone(MobId.getEntity(MobId.SKELETON), MobId.DUMMY);
    testBone.setEnergy(50);
    int boneEnergy = (int) testBone.getEnergy();

    assertEquals(50, boneEnergy);
  }

}

