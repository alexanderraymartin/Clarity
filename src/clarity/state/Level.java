package clarity.state;

import clarity.ui.MainMenu;
import clarity.utilities.input.Mouse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Level extends State {

  private static final String PATH = "/levels/";

  /**
   * @param manager The state manager.
   */
  public Level(StateManager manager) {
    super(manager);
    loadLevel(manager.getCurrentLevel());
    init();
  }

  /**
   * @param levelFile The name of the level file.
   */
  public void loadLevel(String levelFile) {
    try {
      InputStream input = getClass().getResourceAsStream(PATH + levelFile);
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));

      backgroundFileName = reader.readLine().trim();
      musicFileName = reader.readLine().trim();
      mapFileName = reader.readLine().trim();

    } catch (Exception exception) {
      exception.printStackTrace();
    }
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
