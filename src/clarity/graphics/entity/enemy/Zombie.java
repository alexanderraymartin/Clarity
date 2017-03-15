package clarity.graphics.entity.enemy;

import clarity.graphics.entity.SpriteSheet;
import clarity.graphics.tile.TileSet;
import clarity.state.Level;

public class Zombie extends Enemy {

  private double previousX = 0;

  /**
   * @param mobId The mobID.
   */
  public Zombie(int mobId) {
    super(mobId);
    setSpeedValues(0.1, 1.75, 0.1, 0.15, 4.0, -10.0, 0.1);
    setSpriteValues(SpriteSheet.ZOMBIE, 20, 30, 100, 100);
    setAttackDamage(30);
  }

  @Override
  public void move() {
    if (Math.abs(Level.getPlayer().getX() - xcoord) < TileSet.getTileSize() * CHASE_RANGE) {
      double changeX = Math.abs(previousX - xcoord);
      if (Level.getPlayer().getX() < xcoord) {
        isRight = false;
        isLeft = true;
      } else {
        isLeft = false;
        isRight = true;
      }
      double ydistance = Math.abs(Level.getPlayer().getY()) - Math.abs(ycoord);
      boolean ycheck = ydistance > TileSet.getTileSize() * MAX_JUMP_RANGE
          && ydistance < TileSet.getTileSize() * MIN_JUMP_RANGE && ydistance < 0;
      if ((checkTileCollision() && dy == 0 && changeX < 1) || ycheck) {
        setJumping(true);
      } else {
        setJumping(false);
      }

      previousX = xcoord;
    }
  }
}
