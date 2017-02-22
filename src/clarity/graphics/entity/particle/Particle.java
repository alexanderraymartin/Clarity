package clarity.graphics.entity.particle;

import clarity.graphics.entity.Entity;

public class Particle extends Entity {
  double xpos;
  double ypos;
  int speed;

  /**
   * Particle Constructor.
   * @param xpos refers to the x position of particle
   * @param ypos refers to the y position of the particle
   * @param speed refers to the speed of the particle
   */
  public Particle(double xpos, double ypos, int speed) {
    this.xpos = xpos;
    this.ypos = ypos;
    this.speed = speed;
  }

  public double getX() {
    return xpos;
  }

  public double getY() {
    return ypos;
  }

  public int getSpeed() {
    return speed;
  }

}
