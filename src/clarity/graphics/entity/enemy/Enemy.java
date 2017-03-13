package clarity.graphics.entity.enemy;

import clarity.graphics.entity.Entity;
import clarity.state.Level;

public abstract class Enemy extends Entity {

  private int attackDamage;

  /**
   * @param mobId The mob ID.
   * @param attackDamage The amount of damage that the enemy does to the player.
   */
  public Enemy(int mobId, int attackDamage) {
    super(mobId);
    this.attackDamage = attackDamage;
  }

  /**
   * Move the enemy. Artificial Intelligence code goes here.
   */
  public abstract void move();

  /**
   * (non-Javadoc)
   * 
   * @see clarity.graphics.entity.Entity#update()
   */
  public void update() {
    playerCollisionCheck();
    move();
    super.update();
  }

  /**
   * Check for collision with the player.
   */
  public void playerCollisionCheck() {
    if (intersection(Level.player)) {
      Level.player.hit(attackDamage);
      isAttacking = true;
    }
  }

}
