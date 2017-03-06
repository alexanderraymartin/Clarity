package clarity.ui;

import clarity.main.Game;
import clarity.state.Level;
import clarity.state.State;
import clarity.state.StateManager;
import clarity.utilities.input.Mouse;

import java.awt.Graphics2D;

public class MainMenu extends State {

  private static final String BACKGROUND_FILE_NAME = "mainMenu.png";
  private static final String MUSIC_FILE_NAME = "Vexento - We Are One (Original).mp3";
  private static final String MAP_FILE_NAME = "mapFileName";
  private static final String START_FILE_NAME = "NewGame (1).png";
  private static final String EXIT_FILE_NAME = "exitbutton.png";
  private MenuItem Start = new MenuItem(START_FILE_NAME, Game.WIDTH/2 - 50, 70);
  private MenuItem Exit = new MenuItem(EXIT_FILE_NAME, 10, 210);
  private MenuItem Settings = new MenuItem("setting.png", Game.WIDTH/2 - 50, 160);
  private MenuItem Load = new MenuItem("load.png", Game.WIDTH/2 - 50, 115);
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
    if (Start.covered() && Mouse.buttonClickAndRelease()) {
      manager.loadNextState(new Level(manager));
    }
    else if (Exit.covered() && Mouse.buttonClickAndRelease()) {
      System.exit(0);
    }
    else if (Settings.covered() && Mouse.buttonClickAndRelease()) {
      
    }
    else if (Settings.covered() && Mouse.buttonClickAndRelease()) {
      
    }
  }

  @Override
  public void render(Graphics2D graphics) {
    background.render(graphics);
    Start.render(graphics);
    Exit.render(graphics);
    Settings.render(graphics);
    Load.render(graphics);
    
  }
}
