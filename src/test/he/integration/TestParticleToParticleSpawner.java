package test.he.integration;

import static org.junit.Assert.assertEquals;

import clarity.graphics.entity.particle.ParticleSpawner;
import clarity.state.State;

import org.junit.Test;

import java.awt.Color;

public class TestParticleToParticleSpawner {

  @Test
  public void testParticleToParticleSpawnerIntegration() {
    Color[] colors = new Color[]{Color.red};
    ParticleSpawner particlesp = new ParticleSpawner(10, 10, 10, 10, 1, colors);
    assertEquals((double) 10, State.getParticles().get(0).getX(), 0);
  }

//  @Test
//  public void testParticleToParticleSpawnerIntegration() {
//    Color[] colors = new Color[]{Color.red};
//    ParticleSpawner particlesp = new ParticleSpawner(10, 10, 10, 10, 1, colors);
//    assertEquals((double) 10, State.getParticles().get(0).getX(), 0);
//  }

}
