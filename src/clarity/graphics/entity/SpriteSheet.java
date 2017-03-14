package clarity.graphics.entity;

import clarity.utilities.GameLogger;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class SpriteSheet {
  private int spriteWidth;
  private int spriteHeight;
  private List<BufferedImage[]> sprites;

  public static final SpriteSheet DUMMY =
      new SpriteSheet(10, 10, new int[] {1, 1}, "/textures/projectiles/dummy.png");
  public static final SpriteSheet TEMPLATE = new SpriteSheet(30, 30, new int[] {1, 1, 1, 1, 1, 1},
      "/textures/characters/character_template.png");
  public static final SpriteSheet PLAYER =
      new SpriteSheet(30, 30, new int[] {6, 8, 1, 1, 1, 1}, "/textures/characters/player.png");
  public static final SpriteSheet GHOST =
      new SpriteSheet(30, 30, new int[] {1, 7, 1, 1, 1, 1}, "/textures/characters/ghost.png");
  public static final SpriteSheet SAIYAN =
      new SpriteSheet(30, 30, new int[] {1, 4, 1, 1, 1, 3}, "/textures/characters/saiyan.png");
  public static final SpriteSheet SKELETON =
      new SpriteSheet(30, 30, new int[] {1, 3, 1, 1, 2, 2}, "/textures/characters/skeleton.png");
  public static final SpriteSheet ZOMBIE =
      new SpriteSheet(30, 30, new int[] {1, 4, 1, 1, 2, 1}, "/textures/characters/zombie.png");
  public static final SpriteSheet TORCH =
      new SpriteSheet(30, 30, new int[] {6, 1, 1, 1, 1, 1}, "/textures/characters/torch.png");
  public static final SpriteSheet FIREBALL =
      new SpriteSheet(30, 30, new int[] {6}, "/textures/projectiles/fireball.png");
  public static final SpriteSheet BONE =
      new SpriteSheet(30, 30, new int[] {6}, "/textures/projectiles/bone.png");

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
      GameLogger.getLogger().log(java.util.logging.Level.FINE, "Exception", exception);
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
   * @return List of sprites.
   */
  public List<BufferedImage[]> getSprites() {
    return sprites;
  }
}
