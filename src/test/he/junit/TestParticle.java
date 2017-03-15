package test.he.junit;

import static org.junit.Assert.assertEquals;

import clarity.graphics.entity.particle.Particle;

import org.junit.Test;

import java.awt.Color;

/**
 * Test written by Wenmin He.
 */

public class TestParticle {

  @Test
  public void particleGetterX() {
    Particle particle = new Particle(10, 10, 10, 10, Color.RED);
    assertEquals((double) 10, particle.getX(), 0);
  }

  @Test
  public void particleGetterY() {
    Particle particle = new Particle(10, 10, 10, 10, Color.RED);
    assertEquals((double) 10, particle.getY(), 0);
  }

  @Test
  public void particleGetterFallSpeed() {
    Particle particle = new Particle(10, 10, 10, 10, Color.RED);

    assertEquals((double) 0.075, particle.getFallSpeed(), 0);
  }

}
