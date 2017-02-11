package clarity.graphics;

import clarity.main.Game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Background {

  private static final String PATH = "/textures/backgrounds/";
  private BufferedImage image;
  private double xpos;
  private double ypos;

  /**
   * @param fileName Name of the file.
   */
  public Background(String fileName) {
    loadBackground(fileName);
  }

  // TODO Add asset manager implementation.
  /**
   * Load the background image.
   * 
   * @param fileName Path to the asset.
   */
  private void loadBackground(String fileName) {
    try {
      image = ImageIO.read(getClass().getResourceAsStream(PATH + fileName));
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  /**
   * Update the background.
   */
  public void update() {
    // TODO make moving background.
  }

  /**
   * Render the background.
   * 
   * @param graphics Graphics to render.
   */
  public void render(Graphics2D graphics) {
    graphics.drawImage(image, (int) xpos, (int) ypos, Game.WIDTH * Game.SCALE,
        Game.HEIGHT * Game.SCALE, null);
  }

}
