package clarity.ui;

import clarity.state.Loading;
import clarity.state.State;
import clarity.state.StateManager;
import clarity.utilities.input.Mouse;

import java.awt.Graphics2D;

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
    if (Mouse.buttonClickAndRelease()) {
      // TODO: This is just for testing
      manager.loadNextState(new Loading(manager));
    }
  }

  @Override
  public void render(Graphics2D graphics) {
    background.render(graphics);
  }
}
