package clarity.utilities.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

  private static final int NUM_KEYS = 120;
  private static boolean[] keys = new boolean[NUM_KEYS];

  private static boolean up;
  private static boolean down;
  private static boolean left;
  private static boolean right;
  private static boolean enter;
  private static boolean spaceBar;
  private static boolean escape;
  private static boolean rKey;
  private static boolean qKey;
  private static boolean sKey;

  /**
   * @return True if key is pressed.
   */
  public static boolean upPressed() {
    return up;
  }

  /**
   * @return True if key is pressed.
   */
  public static boolean downPressed() {
    return down;
  }

  /**
   * @return True if key is pressed.
   */
  public static boolean leftPressed() {
    return left;
  }

  /**
   * @return True if key is pressed.
   */
  public static boolean rightPressed() {
    return right;
  }

  /**
   * @return True if key is pressed.
   */
  public static boolean enterPressed() {
    return enter;
  }

  /**
   * @return True if key is pressed.
   */
  public static boolean spacePressed() {
    return spaceBar;
  }

  /**
   * @return True if key is pressed.
   */
  public static boolean escapePressed() {
    return escape;
  }

  /**
   * @return True if key is pressed.
   */
  public static boolean rpressed() {
    return rKey;
  }

  /**
   * @return True if key is pressed.
   */
  public static boolean qpressed() {
    return qKey;
  }

  /**
   * @return True if key is pressed.
   */
  public static boolean spressed() {
    return sKey;
  }

  /**
   * Updates key values.
   */
  public static synchronized void update() {
    up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
    left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
    down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
    right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
    enter = keys[KeyEvent.VK_ENTER];
    spaceBar = keys[KeyEvent.VK_SPACE];
    escape = keys[KeyEvent.VK_ESCAPE];
    rKey = keys[KeyEvent.VK_R];
    qKey = keys[KeyEvent.VK_Q];
    sKey = keys[KeyEvent.VK_S];
  }

  /**
   * Activated when key pressed.
   * 
   * @param event Key event
   */
  public void keyPressed(KeyEvent event) {
    if (event.getKeyCode() <= NUM_KEYS) {
      keys[event.getKeyCode()] = true;
    }
  }

  /**
   * Activated when key released.
   * 
   * @param event Key event
   */
  public void keyReleased(KeyEvent event) {
    if (event.getKeyCode() <= NUM_KEYS) {
      keys[event.getKeyCode()] = false;
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
   */
  @Override
  public void keyTyped(KeyEvent event) {}
}
