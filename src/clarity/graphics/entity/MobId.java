package clarity.graphics.entity;

import clarity.graphics.entity.enemy.Ghost;
import clarity.graphics.entity.enemy.Saiyan;
import clarity.graphics.entity.enemy.Skeleton;
import clarity.graphics.entity.enemy.Zombie;

public class MobId {
  public static final int DUMMY = -1;
  public static final int PLAYER = 0;
  public static final int GHOST = 1;
  public static final int SAIYAN = 2;
  public static final int SKELETON = 3;
  public static final int ZOMBIE = 4;
  public static final int[] MOB_IDS = {PLAYER, GHOST, SAIYAN, SKELETON, ZOMBIE};

  private MobId() {}

  /**
   * @param key The key of the entity.
   * @return An instance of the entity that matches the key.
   */
  public static Entity getEntity(int key) {
    switch (key) {
      case DUMMY:
        return null;
      case PLAYER:
        return new Player(PLAYER);
      case GHOST:
        return new Ghost(GHOST);
      case SAIYAN:
        return new Saiyan(SAIYAN);
      case SKELETON:
        return new Skeleton(SKELETON);
      case ZOMBIE:
        return new Zombie(ZOMBIE);
      default:
        break;

    }
    return null;
  }
}
