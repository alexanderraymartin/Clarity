package clarity.ui;

import clarity.main.Game;
import clarity.state.Loading;
import clarity.state.State;
import clarity.state.StateManager;
import clarity.utilities.input.Mouse;

import java.awt.Graphics2D;

public class LevelMenu extends State {

  private static final String BACKGROUND_FILE_NAME = "LevelSelect.png";
  private static final String MUSIC_FILE_NAME = "Vexento - We Are One (Original).mp3";
  private static final String MAP_FILE_NAME = "mapFileName";
  private static final MenuItem LEVEL1 =
      new MenuItem("level1.png", "level1Highlight.png", Game.WINDOW_WIDTH / 2 - 60, 70);
  private static final MenuItem LEVEL2 =
      new MenuItem("level2.png", "level2Highlight.png", Game.WINDOW_WIDTH / 2 - 60, 90);
  private static final MenuItem LEVEL3 =
      new MenuItem("level3.png", "level3Highlight.png", Game.WINDOW_WIDTH / 2 - 60, 110);
  private static final MenuItem LEVEL4 =
      new MenuItem("level4.png", "level4Highlight.png", Game.WINDOW_WIDTH / 2 - 60, 130);
  private static final MenuItem LEVEL5 =
      new MenuItem("level5.png", "level5Highlight.png", Game.WINDOW_WIDTH / 2 - 60, 150);
  private static final MenuItem LEVEL6 =
      new MenuItem("level6.png", "level6Highlight.png", Game.WINDOW_WIDTH / 2 - 60, 170);
  private static final MenuItem EXIT =
      new MenuItem("exit.png", "exitHighlight.png", Game.WINDOW_WIDTH / 2 + 15, 200);
  private static final MenuItem BACK =
      new MenuItem("back.png", "backHighlight.png", Game.WINDOW_WIDTH / 2 - 135, 200);

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
    checkLevelSelect(LEVEL1, 0);
    checkLevelSelect(LEVEL2, 1);
    checkLevelSelect(LEVEL3, 2);
    checkLevelSelect(LEVEL4, 3);
    checkLevelSelect(LEVEL5, 4);
    checkLevelSelect(LEVEL6, 5);

    if (BACK.covered() && Mouse.getMouse().buttonClickAndRelease()) {
      manager.loadNextState(new MainMenu(manager));
    } else if (EXIT.covered() && Mouse.getMouse().buttonClickAndRelease()) {
      Game.exitGame();
    }
  }

  private void checkLevelSelect(MenuItem menuItem, int menuItemIndex) {
    if (menuItem.covered() && Mouse.getMouse().buttonClickAndRelease()) {
      manager.setCurrentLevelIndex(menuItemIndex);
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
    BACK.render(graphics);
    EXIT.render(graphics);

  }
}

