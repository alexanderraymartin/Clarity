package clarity.graphics.entity;

import clarity.state.Level;
import clarity.state.State;
import clarity.utilities.Timer;

import java.util.ArrayList;

public abstract class Projectile extends Entity {

  protected Entity source;
  protected double damage;
  private Timer life;

  private static final int DURATION = 10000; // 10 sedonds

  public Projectile(int mobId) {
    super(mobId);
    life = new Timer();
  }

  @Override
  public void update() {
    if (life.hasElapsed(DURATION)) {
      isDead = true;
    }
    getNextPosition();
    if (!checkTileCollision()) {
      if (facingRight) {
        isRight = true;
        isLeft = false;
      } else {
        isRight = false;
        isLeft = true;
      }

    } else {
      isDead = true;
    }
    enemyCollisionCheck();
    super.update();
  }

  /**
   * Check for collision.
   */
  public void enemyCollisionCheck() {
    ArrayList<Entity> allEntities = State.getEntities();

    allEntities.forEach((entity) -> {
      if (entity != Level.player && intersection(entity)) {
        entity.hit((int) this.damage);
        this.isDead = true;
      }
    });
  }
}
