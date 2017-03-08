package clarity.graphics.entity.particle;

import clarity.graphics.entity.Entity;
import clarity.state.Level;
import clarity.utilities.Timer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Particle extends Entity {
  private int life;
  private Timer timer;
  private Random random;
  private int size;
  private Color color;

  /**
   * @param xcoord The x position of the particle.
   * @param ycoord The y position of the particle.
   * @param life The life of the particle.
   * @param size The size in pixels.
   * @param color The color of the particle.
   */
  public Particle(int xcoord, int ycoord, int life, int size, Color color) {
    super();
    timer = new Timer();
    random = new Random();
    this.xcoord = xcoord;
    this.ycoord = ycoord;
    this.size = size;
    this.color = color;
    fallSpeed = 0.075;
    maxFallSpeed = 4.0;
    collisionWidth = collisionHeight = size;
    this.life = life + (random.nextInt(1000));
    dx = random.nextGaussian();
    dy = random.nextGaussian() * maxFallSpeed;
  }

  /**
   * (non-Javadoc)
   * 
   * @see clarity.graphics.entity.Entity#update()
   */
  public void update() {
    if (timer.hasElapsed(life)) {
      Level.getParticles().remove(this);
    }
    move();
    dy += fallSpeed;
    if (dy > maxFallSpeed) {
      dy = maxFallSpeed;
    }
  }

  private void move() {
    this.xcoord += dx;
    this.ycoord += dy;
  }

  /**
   * (non-Javadoc)
   * 
   * @see clarity.graphics.entity.Entity#render(java.awt.Graphics2D)
   */
  public void render(Graphics2D graphics) {
    checkTileCollision();
    setMapPosition();
    graphics.setColor(color);
    if (onScreen()) {
      graphics.fill(new Rectangle((int) (xcoord + xmap), (int) (ycoord + ymap), size, size));
    }
  }

  protected void init() {

  }

}
