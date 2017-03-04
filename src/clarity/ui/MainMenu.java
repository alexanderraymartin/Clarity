package clarity.ui;

import clarity.state.Level;
import clarity.state.State;
import clarity.state.StateManager;
import clarity.utilities.input.Mouse;

public class MainMenu extends State {

  private static final String BACKGROUND_FILE_NAME = "mainMenu.png";
  private static final String MUSIC_FILE_NAME = "musicFileName";
  private static final String MAP_FILE_NAME = "mapFileName";

  /**
   * @param manager The state manager.
   */
  public MainMenu(StateManager manager) {
    super(manager, BACKGROUND_FILE_NAME, MUSIC_FILE_NAME, MAP_FILE_NAME);
    init();
  }

  /**
   * (non-Javadoc)
   * 
   * @see clarity.state.State#update()
   */
  public void update() {
    super.update();
    if (Mouse.buttonClickAndRelease()) {
      manager.loadNextState(new Level(manager));
    }
  }
}
