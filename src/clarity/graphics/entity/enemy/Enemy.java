package clarity.graphics.entity.enemy;

import clarity.graphics.entity.Entity;
import clarity.state.Level;
import clarity.utilities.Timer;

public abstract class Enemy extends Entity {

  private static final int ATTACK_DURATION = 1000; // milliseconds

  private int attackDamage;
  private Timer attackTimer;

  protected static final int CHASE_RANGE = 15;
  protected static final int JUMP_RANGE = 3;

  /**
   * @param mobId The mob ID.
   * @param attackDamage The amount of damage that the enemy does to the player.
   */
  public Enemy(int mobId, int attackDamage) {
    super(mobId);
    this.attackDamage = attackDamage;
    attackTimer = new Timer();
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
    if (attackTimer.hasElapsed(ATTACK_DURATION)) {
      isAttacking = false;
    }
    move();
    super.update();
  }

  /**
   * Check for collision with the player.
   */
  public void playerCollisionCheck() {
    if (intersection(Level.player)) {
      if (!Level.player.isImmune() && !Level.player.isDead()) {
        isAttacking = true;
        attackTimer.reset();
      }
      Level.player.hit(attackDamage);
    }
  }

}
