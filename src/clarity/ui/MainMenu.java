package clarity.ui;

import clarity.main.Game;
import clarity.state.State;
import clarity.state.StateManager;
import clarity.utilities.input.Mouse;

import java.awt.Graphics2D;

public class MainMenu extends State {

  private static final String BACKGROUND_FILE_NAME = "mainMenu.png";
  private static final String MUSIC_FILE_NAME = "Vexento - We Are One (Original).mp3";
  private static final String MAP_FILE_NAME = "mapFileName";
  private static final String START_FILE_NAME = "NewGame.png";
  private static final String EXIT_FILE_NAME = "exit.png";
  private static final String SETTINGS_FILE_NAME = "Settings.png";
  private static final String HELP_FILE_NAME = "Help.png";

  private static final MenuItem START =
      new MenuItem(START_FILE_NAME, "NewGameHighlight.png", Game.WINDOW_WIDTH / 2 - 50, 110);
  private static final MenuItem EXIT = new MenuItem(EXIT_FILE_NAME, "exitHighlight.png", 10, 210);
  private static final MenuItem SETTINGS =
      new MenuItem(SETTINGS_FILE_NAME, "SettingsHighLight.png", Game.WINDOW_WIDTH / 2 - 50, 170);
  private static final MenuItem HELP =
      new MenuItem(HELP_FILE_NAME, "HelpHighlight.png", Game.WINDOW_WIDTH / 2 - 50, 150);

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
    if (START.covered() && Mouse.buttonClickAndRelease()) {
      manager.loadNextState(new LevelMenu(manager));
    } else if (EXIT.covered() && Mouse.buttonClickAndRelease()) {
      System.exit(0);
    } else if (SETTINGS.covered()
        && Mouse.buttonClickAndRelease()) {
      manager.loadNextState(new Settings(manager));
    } else if (HELP.covered() && Mouse.buttonClickAndRelease()) {
      manager.loadNextState(new Help(manager));
    }
  }

  @Override
  public void render(Graphics2D graphics) {
    background.render(graphics);
    START.render(graphics);
    EXIT.render(graphics);
    SETTINGS.render(graphics);
    HELP.render(graphics);

  }
}
