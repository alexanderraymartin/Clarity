package test.he;

import clarity.graphics.entity.particle.ParticleSpawner;

import org.junit.Test;

public class TestParticleSpawner {

  @Test
  public void testParticleSpawner() {
    ParticleSpawner spawner = new ParticleSpawner(10, 10, 10, 10, 10);
    assert (spawner != null);
  }


}
