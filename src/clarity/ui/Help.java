package clarity.ui;

import clarity.state.State;
import clarity.state.StateManager;
import clarity.utilities.input.Mouse;

import java.awt.Graphics2D;

public class Help extends State {

  private static final String BACKGROUND_FILE_NAME = "helpBackground" + ".png";
  private static final String MUSIC_FILE_NAME = "Vexento - We Are One (Original).mp3";
  private static final String MAP_FILE_NAME = "mapFileName";
  private static final String EXIT_FILE_NAME = "exit.png";

  private static final MenuItem EXIT = new MenuItem(EXIT_FILE_NAME, "exitHighlight.png", 10, 210);
  private static final MenuItem BACK = new MenuItem("back.png", "backHighlight.png", 10, 10);

  /**
   * @param manager The state manager.
   */
  public Help(StateManager manager) {
    super(manager, BACKGROUND_FILE_NAME, MUSIC_FILE_NAME, MAP_FILE_NAME);
    init();
  }

  /**
   * (non-Javadoc)
   * 
   * @see clarity.state.State#update()
   */
  public void update() {
    if (EXIT.covered() && Mouse.buttonClickAndRelease()) {
      System.exit(0);
    } else if (BACK.covered() && Mouse.buttonClickAndRelease()) {
      manager.loadNextState(new MainMenu(manager));
    }
  }

  @Override
  public void render(Graphics2D graphics) {
    background.render(graphics);
    EXIT.render(graphics);
    BACK.render(graphics);

  }
}
