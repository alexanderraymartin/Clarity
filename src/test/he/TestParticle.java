package test.he;

import static org.junit.Assert.assertEquals;

import clarity.graphics.entity.particle.Particle;

import org.junit.Test;


public class TestParticle {

  @Test
  public void particleGetterX() {
    Particle particle = new Particle(10, 10, 10);
    assertEquals((double) 10, particle.getX(), 0);
  }

  public void particleGetterY() {
    Particle particle = new Particle(10, 10, 10);
    assertEquals((double) 10, particle.getY(), 0);
  }

  public void particleGetterSpeed() {
    Particle particle = new Particle(10, 10, 10);
    assertEquals((double) 10, particle.getSpeed(), 0);
  }
}
