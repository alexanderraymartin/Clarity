package test.wenmin;

import static org.junit.Assert.*;

import clarity.graphics.entity.particle.Particle;
import clarity.graphics.entity.particle.ParticleSpawner;

import org.junit.Test;

import java.util.ArrayList;


public class TestParticleSpawner {

  @Test
  public void particleSpawnerAdd() {
    Particle particle = new Particle(10, 10, 10);
    ArrayList<Particle> arr = new ArrayList<Particle>();
    ParticleSpawner ps = new ParticleSpawner();
    ps.addParticle(particle);
    arr.add(particle);
    assertEquals(arr, ps.getArray());
  }
  
  @Test
  public void particleSpawnerGet() {
    ArrayList<Particle> arr = new ArrayList<Particle>();
    ParticleSpawner ps = new ParticleSpawner();
    assertEquals(arr, ps.getArray());
  }

}
