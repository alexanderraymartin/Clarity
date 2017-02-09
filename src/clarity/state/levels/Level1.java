package clarity.state.levels;

import clarity.state.State;
import clarity.state.StateManager;
import clarity.ui.MainMenu;
import clarity.utilities.input.Mouse;

public class Level1 extends State {

  /**
   * @param manager The state manager.
   */
  public Level1(StateManager manager) {
    super(manager, "/textures/backgrounds/level1.png", "musicFileName", "mapFileName");
  }


  /**
   * (non-Javadoc)
   * 
   * @see clarity.state.State#update()
   */
  public void update() {
    super.update();
    if (Mouse.buttonClickAndRelease()) {
      manager.setCurrentState(new MainMenu(manager));
    }
  }

}
