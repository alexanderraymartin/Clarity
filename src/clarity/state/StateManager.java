package clarity.state;

import clarity.ui.MainMenu;

import java.awt.Graphics2D;

public class StateManager {

  private State currentState;

  /**
   * Create the state manager.
   */
  public StateManager() {
    this.currentState = new MainMenu(this);
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
