package clarity.utilities.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {
  private static final Mouse MOUSE = new Mouse();
  private int mouseX = -1;
  private int mouseY = -1;
  private int mouseB = -1;
  private boolean mouseClicked = false;
  private boolean mouseReleased = false;


  public static Mouse getMouse() {
    return MOUSE;
  }

  public int getX() {
    return mouseX;
  }

  public int getY() {
    return mouseY;
  }

  /**
   * @return State of the button.
   */
  public int getButton() {
    if (mouseB != -1) {
      mouseClicked = true;
      mouseReleased = false;
    }
    if (mouseB == -1 && mouseClicked) {
      mouseClicked = false;
      mouseReleased = true;
    }
    return mouseB;
  }

  /**
   * @return True if button clicked and released.
   */
  public boolean buttonClickAndRelease() {
    getButton();
    boolean temp = mouseReleased;
    mouseReleased = false;
    return temp;
  }

  @Override
  public void mouseDragged(MouseEvent event) {
    mouseX = event.getX();
    mouseY = event.getY();
  }

  @Override
  public void mouseMoved(MouseEvent event) {
    mouseX = event.getX();
    mouseY = event.getY();
  }

  @Override
  public void mouseClicked(MouseEvent event) {
    // SonarQube
  }

  @Override
  public void mouseEntered(MouseEvent event) {
    // SonarQube
  }

  @Override
  public void mouseExited(MouseEvent event) {
    // SonarQube
  }

  @Override
  public void mousePressed(MouseEvent event) {
    mouseB = event.getButton();
  }

  @Override
  public void mouseReleased(MouseEvent event) {
    mouseB = -1;
  }
}
