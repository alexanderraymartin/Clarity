package clarity.graphics.entity.particle;

import clarity.graphics.entity.Entity;
import clarity.state.Level;

import java.awt.Color;
import java.awt.Graphics2D;

public class ParticleSpawner extends Entity {

  /**
   * @param xcoord The x position of the particle.
   * @param ycoord The y position of the particle.
   * @param life The life of the particle.
   * @param size The size in pixels.
   * @param amount The number of particles.
   */
  public ParticleSpawner(int xcoord, int ycoord, int life, int size, int amount) {
    this.xcoord = xcoord;
    this.ycoord = ycoord;
    for (int i = 0; i < amount; i++) {
      new Particle(xcoord, ycoord, life, size, Color.red);
    }
    for (int i = 0; i < amount; i++) {
      new Particle(xcoord, ycoord, life, size, Color.pink);
    }
    for (int i = 0; i < amount; i++) {
      new Particle(xcoord, ycoord, life, size, Color.gray);
    }
    Level.getEntities().remove(this);
  }

  protected void init() {}

  public void update() {}

  public void render(Graphics2D graphics) {

  }
}
