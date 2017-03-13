package clarity.state;

import clarity.ui.MainMenu;

import java.awt.Graphics2D;

public class Loading extends State {

  private boolean isRendered;

  public Loading(StateManager manager) {
    super(manager);
    this.background = StateManager.loadingScreen;
  }

  @Override
  public void update() {
    if (isRendered) {
      if (manager.getCurrentLevelIndex() == manager.getLevels().size()
          || manager.getCurrentLevelIndex() == -1) {
        manager.loadNextState(new MainMenu(manager));
      } else {
        manager.loadNextState(new Level(manager));
      }
    }
  }

  @Override
  public void render(Graphics2D graphics) {
    background.render(graphics);
    isRendered = true;
  }
}

