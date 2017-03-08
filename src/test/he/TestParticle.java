package test.he;

import static org.junit.Assert.assertEquals;

import clarity.graphics.entity.particle.Particle;

import org.junit.Test;

import java.awt.Color;


public class TestParticle {

  @Test
  public void particleGetterX() {
    Particle particle = new Particle(10, 10, 10, 10, Color.RED);
    assertEquals((double) 10, particle.getX(), 0);
  }

  public void particleGetterY() {
    Particle particle = new Particle(10, 10, 10, 10, Color.RED);
    assertEquals((double) 10, particle.getY(), 0);
  }

}
