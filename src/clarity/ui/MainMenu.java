package clarity.ui;

import clarity.main.Game;
import clarity.state.State;
import clarity.state.StateManager;
import clarity.utilities.input.Mouse;

import java.awt.Graphics2D;

public class MainMenu extends State {

  private static final String BACKGROUND_FILE_NAME = "mainMenu.png";
  private static final String MUSIC_FILE_NAME =
      "(MainMenu) Elektronomia - Sky High [NCS Release].mp3";
  private static final String MAP_FILE_NAME = "mapFileName";
  private static final String START_FILE_NAME = "playGame.png";
  private static final String EXIT_FILE_NAME = "exit.png";
  private static final String HELP_FILE_NAME = "Help.png";

  private static final MenuItem START =
      new MenuItem(START_FILE_NAME, "playGameHighlight.png", Game.WINDOW_WIDTH / 2 - 50, 110);
  private static final MenuItem HELP =
      new MenuItem(HELP_FILE_NAME, "HelpHighlight.png", Game.WINDOW_WIDTH / 2 - 50, 130);
  private static final MenuItem EXIT =
      new MenuItem(EXIT_FILE_NAME, "exitHighlight.png", Game.WINDOW_WIDTH / 2 - 50, 150);

  /**
   * @param manager The state manager.
   */
  public MainMenu(StateManager manager) {
    super(manager, BACKGROUND_FILE_NAME, MUSIC_FILE_NAME, MAP_FILE_NAME);
    manager.setCurrentLevelIndex(-1);
    init();
    playMusic();
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
      Game.exitGame();
    } else if (HELP.covered() && Mouse.buttonClickAndRelease()) {
      manager.loadNextState(new Help(manager));
    }
  }

  @Override
  public void render(Graphics2D graphics) {
    background.render(graphics);
    START.render(graphics);
    EXIT.render(graphics);
    HELP.render(graphics);

  }
}
