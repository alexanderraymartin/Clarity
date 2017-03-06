package clarity.graphics.entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class SpriteSheet {
  private int spriteWidth;
  private int spriteHeight;
  private ArrayList<BufferedImage[]> sprites;

  public static final SpriteSheet dummy =
      new SpriteSheet(10, 10, new int[] {1, 1}, "/textures/projectiles/dummy.png");
  public static final SpriteSheet template = new SpriteSheet(30, 30,
      new int[] {8, 3, 1, 1, 8, 10, 4, 4, 5}, "/textures/characters/character_template.png");
  public static final SpriteSheet player =
      new SpriteSheet(30, 30, new int[] {6, 2, 1, 1, 1, 1}, "/textures/characters/player.png");

  /**
   * @param spriteWidth The width of the sprite.
   * @param spriteHeight The height of the sprite.
   * @param numFrames The number of frames in each animation in an array format.
   * @param filePath The path to the file.
   */
  public SpriteSheet(int spriteWidth, int spriteHeight, int[] numFrames, String filePath) {
    try {
      this.spriteWidth = spriteWidth;
      this.spriteHeight = spriteHeight;
      BufferedImage spriteSheet = ImageIO.read(SpriteSheet.class.getResourceAsStream(filePath));
      sprites = new ArrayList<BufferedImage[]>();
      for (int y = 0; y < numFrames.length; y++) {
        BufferedImage[] image = new BufferedImage[numFrames[y]];
        for (int x = 0; x < numFrames[y]; x++) {
          image[x] =
              spriteSheet.getSubimage(x * spriteWidth, y * spriteHeight, spriteWidth, spriteHeight);
        }
        sprites.add(image);
      }
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  /**
   * @return Sprite width.
   */
  public int getWidth() {
    return spriteWidth;
  }

  /**
   * @return Sprite height.
   */
  public int getHeight() {
    return spriteHeight;
  }

  /**
   * @return ArrayList of sprites.
   */
  public ArrayList<BufferedImage[]> getSprites() {
    return sprites;
  }
}
