package clarity.state;

import clarity.audio.Audio;
import clarity.graphics.Background;
import clarity.graphics.entity.Entity;
import clarity.graphics.entity.particle.Particle;
import clarity.graphics.entity.projectile.Projectile;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public abstract class State {

  protected static StateManager manager;
  protected static Background background;

  protected static String backgroundFileName;
  protected static String musicFileName;
  protected static String mapFileName;

  private static List<Entity> entities;
  private static List<Projectile> projectiles;
  private static List<Particle> particles;


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
    State.manager = manager;
    State.backgroundFileName = backgroundFileName;
    State.musicFileName = musicFileName;
    State.mapFileName = mapFileName;
  }

  /**
   * Call init() in the sub-class constructor.
   * 
   * @param manager The state manager.
   */
  public State(StateManager manager) {
    State.manager = manager;
  }

  /**
   * Call init() in the sub-class constructor. Initializes the state.
   */
  protected static void init() {
    background = new Background(backgroundFileName);
    entities = new ArrayList<>();
    projectiles = new ArrayList<>();
    particles = new ArrayList<>();
  }

  /**
   * @return The arrayList of entities.
   */
  public static List<Entity> getEntities() {
    if (entities == null) {
      entities = new ArrayList<>();
    }
    return entities;
  }

  /**
   * @return The arrayList of projectiles.
   */
  public static List<Projectile> getProjectiles() {
    if (projectiles == null) {
      projectiles = new ArrayList<>();
    }
    return projectiles;
  }

  /**
   * @return The arrayList of particles.
   */
  public static List<Particle> getParticles() {
    if (particles == null) {
      particles = new ArrayList<>();
    }
    return particles;
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


  protected static void playMusic() {
    if (!Audio.getCurrentSongName().equals(musicFileName)) {
      if (Audio.getMusic() != null) {
        Audio.getMusic().close();
      }
      Audio.setMusic(new Audio("/sounds/music/" + musicFileName));
      Audio.getMusic().loop();
    }
    Audio.setCurrentSongName(musicFileName);
  }

}
