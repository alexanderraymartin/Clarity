package clarity.ui;

import clarity.main.Game;
import clarity.state.Loading;
import clarity.state.State;
import clarity.state.StateManager;
import clarity.utilities.input.Mouse;

import java.awt.Graphics2D;

public class MainMenu extends State {

  private static final String BACKGROUND_FILE_NAME = "mainMenu.png";
  private static final String MUSIC_FILE_NAME = "Vexento - We Are One (Original).mp3";
  private static final String MAP_FILE_NAME = "mapFileName";
  private static final String START_FILE_NAME = "NewGameButton.png";
  private static final String EXIT_FILE_NAME = "exitButton.png";
  private static final String SETTINGS_FILE_NAME = "settingButton.png";
  private static final String LOAD_FILE_NAME = "loadButton.png";

  private static final MenuItem START = new MenuItem(START_FILE_NAME, Game.WIDTH / 2 - 50, 70);
  private static final MenuItem EXIT = new MenuItem(EXIT_FILE_NAME, 10, 210);
  private static final MenuItem SETTINGS =
      new MenuItem(SETTINGS_FILE_NAME, Game.WIDTH / 2 - 50, 160);
  private static final MenuItem LOAD = new MenuItem(LOAD_FILE_NAME, Game.WIDTH / 2 - 50, 115);

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
      manager.loadNextState(new Loading(manager));
    } else if (EXIT.covered() && Mouse.buttonClickAndRelease()) {
      System.exit(0);
    } else if (SETTINGS.covered() && Mouse.buttonClickAndRelease()) {
      // TODO
    } else if (SETTINGS.covered() && Mouse.buttonClickAndRelease()) {
      // TODO

    }
  }

  @Override
  public void render(Graphics2D graphics) {
    background.render(graphics);
    START.render(graphics);
    EXIT.render(graphics);
    SETTINGS.render(graphics);
    LOAD.render(graphics);

  }
}
