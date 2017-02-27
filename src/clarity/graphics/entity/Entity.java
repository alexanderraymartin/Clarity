package clarity.graphics.entity;

import clarity.graphics.Map;
import clarity.graphics.entity.particle.Particle;
import clarity.main.Game;
import clarity.state.State;
import clarity.utilities.Vector2d;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Entity {

  // mod ID
  protected int mobId;
  // position and velocity
  public double xcoord;
  public double ycoord;
  protected double dx;
  protected double dy;
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
  // animation
  protected Animation animation;
  protected int currentAction;
  protected boolean facingRight;
  // animation index
  protected static final int MOVING_RIGHT = 0;
  protected static final int MOVING_LEFT = 1;
  protected static final int MOVING_UP = 2;
  protected static final int MOVING_DOWN = 3;
  protected static final int ATTACKING = 4;
  protected static final int SPECIAL_ABILITY = 5;
  // movement
  public boolean isRight;
  public boolean isLeft;
  public boolean isUp;
  public boolean isDown;
  public double moveSpeed;
  public double maxSpeed;
  // health and energy
  public double currentHealth;
  public double maxHealth;
  public double currentEnergy;
  public double maxEnergy;
  public boolean isDead;
  public boolean isImmune;
  public boolean shouldExplode;
  // player
  public boolean isPlayerControlled;


  /**
   * @param mobId The mob id.
   */
  public Entity(int mobId) {
    this.mobId = mobId;
    this.animation = new Animation();
    this.currentAction = MOVING_RIGHT;
    this.shouldExplode = true;
    this.isPlayerControlled = false;
    init();
    if (spriteSheet != null) {
      spriteWidth = spriteSheet.getWidth();
      spriteHeight = spriteSheet.getHeight();
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
    return !(xcoord + xmap + spriteWidth < 0 || xcoord + xmap - spriteWidth > Game.WIDTH
        || ycoord + ymap + spriteHeight < 0 || ycoord + ymap - spriteHeight > Game.HEIGHT);
  }

  /**
   * @param damage Amount of damage entity takes.
   */
  public void hit(int damage) {
    currentHealth -= damage;
    if (currentHealth < 0) {
      currentHealth = 0;
      isDead = true;
    }
  }

  public void setMapPosition() {
    xmap = map.getX();
    ymap = map.getY();
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
    if (isUp) { // entity going up
      dy -= moveSpeed;
      if (dy < -maxSpeed) {
        dy = -maxSpeed;
      }
    }
    if (isDown) { // entity going down
      dy += moveSpeed;
      if (dy > maxSpeed) {
        dy = maxSpeed;
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
   * @param type The animation type.
   */
  protected void setAnimation(int type) {
    if (currentAction != type) {
      currentAction = type;
      animation.setFrames(sprites.get(type));
    }
  }

  private boolean checkTileCollision() {
    boolean returnValue = false;

    // TODO Add tile collision here!

    return returnValue;
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
        // new ParticleSpawner((int) xcoord, (int) ycoord); //TODO
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
      int tempAnimation = MOVING_DOWN;
      if (isDown) { // moving down
        tempAnimation = MOVING_DOWN;
      } else if (isUp) { // moving up
        tempAnimation = MOVING_UP;
      } else if (isLeft) { // moving left
        tempAnimation = MOVING_LEFT;
      } else if (isRight) { // moving right
        tempAnimation = MOVING_RIGHT;
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



}
