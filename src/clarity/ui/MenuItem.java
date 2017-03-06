package clarity.ui;

import clarity.main.Game;
import clarity.utilities.input.Mouse;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class MenuItem {
  private double xcoord;
  private double ycoord;
  private BufferedImage img;
  private double height = 50;
  private double width = 100;
  private static final String PATH = "/menuItems/";

  /**
   * @param fileName Name of file.
   * @param xcoord The x position.
   * @param ycoord The y position.
   */
  public MenuItem(String fileName, double xcoord, double ycoord) {
    loadMenuItem(fileName);
    this.xcoord = xcoord;
    this.ycoord = ycoord;
  }

  private void loadMenuItem(String fileName) {
    try {
      img = ImageIO.read(getClass().getResourceAsStream(PATH + fileName));
    } catch (IOException exception) {
      exception.printStackTrace();
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
  public boolean covered(String fileName1,String fileName2) {
    double scale = Game.SCALE;
    if (Game.FULL_SCREEN_MODE) {
      scale = Game.monitorScale;
    }
    if (Mouse.getX() / scale < (xcoord + width) && Mouse.getX() / scale > xcoord
        && Mouse.getY() / scale > ycoord && Mouse.getY() / scale < (ycoord + height)) {
      loadMenuItem(fileName2);

      return true;

    }
    loadMenuItem(fileName1);
    return false;
  }

  public void render(Graphics2D graphics) {
    graphics.drawImage(img, (int) xcoord, (int) ycoord, (int) width, (int) height, null);
  }
}
