package clarity.graphics.entity.particle;

import java.util.ArrayList;

public class ParticleSpawner {
  ArrayList<Particle> particlearray;

  public ParticleSpawner() {
    particlearray = new ArrayList<Particle>();
  }

  public ArrayList<Particle> getArray() {
    return particlearray;
  }

  public void addParticle(Particle particle) {
    particlearray.add(particle);
  }
}
