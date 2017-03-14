package clarity.state;

import clarity.graphics.Background;
import clarity.graphics.Light;
import clarity.graphics.Map;
import clarity.graphics.entity.Player;
import clarity.main.Game;
import clarity.ui.UserInterface;
import clarity.utilities.GameLogger;
import clarity.utilities.Timer;
import clarity.utilities.Vector2d;
import clarity.utilities.input.Keyboard;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Level extends State {

  private static final String PATH = "/levels/";
  private static boolean isPaused;
  private static boolean pausePressed;
  private static Light light;
  private static Timer playerRespawnTimer;
  private static final int RESPAWN_TIME = 1500;
  private boolean respawnTimerSet;
  private static UserInterface userInterface;

  private static Player player;
  private static Map map;
  private static final Background pauseScreen = new Background("pauseScreen.png");
  private static Vector2d spawnLocation = new Vector2d(0, 0);
  private static Vector2d winLocation = new Vector2d(0, 0);
  private static boolean levelComplete;

  /**
   * @param manager The state manager.
   */
  public Level(StateManager manager) {
    super(manager);
    getLevelFileNames(manager.getCurrentLevel());
    isPaused = false;
    pausePressed = false;
    setMap(new Map());
    setLight(new Light());
    playerRespawnTimer = new Timer();
    respawnTimerSet = false;
    init();
  }

  /**
   * @param levelFile The name of the level file.
   */
  public void getLevelFileNames(String levelFile) {
    try {
      InputStream input = getClass().getResourceAsStream(PATH + levelFile);
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));

      backgroundFileName = reader.readLine().trim();
      musicFileName = reader.readLine().trim();
      mapFileName = reader.readLine().trim();

    } catch (Exception exception) {
      GameLogger.getLogger().log(java.util.logging.Level.FINE, "Exception", exception);
    }
  }



  /**
   * Update the current state.
   */
  public void update() {
    checkLevelComplete();
    checkPause();
    if (!isPaused) {
      for (int i = 0; i < getEntities().size(); i++) {
        getEntities().get(i).update();
      }
      for (int i = 0; i < getProjectiles().size(); i++) {
        getProjectiles().get(i).update();
      }
      for (int i = 0; i < getParticles().size(); i++) {
        getParticles().get(i).update();
      }
      getLight().update();
      updateHelper();
      userInterface.update();
      // track player
      getMap().setPositionInstantly(new Vector2d(Game.WINDOW_WIDTH / 2 - getPlayer().getX(),
          Game.WINDOW_HEIGHT / 2 - getPlayer().getY()));
    } else {
      if (Keyboard.qpressed()) {
        manager.setCurrentLevelIndex(-1);
        manager.loadNextState(new Loading(manager));
      } else if (Keyboard.rpressed()) {
        manager.loadNextState(new Level(manager));
      }
    }
  }

  private void updateHelper() {
    if (getPlayer().isDead()) {
      if (!respawnTimerSet) {
        playerRespawnTimer.reset();
        respawnTimerSet = true;
      }
      if (playerRespawnTimer.hasElapsed(RESPAWN_TIME)) {
        manager.loadNextState(new Level(manager));
        respawnTimerSet = false;
      }
    }
  }

  /**
   * Render the current state.
   * 
   * @param graphics The graphics to render.
   */
  public void render(Graphics2D graphics) {
    background.render(graphics);
    getMap().render(graphics);
    for (int i = 0; i < getEntities().size(); i++) {
      getEntities().get(i).render(graphics);
    }
    for (int i = 0; i < getProjectiles().size(); i++) {
      getProjectiles().get(i).render(graphics);
    }
    for (int i = 0; i < getParticles().size(); i++) {
      getParticles().get(i).render(graphics);
    }
    getLight().render(graphics);
    userInterface.render(graphics);
    if (isPaused) {
      pauseScreen.render(graphics);
    }
  }

  /**
   * @param map The current map.
   */
  public static void createPlayer(Map map) {
    setPlayer(new Player());
    getPlayer().setPosition(getSpawnLocation(), true);
    getPlayer().setPlayerControlled(true);
    Level.light.resetDarkness();
    map.setPositionInstantly(new Vector2d(Game.WINDOW_WIDTH / 2 - getPlayer().getX(),
        Game.WINDOW_HEIGHT / 2 - getPlayer().getY()));
  }

  /**
   * (non-Javadoc)
   * 
   * @see clarity.state.State#init()
   */
  protected void init() {
    super.init();
    getMap().loadMap("/maps/" + mapFileName);
    getMap().setPositionInstantly(getSpawnLocation());
    // creates player
    createPlayer(getMap());
    userInterface = new UserInterface(getPlayer());
    playMusic();
    setLevelComplete(false);
  }


  private void checkLevelComplete() {
    if (isLevelComplete()) {
      manager.setCurrentLevelIndex(manager.getCurrentLevelIndex() + 1);
      manager.loadNextState(new Loading(manager));
    }
  }

  private static void checkPause() {
    if (Keyboard.escapePressed() && !pausePressed) {
      if (!isPaused) {
        isPaused = true;
      } else {
        isPaused = false;
      }
      pausePressed = true;
    } else if (!Keyboard.escapePressed()) {
      pausePressed = false;
    }
  }

  public static Vector2d getSpawnLocation() {
    return spawnLocation;
  }

  public static Vector2d getWinLocation() {
    return winLocation;
  }

  public static Map getCurrentMap() {
    return getMap();
  }

  /**
   * @return The light.
   */
  public static Light getLight() {
    return light;
  }

  /**
   * @param light The light to set.
   */
  public static void setLight(Light light) {
    Level.light = light;
  }

  /**
   * @return The levelComplete.
   */
  public static boolean isLevelComplete() {
    return levelComplete;
  }

  /**
   * @param levelComplete the levelComplete to set.
   */
  public static void setLevelComplete(boolean levelComplete) {
    Level.levelComplete = levelComplete;
  }

  /**
   * @return The map.
   */
  public static Map getMap() {
    return map;
  }

  /**
   * @param map the map to set.
   */
  public static void setMap(Map map) {
    Level.map = map;
  }

  /**
   * @return The player.
   */
  public static Player getPlayer() {
    return player;
  }

  /**
   * @param player The player to set.
   */
  public static void setPlayer(Player player) {
    Level.player = player;
  }

  /**
   * @param spawnLocation the spawnLocation to set.
   */
  public static void setSpawnLocation(Vector2d spawnLocation) {
    Level.spawnLocation = spawnLocation;
  }

  /**
   * @param winLocation the winLocation to set.
   */
  public static void setWinLocation(Vector2d winLocation) {
    Level.winLocation = winLocation;
  }

}
