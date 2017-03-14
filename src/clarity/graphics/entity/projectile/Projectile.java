package clarity.graphics.entity.projectile;

import clarity.graphics.entity.Entity;
import clarity.state.State;
import clarity.utilities.Timer;
import clarity.utilities.Vector2d;

public abstract class Projectile extends Entity {

  protected Entity source;
  protected int damage;
  private Timer life;

  private static final int DURATION = 10000; // 10 seconds

  /**
   * @param source The source of the projectile.
   * @param mobId The projectile's ID.
   */
  public Projectile(Entity source, int mobId) {
    super(mobId);
    this.source = source;
    defineDamage();
    if (source.isFacingRight()) {
      setPosition(new Vector2d(source.getX() + source.getCollisionWidth(), source.getY()),
          source.isFacingRight());
      isRight = true;
    } else {
      setPosition(new Vector2d(source.getX() - source.getCollisionWidth(), source.getY()),
          source.isFacingRight());
      isLeft = true;
    }
    life = new Timer();
  }

  @Override
  public void update() {
    if (isDead || life.hasElapsed(DURATION)) {
      createParticleSpawner();
      State.getProjectiles().remove((Projectile) this);
    }
    getNextPosition();
    if (checkTileCollision() || checkEntityCollision()) {
      isDead = true;
      return;
    }
    setPosition(new Vector2d(xposition, yposition));
    if (isRight) {
      facingRight = true;
    }
    if (isLeft) {
      facingRight = false;
    }
    setAnimation(IDLE);
    animation.update();
  }

  /**
   * Check for collision.
   */
  protected boolean checkEntityCollision() {
    for (int i = 0; i < State.getEntities().size(); i++) {
      Entity target = State.getEntities().get(i);
      if (target.isDead() || target == source) {
        continue;
      }
      if (intersection(target)) {
        target.hit(damage);
        return true;
      }
    }
    return false;
  }

  protected abstract void defineDamage();
}
