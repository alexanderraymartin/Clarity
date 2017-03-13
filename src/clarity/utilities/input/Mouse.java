package clarity.utilities.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {
  private static int mouseX = -1;
  private static int mouseY = -1;
  private static int mouseB = -1;
  private static boolean mouseClicked = false;
  private static boolean mouseReleased = false;

  public static int getX() {
    return mouseX;
  }

  public static int getY() {
    return mouseY;
  }

  /**
   * @return State of the button.
   */
  public static int getButton() {
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
  public static boolean buttonClickAndRelease() {
    Mouse.getButton();
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
  public void mouseClicked(MouseEvent event) {}

  @Override
  public void mouseEntered(MouseEvent event) {}

  @Override
  public void mouseExited(MouseEvent event) {}

  @Override
  public void mousePressed(MouseEvent event) {
    mouseB = event.getButton();
  }

  @Override
  public void mouseReleased(MouseEvent event) {
    mouseB = -1;
  }
}
