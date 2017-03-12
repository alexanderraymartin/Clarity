package clarity.state;

import clarity.graphics.Background;
import clarity.graphics.Light;
import clarity.graphics.Map;
import clarity.graphics.entity.Player;
import clarity.main.Game;
import clarity.ui.MainMenu;
import clarity.utilities.GameLogger;
import clarity.utilities.Timer;
import clarity.utilities.Vector2d;
import clarity.utilities.input.Keyboard;
import clarity.utilities.input.Mouse;

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
  private static final int RESPAWN_TIME = 3000;
  private static boolean respawnTimerSet;

  public static Player player;
  public static Map map;
  public static final Background pauseScreen = new Background("pauseScreen.png");
  public static Vector2d spawnLocation = new Vector2d(0, 0);
  public static Vector2d winLocation = new Vector2d(0, 0);
  public static boolean levelComplete;

  /**
   * @param manager The state manager.
   */
  public Level(StateManager manager) {
    super(manager);
    getLevelFileNames(manager.getCurrentLevel());
    isPaused = false;
    pausePressed = false;
    map = new Map();
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
      if (player.isDead()) {
        if (!respawnTimerSet) {
          playerRespawnTimer.reset();
          respawnTimerSet = true;
        }
        if (playerRespawnTimer.hasElapsed(RESPAWN_TIME)) {
          createPlayer(map, this);
          respawnTimerSet = false;
        }
      }
      // track player
      map.setPositionInstantly(new Vector2d(Game.WINDOW_WIDTH / 2 - player.getX(),
          Game.WINDOW_HEIGHT / 2 - player.getY()));
    }
    if (Mouse.buttonClickAndRelease()) {
      manager.loadNextState(new MainMenu(manager));
    }
  }

  /**
   * Render the current state.
   * 
   * @param graphics The graphics to render.
   */
  public void render(Graphics2D graphics) {
    background.render(graphics);
    map.render(graphics);
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
    if (isPaused) {
      pauseScreen.render(graphics);
    }
  }

  /**
   * @param map The current map.
   * @param level The current level.
   */
  public void createPlayer(Map map, Level level) {
    player = new Player();
    player.setPosition(spawnLocation, true);
    player.setPlayerControlled(true);
    map.setPositionInstantly(new Vector2d(Game.WINDOW_WIDTH / 2 - player.getX(),
        Game.WINDOW_HEIGHT / 2 - player.getY()));
  }

  /**
   * (non-Javadoc)
   * 
   * @see clarity.state.State#init()
   */
  public void init() {
    super.init();
    map.loadMap("/maps/" + mapFileName);
    map.setPosition(spawnLocation);
    // creates player
    createPlayer(map, this);
    playMusic(null);
    levelComplete = false;
  }


  private void checkLevelComplete() {
    if (levelComplete) {
      // TODO
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
    return map;
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

}
