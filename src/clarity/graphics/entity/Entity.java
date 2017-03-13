package clarity.graphics.entity;

import clarity.audio.Audio;
import clarity.graphics.Map;
import clarity.graphics.entity.particle.Particle;
import clarity.graphics.entity.particle.ParticleSpawner;
import clarity.graphics.tile.Tile;
import clarity.main.Game;
import clarity.state.Level;
import clarity.state.State;
import clarity.utilities.Timer;
import clarity.utilities.Vector2d;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Entity {

  // mod ID
  protected int mobId;
  // position and velocity
  protected double xcoord;
  protected double ycoord;
  protected double dx;
  protected double dy;
  protected Timer movementTimer;
  // tiles
  protected Map map;
  protected int tileSize;
  protected double xmap;
  protected double ymap;
  // sprite
  protected int spriteWidth;
  protected int spriteHeight;
  protected ArrayList<BufferedImage[]> sprites;
  protected SpriteSheet spriteSheet;
  // collision
  protected int collisionWidth;
  protected int collisionHeight;
  protected int currentRow;
  protected int currentCol;
  protected double xdestination;
  protected double ydestination;
  protected double xposition;
  protected double yposition;

  protected boolean topLeft;
  protected boolean topRight;
  protected boolean bottomLeft;
  protected boolean bottomRight;
  protected boolean middleLeft;
  protected boolean middleRight;
  protected boolean topMiddle;
  protected boolean bottomMiddle;
  // animation
  protected Animation animation;
  protected int currentAction;
  protected boolean facingRight;
  // animation index
  protected static final int IDLE = 0;
  protected static final int WALKING = 1;
  protected static final int JUMPING = 2;
  protected static final int FALLING = 3;
  protected static final int ATTACKING = 4;
  protected static final int SPECIAL_ABILITY = 5;
  // movement
  protected boolean isRight;
  protected boolean isLeft;
  protected boolean isUp;
  protected boolean isDown;
  protected boolean isJumping;
  protected boolean isFalling;
  protected boolean isAttacking;
  protected double moveSpeed;
  protected double maxSpeed;
  protected double stopSpeed;

  protected double fallSpeed;
  protected double maxFallSpeed;
  protected double jumpStart;
  protected double stopJumpSpeed;
  // health and energy
  protected double currentHealth;
  protected double maxHealth;
  protected double currentEnergy;
  protected double maxEnergy;
  protected boolean isDead;
  private boolean isImmune;
  private int immunityTimer;
  protected boolean shouldExplode;
  // player
  private boolean isPlayerControlled;


  /**
   * @param mobId The mob id.
   */
  public Entity(int mobId) {
    this.mobId = mobId;
    this.map = Level.getCurrentMap();
    this.tileSize = Map.getTileSize();
    this.animation = new Animation();
    this.currentAction = IDLE;
    this.shouldExplode = true;
    this.isAttacking = false;
    this.setPlayerControlled(false);
    this.movementTimer = new Timer();
    init();
    if (spriteSheet != null) {
      spriteWidth = spriteSheet.getWidth();
      spriteHeight = spriteSheet.getHeight();
      sprites = spriteSheet.getSprites();
      animation.setFrames(sprites.get(currentAction));
    }
    if (this instanceof Projectile) {
      State.getProjectiles().add((Projectile) this);
    } else if (this instanceof Particle) {
      State.getParticles().add((Particle) this);
    } else {
      State.getEntities().add(this);
    }
  }

  public Entity() {
    this(MobId.DUMMY);
  }

  protected abstract void init();



  /**
   * @param entity The entity to check for collision.
   * @return True if the bounding boxes intersect.
   */
  public boolean intersection(Entity entity) {
    Rectangle r1 = getRectangle();
    Rectangle r2 = entity.getRectangle();
    return r1.intersects(r2);
  }

  /**
   * @param topLeftX X coordinate of a tile.
   * @param topLeftY Y coordinate of a tile.
   * @return True if the bounding boxes intersect.
   */
  public boolean intersection(int topLeftX, int topLeftY) {
    Rectangle r1 = getRectangle();
    Rectangle r2 = new Rectangle(topLeftX, topLeftY, tileSize, tileSize);
    return r1.intersects(r2);
  }

  public Rectangle getRectangle() {
    return new Rectangle((int) xcoord - collisionWidth / 2, (int) ycoord - collisionHeight / 2,
        collisionWidth, collisionHeight);
  }

  /**
   * @return True if the entity should be rendered.
   */
  public boolean onScreen() {
    return !(xcoord + xmap + spriteWidth < 0 || xcoord + xmap - spriteWidth > Game.WINDOW_WIDTH
        || ycoord + ymap + spriteHeight < 0 || ycoord + ymap - spriteHeight > Game.WINDOW_HEIGHT);
  }

  /**
   * @param damage Amount of damage entity takes.
   */
  public void hit(int damage) {
    if (!isImmune()) {
      currentHealth -= damage;
      if (currentHealth <= 0) {
        isDead = true;
      }
    }
  }

  public void setMapPosition() {
    xmap = map.getMapX();
    ymap = map.getMapY();
  }

  protected void getNextPosition() {
    if (isLeft) { // entity going left
      dx -= moveSpeed;
      if (dx < -maxSpeed) {
        dx = -maxSpeed;
      }
    }
    if (isRight) { // entity going right
      dx += moveSpeed;
      if (dx > maxSpeed) {
        dx = maxSpeed;
      }
    }
    if (isDown && isFalling) { // entity going down and falling
      dy += getFallSpeed();
    }
    if (!isLeft && !isRight) { // entity slowing down
      if (dx > 0) {
        dx -= stopSpeed;
        if (dx < 0) {
          dx = 0;
        }
      } else if (dx < 0) {
        dx += stopSpeed;
        if (dx > 0) {
          dx = 0;
        }
      }
    }
    if (isJumping && !isFalling) { // entity jumping
      // playSoundEffect("jump"); // TODO
      dy = jumpStart;
      isFalling = true;
    }
    if (isFalling) { // entity falling
      dy += getFallSpeed();
      if (dy > 0) {
        isJumping = false;
      }
      if (dy < 0 && !isJumping) {
        dy += stopJumpSpeed;
      }
      if (dy > maxFallSpeed) {
        dy = maxFallSpeed;
      }
    }
  }

  /**
   * @param soundEffectName Name of the sound effect.
   */
  public void playSoundEffect(String soundEffectName) {
    if (onScreen()) {
      Audio soundEffect = Audio.getSoundEffects().get(soundEffectName);
      if (soundEffect != null) {
        soundEffect.play();
      }
    }
  }

  /**
   * @param vector The new position.
   */
  public void setPosition(Vector2d vector) {
    this.xcoord = vector.getX();
    this.ycoord = vector.getY();
  }

  /**
   * @param vector The new position.
   * @param value True if the entity is facing right.
   */
  public void setPosition(Vector2d vector, boolean value) {
    this.xcoord = vector.getX();
    this.ycoord = vector.getY();
    facingRight = value;
  }

  /**
   * @param type The animation type.
   * @return True once animation is completed.
   */
  protected boolean playAnimationOnce(int type) {
    setAnimation(type);
    this.animation.update();
    return this.animation.hasPlayedOnce();
  }

  /**
   * @param type The animation type.
   */
  protected void setAnimation(int type) {
    if (currentAction != type) {
      currentAction = type;
      animation.setFrames(sprites.get(type));
    }
  }

  private void checkCorners(Vector2d vector) {
    int leftTile = (int) (vector.getX() - collisionWidth / 2) / tileSize;
    int rightTile = (int) (vector.getX() + collisionWidth / 2 - 1) / tileSize;
    int topTile = (int) (vector.getY() - collisionHeight / 2) / tileSize;
    int bottomTile = (int) (vector.getY() + collisionHeight / 2 - 1) / tileSize;
    if (topTile < 0 || bottomTile >= map.getNumOfRows() || leftTile < 0
        || rightTile >= map.getNumOfCols()) {
      topLeft = topRight = bottomLeft = bottomRight = false;
      setDead(true);
      return;
    }
    topLeft = map.getType(topTile, leftTile) == Tile.COLLISION;
    topRight = map.getType(topTile, rightTile) == Tile.COLLISION;
    bottomLeft = map.getType(bottomTile, leftTile) == Tile.COLLISION;
    bottomRight = map.getType(bottomTile, rightTile) == Tile.COLLISION;
    /* ------------------------------------------ */
    middleLeft = map.getType((topTile + bottomTile) / 2, leftTile) == Tile.COLLISION;
    middleRight = map.getType((topTile + bottomTile) / 2, rightTile) == Tile.COLLISION;
    topMiddle = map.getType(topTile, (leftTile + rightTile) / 2) == Tile.COLLISION;
    bottomMiddle = map.getType(bottomTile, (leftTile + rightTile) / 2) == Tile.COLLISION;
  }

  /**
   * @return True if the entity is colliding with a tile.
   */
  public boolean checkTileCollision() {
    boolean returnValue = false;
    int xoffset = collisionWidth / tileSize;
    int yoffset = collisionHeight / tileSize;
    xdestination = xcoord + dx;
    ydestination = ycoord + dy;
    xposition = xcoord;
    yposition = ycoord;
    checkCorners(new Vector2d(xcoord, ydestination)); // check ycoord axis
    if (dy < 0) {
      if (topLeft || topRight || topMiddle) {
        returnValue = true;
        dy = 0;
        yposition = ((int) (ycoord - yoffset) / tileSize) * tileSize + collisionHeight / 2.0;
      } else {
        yposition += dy;
      }
    }
    if (dy > 0) {
      if (bottomLeft || bottomRight || bottomMiddle) {
        returnValue = true;
        dy = 0;
        yposition = (((int) (ycoord + yoffset) / tileSize) + 1) * tileSize - collisionHeight / 2.0;
        isFalling = false;
      } else {
        yposition += dy;
      }
    }
    checkCorners(new Vector2d(xdestination, ycoord)); // check xcoord axis
    if (dx < 0) {
      if (topLeft || bottomLeft || middleLeft) {
        returnValue = true;
        dx = 0;
        xposition = ((int) (xcoord - xoffset) / tileSize) * tileSize + collisionWidth / 2.0;
      } else {
        xposition += dx;
      }
    }
    if (dx > 0) {
      if (topRight || bottomRight || middleRight) {
        returnValue = true;
        dx = 0;
        xposition = (((int) (xcoord + xoffset) / tileSize) + 1) * tileSize - collisionWidth / 2.0;
      } else {
        xposition += dx;
      }
    }
    if (!isFalling) {
      checkCorners(new Vector2d(xcoord, ydestination + 1));
      if (!bottomLeft && !bottomRight && !bottomMiddle) {
        isFalling = true;
      }
    }
    return returnValue;
  }

  protected void createParticleSpawner() {
    new ParticleSpawner((int) xcoord, (int) ycoord, 5000, 2, 30, Color.RED, Color.PINK, Color.GRAY);
  }

  /**
   * Update the entity.
   */
  public void update() {
    if (currentHealth <= 0) {
      isDead = true;
    }
    if (isDead) {
      // death animation
      if (shouldExplode) {
        createParticleSpawner();
        shouldExplode = false;
      }
      if (this instanceof Projectile) {
        State.getProjectiles().remove((Projectile) this);
      } else if (this instanceof Particle) {
        State.getParticles().remove((Particle) this);
      } else {
        State.getEntities().remove(this);
      }
    } else {
      getNextPosition();
      checkTileCollision();
      setPosition(new Vector2d(xposition, yposition));
      int tempAnimation;
      if (dy > 0) {
        tempAnimation = FALLING;
      } else if (dy < 0) {
        tempAnimation = JUMPING;
      } else if (isLeft || isRight) {
        tempAnimation = WALKING;
      } else {
        tempAnimation = IDLE;
      }
      if (isAttacking) {
        tempAnimation = ATTACKING;
      }
      setAnimation(tempAnimation);
      animation.update();
    }
    if (isRight) {
      facingRight = true;
    }
    if (isLeft) {
      facingRight = false;
    }
  }

  /**
   * @param graphics The graphics.
   */
  public void render(Graphics2D graphics) {
    setMapPosition();
    if (onScreen()) {
      if (facingRight) {
        graphics.drawImage(animation.getImage(), (int) (xcoord + xmap - spriteWidth / 2),
            (int) (ycoord + ymap - spriteHeight / 2), null);
      } else {
        graphics.drawImage(animation.getImage(),
            (int) (xcoord + xmap - spriteWidth / 2 + spriteWidth),
            (int) (ycoord + ymap - spriteHeight / 2), -spriteWidth, spriteHeight, null);
      }
      // g.setColor(Color.red);
      // Rectangle rectangle = getRectangle();
      // rectangle.x += xMap;
      // rectangle.y += yMap;
      // g.draw(rectangle);
    }
  }


  /**
   * @return The modID.
   */
  public int getMobId() {
    return mobId;
  }

  /**
   * @return True if the entity is facing right.
   */
  public boolean isFacingRight() {
    return facingRight;
  }

  public void setVector(Vector2d vector) {
    this.dx = vector.getX();
    this.dy = vector.getY();
  }

  public void setLeft(boolean value) {
    isLeft = value;
  }

  public void setRight(boolean value) {
    isRight = value;
  }

  public void setUp(boolean value) {
    isUp = value;
  }

  public void setDown(boolean value) {
    isDown = value;
  }

  public void setJumping(boolean value) {
    isJumping = value;
  }


  public double getX() {
    return xcoord;
  }

  public double getY() {
    return ycoord;
  }

  /**
   * @return Width of sprite.
   */
  public int getWidth() {
    return spriteWidth;
  }

  /**
   * @return Height of sprite.
   */
  public int getHeight() {
    return spriteHeight;
  }

  /**
   * @return Collision width of sprite.
   */
  public int getCollisionWidth() {
    return collisionWidth;
  }

  /**
   * @return Collision Height of sprite.
   */
  public int getCollisionHeight() {
    return collisionHeight;
  }

  /**
   * @param health The health.
   */
  public void setHealth(double health) {
    this.currentHealth = health;
  }

  /**
   * @return Health of entity.
   */
  public double getHealth() {
    return currentHealth;
  }

  /**
   * @return Max health of entity.
   */
  public double getMaxHealth() {
    return maxHealth;
  }

  /**
   * @return Energy of entity.
   */
  public double getEnergy() {
    return currentEnergy;
  }

  /**
   * @param energy The energy.
   */
  public void setEnergy(double energy) {
    this.currentEnergy = energy;
  }

  /**
   * @return Max energy of entity.
   */
  public double getMaxEnergy() {
    return maxEnergy;
  }


  /**
   * @return True if the entity is dead.
   */
  public boolean isDead() {
    return isDead;
  }

  /**
   * @param value Set isDead to value.
   */
  public void setDead(boolean value) {
    isDead = value;
  }

  public double getFallSpeed() {
    return fallSpeed;
  }

  public boolean isImmune() {
    return isImmune;
  }

  public void setImmune(boolean isImmune) {
    this.isImmune = isImmune;
  }

  public int getImmunityTimer() {
    return immunityTimer;
  }

  public void setImmunityTimer(int immunityTimer) {
    this.immunityTimer = immunityTimer;
  }

  public boolean isPlayerControlled() {
    return isPlayerControlled;
  }

  public void setPlayerControlled(boolean isPlayerControlled) {
    this.isPlayerControlled = isPlayerControlled;
  }


}
