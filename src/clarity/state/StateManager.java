package clarity.state;

import clarity.ui.MainMenu;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StateManager {

  private State currentState;
  private ArrayList<String> levels;
  private static final String LEVELS_PATH = "/levels/levels.txt";
  private int currentLevel;

  /**
   * Create the state manager.
   */
  public StateManager() {
    this.currentState = new MainMenu(this);
    this.currentLevel = 0;
    getLevels();
  }

  /**
   * @return The current level's file path.
   */
  public String getCurrentLevel() {
    return levels.get(currentLevel);
  }

  /**
   * @return The list of levels.
   */
  private ArrayList<String> getLevels() {
    if (levels == null) {
      levels = new ArrayList<String>();
      try {
        InputStream input = getClass().getResourceAsStream(LEVELS_PATH);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line = "";
        while (line != null) {
          line = reader.readLine();
          if (line == null || line.isEmpty()) {
            break;
          }
          levels.add(line);
        }
        reader.close();
      } catch (Exception exception) {
        exception.printStackTrace();
      }
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
   * @param state The next state.
   */
  public void setCurrentState(State state) {
    currentState.close();
    currentState = state;
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
