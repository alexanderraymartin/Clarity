package clarity.graphics.entity.enemy;

import clarity.graphics.entity.Entity;
import clarity.state.Level;
import clarity.utilities.Timer;

public abstract class Enemy extends Entity {

  private static final int ATTACK_DURATION = 1000; // milliseconds

  protected int attackDamage;
  private Timer attackTimer;

  protected static final int CHASE_RANGE = 10;
  protected static final int MAX_JUMP_RANGE = -4;
  protected static final int MIN_JUMP_RANGE = -2;

  /**
   * @param mobId The mob ID.
   */
  public Enemy(int mobId) {
    super(mobId);
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
    if (intersection(Level.getPlayer())) {
      if (!Level.getPlayer().isImmune() && !Level.getPlayer().isDead()) {
        isAttacking = true;
        attackTimer.reset();
      }
      Level.getPlayer().hit(attackDamage);
    }
  }

  protected void setAttackDamage(int attackDamage) {
    this.attackDamage = attackDamage;
  }

}
