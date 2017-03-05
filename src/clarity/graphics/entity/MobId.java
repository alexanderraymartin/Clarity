package clarity.graphics.entity;

public class MobId {
  public static final int DUMMY = -1;
  public static final int PLAYER = 0;
  public static final int PLACE_HOLDER1 = PLAYER + 1;
  public static final int PLACE_HOLDER2 = PLACE_HOLDER1 + 1;
  public static final int[] MOB_IDS = {PLAYER, PLACE_HOLDER1, PLACE_HOLDER2};

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
      case PLACE_HOLDER1:
        return new Player(PLAYER);
      case PLACE_HOLDER2:
        return new Player(PLAYER);
      default:
        break;

    }
    return null;
  }
}
