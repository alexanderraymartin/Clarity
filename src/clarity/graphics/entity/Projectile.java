package clarity.graphics.entity;

import clarity.state.Level;
import clarity.state.State;
import java.util.ArrayList;

public abstract class Projectile extends Entity {

  protected Entity source;
  protected double damage;

  public Projectile(int mobId) {
    super(mobId);
  }

  @Override
  public void update() {
    if (!checkTileCollision()) {
      if (this.facingRight) {
        isRight = true;
        isLeft = false;
      } else {
        isRight = false;
        isLeft = true;
      }

    } else {
      this.isDead = true;
      System.out.println("Colliding with tile");
    }
    enemyCollisionCheck();
  }

  public void enemyCollisionCheck() {
    ArrayList<Entity> allEntities = State.getEntities();

    allEntities.forEach((entity) -> {
      if (entity != Level.player && intersection(entity)) {
        entity.hit((int) this.damage);
        this.isDead = true;
      }
    });
    super.update();
  }
}
