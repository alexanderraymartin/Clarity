package clarity.graphics;

import clarity.main.Game;
import clarity.utilities.GameLogger;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Background {

  private static final String PATH = "/textures/backgrounds/";
  private BufferedImage image;
  private double xpos = 0;
  private double ypos = 0;

  /**
   * @param fileName Name of the file.
   */
  public Background(String fileName) {
    loadBackground(fileName);
  }

  /**
   * Load the background image.
   * 
   * @param fileName Path to the asset.
   */
  private void loadBackground(String fileName) {
    try {
      image = ImageIO.read(getClass().getResourceAsStream(PATH + fileName));
    } catch (IOException exception) {
      GameLogger.getLogger().log(java.util.logging.Level.FINE, "Exception", exception);
    }
  }

  /**
   * Render the background.
   * 
   * @param graphics Graphics to render.
   */
  public void render(Graphics2D graphics) {
    graphics.drawImage(image, (int) xpos, (int) ypos, Game.WIDTH, Game.HEIGHT, null);
  }

}
