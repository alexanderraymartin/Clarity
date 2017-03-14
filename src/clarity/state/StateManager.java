package clarity.state;

import clarity.graphics.Background;
import clarity.utilities.GameLogger;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StateManager {
  private static final String LEVELS_PATH = "/levels/levels.txt";
  private static final String LOADING_SCREEN_PATH = "loadingScreen.png";

  private State currentState;
  private List<String> levels;
  private int currentLevelIndex;
  public static final Background loadingScreen = new Background(LOADING_SCREEN_PATH);

  /**
   * Create the state manager.
   */
  public StateManager() {
    this.currentLevelIndex = -1;
    this.currentState = new Loading(this);
    getLevels();
  }

  /**
   * @return The current level's index.
   */
  public int getCurrentLevelIndex() {
    return currentLevelIndex;
  }

  /**
   * @param nextLevel The next level's index.
   */
  public void setCurrentLevelIndex(int nextLevel) {
    this.currentLevelIndex = nextLevel;
  }


  /**
   * @param state The next state.
   */
  public void loadNextState(State state) {
    currentState = state;
  }

  /**
   * @return The current level's file path.
   */
  public String getCurrentLevel() {
    return levels.get(currentLevelIndex);
  }

  /**
   * @return The list of levels.
   */
  public List<String> getLevels() {
    if (levels != null) {
      return levels;
    }
    levels = new ArrayList<>();
    try {
      InputStream input = getClass().getResourceAsStream(LEVELS_PATH);
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));
      String line = "";
      while (!line.equals(null)) {
        line = reader.readLine();
        if (line == null || line.isEmpty()) {
          break;
        }
        levels.add(line);
      }
      reader.close();
    } catch (Exception exception) {
      GameLogger.getLogger().log(java.util.logging.Level.FINE, "Exception", exception);
    }
    return levels;
  }

  /**
   * @return The current state of the game.
   */
  public State getCurrentState() {
    return currentState;
  }

  /**
   * Update the current state.
   */
  public void update() {
    if (currentState != null) {
      currentState.update();
    }
  }

  /**
   * Render the current state.
   * 
   * @param graphics The graphics to render.
   */
  public void render(Graphics2D graphics) {
    if (currentState != null) {
      currentState.render(graphics);
    }
  }

}
