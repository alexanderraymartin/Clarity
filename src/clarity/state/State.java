package clarity.state;

import clarity.audio.Audio;
import clarity.graphics.Background;
import clarity.graphics.entity.Entity;
import clarity.graphics.entity.Projectile;
import clarity.graphics.entity.particle.Particle;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;

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

  // Closes all music except music with same name as toKeep
  protected void closeOtherMusic(HashMap<String, Audio> music, String toKeep) {
    music.forEach((songName, song) -> {
      if (!songName.equals(toKeep)) {
        song.close();
      }
    });
  }

  protected void closeAllMusic(HashMap<String, Audio> audio) {
    closeOtherMusic(audio, null);
  }

  // Pass in name of some music to keep it loaded and close all other music
  protected void playMusic(String otherSong) {
    if (otherSong != null) {
      closeOtherMusic(Audio.music, musicFileName);
    }

    if (musicFileName != null) {
      if (!Audio.music.containsKey(musicFileName)) {
        Audio.music.put(musicFileName, new Audio("/sounds/music/" + musicFileName));
        Audio.music.get(musicFileName).loop();
      }
    }
  }

}
