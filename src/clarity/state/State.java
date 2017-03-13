package clarity.state;

import clarity.audio.Audio;
import clarity.graphics.Background;
import clarity.graphics.entity.Entity;
import clarity.graphics.entity.Projectile;
import clarity.graphics.entity.particle.Particle;

import java.awt.Graphics2D;
import java.util.ArrayList;

public abstract class State {

  protected StateManager manager;
  protected Background background;

  protected String backgroundFileName;
  protected String musicFileName;
  protected String mapFileName;

  private static ArrayList<Entity> entities;
  private static ArrayList<Projectile> projectiles;
  private static ArrayList<Particle> particles;


  /**
   * Call init() in the sub-class constructor.
   * 
   * @param manager The state manager.
   * @param backgroundFileName The name of the background image file.
   * @param musicFileName The name of the music file.
   * @param mapFileName The name of the map file.
   */
  public State(StateManager manager, String backgroundFileName, String musicFileName,
      String mapFileName) {
    this.manager = manager;
    this.backgroundFileName = backgroundFileName;
    this.musicFileName = musicFileName;
    this.mapFileName = mapFileName;
  }

  /**
   * Call init() in the sub-class constructor.
   * 
   * @param manager The state manager.
   */
  public State(StateManager manager) {
    this.manager = manager;
  }

  /**
   * Call init() in the sub-class constructor. Initializes the state.
   */
  public void init() {
    background = new Background(backgroundFileName);
    entities = new ArrayList<Entity>();
    projectiles = new ArrayList<Projectile>();
    particles = new ArrayList<Particle>();
  }

  /**
   * @return The arrayList of entities.
   */
  public static ArrayList<Entity> getEntities() {
    if (entities == null) {
      entities = new ArrayList<Entity>();
    }
    return entities;
  }

  /**
   * @return The arrayList of projectiles.
   */
  public static ArrayList<Projectile> getProjectiles() {
    if (projectiles == null) {
      projectiles = new ArrayList<Projectile>();
    }
    return projectiles;
  }

  /**
   * @return The arrayList of particles.
   */
  public static ArrayList<Particle> getParticles() {
    if (particles == null) {
      particles = new ArrayList<Particle>();
    }
    return particles;
  }

  /**
   * Close the state.
   */
  public void close() {
    // TODO
  }

  /**
   * Update the current state.
   */
  public abstract void update();

  /**
   * Render the current state.
   * 
   * @param graphics The graphics to render.
   */
  public abstract void render(Graphics2D graphics);


  protected void playMusic() {
    if (Audio.getCurrentSongPath() != musicFileName) {
      if (Audio.getMusic() != null) {
        Audio.getMusic().close();
      }
      Audio.setMusic(new Audio("/sounds/music/" + musicFileName));
      Audio.getMusic().loop();
    }
    Audio.setCurrentSongName(musicFileName);
  }

}
