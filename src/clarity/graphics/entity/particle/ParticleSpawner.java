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
   * @param colors The colors of each group of particles.
   */
  public ParticleSpawner(int xcoord, int ycoord, int life, int size, int amount, Color[] colors) {
    this.xcoord = xcoord;
    this.ycoord = ycoord;

    for (int i = 0; i < colors.length; i++) {
      for (int j = 0; j < amount; j++) {
        new Particle(xcoord, ycoord, life, size, colors[i]);
      }
    }
    Level.getEntities().remove(this);
  }

  @Override
  public void update() {
    // SonarQube
  }

  @Override
  public void render(Graphics2D graphics) {
    // SonarQube
  }

  @Override
  protected void defineSpriteSheet() {
    // SonarQube
  }

  @Override
  protected void defineCollisionWidth() {
    // SonarQube
  }

  @Override
  protected void defineCollisionHeight() {
    // SonarQube
  }

  @Override
  protected void defineMoveSpeed() {
    // SonarQube
  }

  @Override
  protected void defineMaxSpeed() {
    // SonarQube
  }

  @Override
  protected void defineStopSpeed() {
    // SonarQube
  }

  @Override
  protected void defineFallSpeed() {
    // SonarQube
  }

  @Override
  protected void defineMaxFallSpeed() {
    // SonarQube
  }

  @Override
  protected void defineJumpStart() {
    // SonarQube
  }

  @Override
  protected void defineStopJumpSpeed() {
    // SonarQube
  }

  @Override
  protected void defineCurrentAndMaxHealth() {
    // SonarQube
  }

  @Override
  protected void defineCurrentAndMaxEnergy() {
    // SonarQube
  }
}
