package clarity.ui;

import clarity.main.Game;
import clarity.state.Loading;
import clarity.state.State;
import clarity.state.StateManager;
import clarity.utilities.input.Mouse;

import java.awt.Graphics2D;

public class LevelMenu extends State {

  private static final String BACKGROUND_FILE_NAME = "mainMenu.png";
  private static final String MUSIC_FILE_NAME = "Vexento - We Are One (Original).mp3";
  private static final String MAP_FILE_NAME = "mapFileName";
  private static final MenuItem LEVEL1 = new MenuItem("Play.png", "playHighlight.png", 50, 50);
  private static final MenuItem LEVEL2 =
      new MenuItem("Play.png", "playHighlight.png", Game.WIDTH / 2 - 50, 50);
  private static final MenuItem LEVEL3 =
      new MenuItem("Play.png", "playHighlight.png", Game.WIDTH - 150, 50);
  private static final MenuItem LEVEL4 = new MenuItem("Play.png", "playHighlight.png", 50, 150);
  private static final MenuItem LEVEL5 =
      new MenuItem("Play.png", "playHighlight.png", Game.WIDTH / 2 - 50, 150);
  private static final MenuItem LEVEL6 =
      new MenuItem("Play.png", "playHighlight.png", Game.WIDTH - 150, 150);

  /**
   * @param manager The state manager.
   */
  public LevelMenu(StateManager manager) {
    super(manager, BACKGROUND_FILE_NAME, MUSIC_FILE_NAME, MAP_FILE_NAME);
    init();
  }

  /**
   * (non-Javadoc)
   * 
   * @see clarity.state.State#update()
   */
  public void update() {
    if (LEVEL1.covered() && Mouse.buttonClickAndRelease()) {
      manager.loadNextState(new Loading(manager));
    } else if (LEVEL2.covered() && Mouse.buttonClickAndRelease()) {
      manager.loadNextState(new Loading(manager));
    } else if (LEVEL3.covered() && Mouse.buttonClickAndRelease()) {
      manager.loadNextState(new Loading(manager));
    } else if (LEVEL4.covered() && Mouse.buttonClickAndRelease()) {
      manager.loadNextState(new Loading(manager));
    } else if (LEVEL5.covered() && Mouse.buttonClickAndRelease()) {
      manager.loadNextState(new Loading(manager));
    } else if (LEVEL6.covered() && Mouse.buttonClickAndRelease()) {
      manager.loadNextState(new Loading(manager));
    }

  }

  @Override
  public void render(Graphics2D graphics) {
    background.render(graphics);
    LEVEL1.render(graphics);
    LEVEL2.render(graphics);
    LEVEL3.render(graphics);
    LEVEL4.render(graphics);
    LEVEL5.render(graphics);
    LEVEL6.render(graphics);


  }
}

