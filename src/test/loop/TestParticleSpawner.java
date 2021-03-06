package test.loop;

import static org.junit.Assert.assertEquals;

import clarity.graphics.entity.particle.ParticleSpawner;

import java.awt.Color;

import org.junit.Test;

public class TestParticleSpawner {

  // There is no upper limites
  @Test
  public void neverExecute() {
    ParticleSpawner ps =
        new ParticleSpawner(10, 10, 10, 10, 0, new Color[] {Color.RED, Color.BLACK, Color.BLUE});
    assertEquals((double) 10, ps.getX(), 0.0);
  }

  @Test
  public void executeOnce() {
    ParticleSpawner ps =
        new ParticleSpawner(10, 10, 10, 10, 1, new Color[] {Color.RED, Color.BLACK, Color.BLUE});
    assertEquals((double) 10, ps.getX(), 0.0);
  }

  @Test
  public void executeTwice() {
    ParticleSpawner ps =
        new ParticleSpawner(10, 10, 10, 10, 2, new Color[] {Color.RED, Color.BLACK, Color.BLUE});
    assertEquals((double) 10, ps.getX(), 0.0);
  }

  @Test
  public void executesevenTimes() {
    ParticleSpawner ps =
        new ParticleSpawner(10, 10, 10, 10, 10, new Color[] {Color.RED, Color.BLACK, Color.BLUE});
    assertEquals((double) 10, ps.getX(), 0.0);
  }

}
