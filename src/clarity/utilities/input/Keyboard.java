package clarity.utilities.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

  private static final int NUM_KEYS = 120;
  private static final boolean[] KEYS = new boolean[NUM_KEYS];
  
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
    up = KEYS[KeyEvent.VK_UP] || KEYS[KeyEvent.VK_W];
    left = KEYS[KeyEvent.VK_LEFT] || KEYS[KeyEvent.VK_A];
    down = KEYS[KeyEvent.VK_DOWN] || KEYS[KeyEvent.VK_S];
    right = KEYS[KeyEvent.VK_RIGHT] || KEYS[KeyEvent.VK_D];
    enter = KEYS[KeyEvent.VK_ENTER];
    spaceBar = KEYS[KeyEvent.VK_SPACE];
    escape = KEYS[KeyEvent.VK_ESCAPE];
    rkey = KEYS[KeyEvent.VK_R];
    qkey = KEYS[KeyEvent.VK_Q];
    skey = KEYS[KeyEvent.VK_S];
  }

  /**
   * Activated when key pressed.
   * 
   * @param event Key event
   */
  @Override
  public void keyPressed(KeyEvent event) {
    if (event.getKeyCode() <= NUM_KEYS) {
      KEYS[event.getKeyCode()] = true;
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
      KEYS[event.getKeyCode()] = false;
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
