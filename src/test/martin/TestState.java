package test.martin;

import clarity.graphics.entity.Entity;
import clarity.graphics.entity.particle.Particle;
import clarity.graphics.entity.projectile.Projectile;
import clarity.state.State;

import org.junit.Test;

import java.util.List;

public class TestState {

  @Test
  public void testGetEntities() {
    List<Entity> entities = null;
    entities = State.getEntities();

    assert (entities != null);
  }

  @Test
  public void testGetProjectiles() {
    List<Projectile> projectiles = null;
    projectiles = State.getProjectiles();

    assert (projectiles != null);
  }

  @Test
  public void testGetParticles() {
    List<Particle> particles = null;
    particles = State.getParticles();

    assert (particles != null);
  }


}
