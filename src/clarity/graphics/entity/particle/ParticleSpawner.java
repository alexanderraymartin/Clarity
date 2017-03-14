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
   * @param colorOne The color of the first group of particle.
   * @param colorTwo The color of the second group of particles.
   * @param colorThree The color of the third group of particle.
   */
  public ParticleSpawner(int xcoord, int ycoord, int life, int size, int amount, Color colorOne,
      Color colorTwo, Color colorThree) {
    this.xcoord = xcoord;
    this.ycoord = ycoord;
    for (int i = 0; i < amount; i++) {
      new Particle(xcoord, ycoord, life, size, colorOne);
    }
    for (int i = 0; i < amount; i++) {
      new Particle(xcoord, ycoord, life, size, colorTwo);
    }
    for (int i = 0; i < amount; i++) {
      new Particle(xcoord, ycoord, life, size, colorThree);
    }
    Level.getEntities().remove(this);
  }

  @Override
  protected void init() {
    // SonarQube
  }

  @Override
  public void update() {
    // SonarQube
  }

  @Override
  public void render(Graphics2D graphics) {
    // SonarQube
  }
}
