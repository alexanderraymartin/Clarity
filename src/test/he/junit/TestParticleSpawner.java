package test.he.junit;

import clarity.graphics.entity.particle.ParticleSpawner;

import org.junit.Test;

import java.awt.Color;

/**
 * Test written by Wenmin He.
 */

public class TestParticleSpawner {

  @Test
  public void testParticleSpawner() {
    ParticleSpawner spawner =
        new ParticleSpawner(10, 10, 10, 10, 10, new Color[] {Color.RED, Color.BLACK, Color.BLUE});
    assert (spawner != null);
  }


}
