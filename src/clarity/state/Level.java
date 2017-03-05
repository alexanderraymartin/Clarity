package clarity.state;

import clarity.graphics.Map;
import clarity.graphics.entity.MobId;
import clarity.graphics.entity.Player;
import clarity.main.Game;
import clarity.ui.MainMenu;
import clarity.utilities.Vector2d;
import clarity.utilities.input.Keyboard;
import clarity.utilities.input.Mouse;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Level extends State {

  private static final String PATH = "/levels/";
  private static Player player;
  private static boolean isPaused;
  public static Map map;
  public static Vector2d spawnLocation = new Vector2d(0, 0);
  public static Vector2d winLocation = new Vector2d(0, 0);
  public static boolean levelComplete;

  /**
   * @param manager The state manager.
   */
  public Level(StateManager manager) {
    super(manager);
    loadLevel(manager.getCurrentLevel());
    isPaused = false;
    map = new Map();
    init();
  }

  /**
   * @param levelFile The name of the level file.
   */
  public void loadLevel(String levelFile) {
    try {
      InputStream input = getClass().getResourceAsStream(PATH + levelFile);
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));

      backgroundFileName = reader.readLine().trim();
      musicFileName = reader.readLine().trim();
      mapFileName = reader.readLine().trim();

    } catch (Exception exception) {
      exception.printStackTrace();
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
  }

  protected void createPlayer(Map map, Level level) {
    player = new Player(MobId.PLAYER);
    player.setPosition(spawnLocation, true);
    player.isPlayerControlled = true;
    map.setPositionInstantly(
        new Vector2d(Game.WIDTH / 2 - player.getX(), Game.HEIGHT / 2 - player.getY()));
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
      nextLevel();
    }
  }

  private void nextLevel() {
    // TODO
  }

  private void checkPause() {
    if (Keyboard.escapePressed() && !isPaused) {
      isPaused = true;
    } else if (Keyboard.spacePressed() && isPaused) {
      isPaused = false;
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

}
