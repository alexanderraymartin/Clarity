package test.he;

import static org.junit.Assert.assertEquals;

import clarity.graphics.entity.particle.Particle;
import clarity.graphics.entity.particle.ParticleSpawner;
import java.util.ArrayList;
import org.junit.Test;

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
