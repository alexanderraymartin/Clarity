package clarity.graphics.entity.particle;

import clarity.graphics.entity.Entity;
import clarity.graphics.entity.Sprite;

public class Particle extends Entity {
  double xpos;
  double ypos;
  Sprite sprite;
  int speed;
  
  public Particle(double xpos, double ypos, Sprite sprite, int speed) {
    this.xpos = xpos;
    this.ypos = ypos;
    this.sprite = sprite;
    this.speed = speed;
  }

  public double getX() {
    return xpos;
  }

  public double getY() {
    return ypos;
  }

  public Sprite getSprite() {
    return sprite;
  }

  public int getSpeed() {
    return speed;
  }
}
