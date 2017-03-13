package clarity.graphics.entity;

import clarity.graphics.entity.enemy.Ghost;
import clarity.graphics.entity.enemy.Saiyan;
import clarity.graphics.entity.enemy.Skeleton;
import clarity.graphics.entity.enemy.Zombie;
import clarity.graphics.entity.powerup.Fireball;
import clarity.state.Level;

public class MobId {

  public static final int DUMMY = -1;
  public static final int GHOST = 0;
  public static final int SAIYAN = 1;
  public static final int SKELETON = 2;
  public static final int ZOMBIE = 3;
  public static final int TORCH = 4;
  public static final int FIREBALL = 5;
  protected static final int[] MOB_IDS =
    {GHOST, SAIYAN, SKELETON, ZOMBIE, TORCH, FIREBALL};

  private MobId() {
  }

  /**
   * @param key The key of the entity.
   * @return An instance of the entity that matches the key.
   */
  public static Entity getEntity(int key) {
    switch (key) {
      case DUMMY:
        return null;
      case GHOST:
        return new Ghost(GHOST);
      case SAIYAN:
        return new Saiyan(SAIYAN);
      case SKELETON:
        return new Skeleton(SKELETON);
      case ZOMBIE:
        return new Zombie(ZOMBIE);
      case TORCH:
        return new Torch(TORCH);
      case FIREBALL:
        return new Fireball(FIREBALL);
      default:
        break;

    }
    return null;
  }
}
