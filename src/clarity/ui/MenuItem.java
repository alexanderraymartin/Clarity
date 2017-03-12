package clarity.ui;

import clarity.main.Game;
import clarity.utilities.GameLogger;
import clarity.utilities.input.Mouse;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class MenuItem {
  private double xcoord;
  private double ycoord;
  private BufferedImage img;
  private BufferedImage img2;
  private BufferedImage img3;
  private double height = 13;
  private double width = 107;
  private static final String PATH = "/menuItems/";

  /**
   * @param fileName Name of file.
   * @param xcoord The x position.
   * @param ycoord The y position.
   */
  public MenuItem(String fileName, String fileName2, double xcoord, double ycoord) {
    loadMenuItem(fileName, fileName2);
    img = img2;
    this.xcoord = xcoord;
    this.ycoord = ycoord;
  }

  private void loadMenuItem(String fileName, String fileName2) {
    try {
      img2 = ImageIO.read(getClass().getResourceAsStream(PATH + fileName));
      img3 = ImageIO.read(getClass().getResourceAsStream(PATH + fileName2));
    } catch (IOException exception) {
      GameLogger.getLogger().log(java.util.logging.Level.FINE, "Exception", exception);
    }
  }

  public void setImage(BufferedImage image) {
    img = image;
  }

  public void setX(double xval) {
    xcoord = xval;
  }

  public void setY(double yval) {
    ycoord = yval;
  }

  public double getX() {
    return xcoord;
  }

  public double getY() {
    return ycoord;
  }

  /**
   * @return True is item is hovered over with mouse.
   */
  public boolean covered() {
    double scale = Game.SCALE;
    if (Game.FULL_SCREEN_MODE) {
      scale = Game.MONITOR_SCALE;
    }
    if (Mouse.getX() / scale < (xcoord + width) && Mouse.getX() / scale > xcoord
        && Mouse.getY() / scale > ycoord && Mouse.getY() / scale < (ycoord + height)) {
      img = img3;

      return true;

    }
    img = img2;

    return false;
  }

  public void render(Graphics2D graphics) {
    graphics.drawImage(img, (int) xcoord, (int) ycoord, (int) width, (int) height, null);
  }
}
