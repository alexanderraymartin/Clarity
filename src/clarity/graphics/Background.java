package clarity.graphics;

import clarity.main.Game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Background {

  private BufferedImage image;
  private double xpos;
  private double ypos;

  public Background() {
  }

  // TODO Add asset manager implementation.
  /**
   * Load the background image.
   * 
   * @param path Path to the asset.
   */
  public void loadBackground(String path) {
    try {
      image = ImageIO.read(getClass().getResourceAsStream(path));
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
    graphics.drawImage(image, (int) xpos, (int) ypos, Game.WIDTH, Game.HEIGHT, null);
  }

}
