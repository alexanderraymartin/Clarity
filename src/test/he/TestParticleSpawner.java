package test.he;

import clarity.graphics.entity.particle.ParticleSpawner;

import org.junit.Test;

import java.awt.Color;

public class TestParticleSpawner {

  @Test
  public void testParticleSpawner() {
    ParticleSpawner spawner =
        new ParticleSpawner(10, 10, 10, 10, 10, Color.RED, Color.RED, Color.RED);
    assert (spawner != null);
  }


}
