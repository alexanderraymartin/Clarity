package clarity.ui;

import clarity.main.Game;
import clarity.state.State;
import clarity.state.StateManager;
import clarity.utilities.input.Mouse;

import java.awt.Graphics2D;

public class Help extends State {

  private static final String BACKGROUND_FILE_NAME = "helpGoal" + ".png";
  private static final String MUSIC_FILE_NAME = "Vexento - We Are One (Original).mp3";
  private static final String MAP_FILE_NAME = "mapFileName";
  private static final String EXIT_FILE_NAME = "exit.png";

  private static final MenuItem GOAL =
      new MenuItem("goal.png", "goalHighlight.png", Game.WINDOW_WIDTH / 2 - 135, 80);
  private static final MenuItem CONTROL =
      new MenuItem("controls.png", "controlsHighlight.png", Game.WINDOW_WIDTH / 2 + 15, 80);
  private static final MenuItem EXIT =
      new MenuItem(EXIT_FILE_NAME, "exitHighlight.png", Game.WINDOW_WIDTH / 2 + 15, 200);
  private static final MenuItem BACK =
      new MenuItem("back.png", "backHighlight.png", Game.WINDOW_WIDTH / 2 - 135, 200);

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
      Game.exitGame();
    } else if (CONTROL.covered() && Mouse.buttonClickAndRelease()) {
      manager.loadNextState(new HelpControl(manager));
    } else if (BACK.covered() && Mouse.buttonClickAndRelease()) {
      manager.loadNextState(new MainMenu(manager));
    }
  }

  @Override
  public void render(Graphics2D graphics) {
    background.render(graphics);
    GOAL.render(graphics);
    CONTROL.render(graphics);
    EXIT.render(graphics);
    BACK.render(graphics);

  }
}
