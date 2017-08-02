package test.he.junit;

import clarity.graphics.entity.particle.ParticleSpawner;

import java.awt.Color;

import org.junit.Test;

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
