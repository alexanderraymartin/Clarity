package clarity.main;

import clarity.graphics.Background;
import clarity.state.StateManager;
import clarity.utilities.Timer;

import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel {

  /**
   * Default serial ID.
   */
  private static final long serialVersionUID = 1L;
  /**
   * Width of the window.
   */
  public static final int WIDTH = 480;
  /**
   * Height of the window.
   */
  public static final int HEIGHT = WIDTH / 16 * 9;
  /**
   * Scale of the window.
   */
  public static final int SCALE = 3;
  /**
   * Title of the game.
   */
  public static final String TITLE = "Clarity";


  private JFrame frame;
  private Graphics2D graphics;
  private StateManager manager;
  // private int monitorWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
  // private int monitorHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

  // TODO remove this variable - testing purposes.
  private Background bg;

  /**
   * Game constructor.
   */
  public Game() {
    setPreferredSize(new Dimension((int) (WIDTH * SCALE), (int) (HEIGHT * SCALE)));
    setFocusable(true);
    requestFocus();
    frame = new JFrame();
    frame.add(this);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setTitle(TITLE);
    frame.setResizable(false);
    // frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // full screen mode
    frame.setVisible(true);

    // TODO remove
    bg = new Background();
    bg.loadBackground("/textures/backgrounds/cat.png");
    run();
  }


  private void run() {
    Timer gameLoopTimer = new Timer();
    Timer titleTimer = new Timer();
    int frames = 0;
    int updates = 0;
    requestFocus();
    manager = new StateManager();
    while (true) {
      if (gameLoopTimer.hasElapsed(1000 / 60)) { // update 60 times per second
        update();
        updates++;
        gameLoopTimer.reset();
      }
      render(); // render as fast as possible
      frames++;
      if (titleTimer.hasElapsed(1000)) {
        frame.setTitle(TITLE + "  |  " + updates + " UPS, " + frames + " FPS");
        System.out.println(TITLE + "  |  " + updates + " UPS, " + frames + " FPS");
        updates = 0;
        frames = 0;
        titleTimer.reset();
      }
    }
  }

  private void update() {

  }

  private void render() {
    graphics = (Graphics2D) getGraphics();
    bg.render(graphics);
    manager.render(graphics);
  }

}
