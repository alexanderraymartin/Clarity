package test.martin;

import clarity.graphics.entity.Entity;
import clarity.graphics.entity.particle.Particle;
import clarity.graphics.entity.projectile.Projectile;
import clarity.state.Level;
import clarity.state.State;
import clarity.state.StateManager;

import org.junit.Test;

import java.util.ArrayList;

public class TestState {

  @Test
  public void testConstructor() {
    StateManager stateManager = new StateManager();
    State currentState = new Level(stateManager);

    assert (currentState instanceof Level);
  }

  @Test
  public void testGetEntities() {
    ArrayList<Entity> entities = null;
    entities = State.getEntities();

    assert (entities != null);
  }

  @Test
  public void testGetProjectiles() {
    ArrayList<Projectile> projectiles = null;
    projectiles = State.getProjectiles();

    assert (projectiles != null);
  }

  @Test
  public void testGetParticles() {
    ArrayList<Particle> particles = null;
    particles = State.getParticles();

    assert (particles != null);
  }


}
