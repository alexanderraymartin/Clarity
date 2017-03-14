package clarity.utilities.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

  private static final int NUM_KEYS = 120;
  private final boolean[] keys = new boolean[NUM_KEYS];
  
  private boolean up;
  private boolean down;
  private boolean left;
  private boolean right;
  private boolean enter;
  private boolean spaceBar;
  private boolean escape;
  private boolean rkey;
  private boolean qkey;
  private boolean skey;

  /**
   * @return True if key is pressed.
   */
  public boolean upPressed() {
    return up;
  }

  /**
   * @return True if key is pressed.
   */
  public boolean downPressed() {
    return down;
  }

  /**
   * @return True if key is pressed.
   */
  public boolean leftPressed() {
    return left;
  }

  /**
   * @return True if key is pressed.
   */
  public boolean rightPressed() {
    return right;
  }

  /**
   * @return True if key is pressed.
   */
  public boolean enterPressed() {
    return enter;
  }

  /**
   * @return True if key is pressed.
   */
  public boolean spacePressed() {
    return spaceBar;
  }

  /**
   * @return True if key is pressed.
   */
  public boolean escapePressed() {
    return escape;
  }

  /**
   * @return True if key is pressed.
   */
  public boolean rpressed() {
    return rkey;
  }

  /**
   * @return True if key is pressed.
   */
  public boolean qpressed() {
    return qkey;
  }

  /**
   * @return True if key is pressed.
   */
  public boolean spressed() {
    return skey;
  }

  /**
   * Updates key values.
   */
  public void update() {
    up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
    left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
    down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
    right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
    enter = keys[KeyEvent.VK_ENTER];
    spaceBar = keys[KeyEvent.VK_SPACE];
    escape = keys[KeyEvent.VK_ESCAPE];
    rkey = keys[KeyEvent.VK_R];
    qkey = keys[KeyEvent.VK_Q];
    skey = keys[KeyEvent.VK_S];
  }

  /**
   * Activated when key pressed.
   * 
   * @param event Key event
   */
  @Override
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
  @Override
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
  public void keyTyped(KeyEvent event) {
    // required comment for SonarQube empty function code smell
  }
}
