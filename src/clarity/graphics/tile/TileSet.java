package clarity.graphics.tile;

import clarity.utilities.GameLogger;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TileSet {
  private Tile[][] tiles;
  /**
   * Size of tile in pixels.
   */
  private static final int TILE_SIZE = 30;
  /**
   * Number of tiles across in the png.
   */
  private static final int NUM_TILES_ACROSS = 20;
  /**
   * Number of tiles down in the png.
   */
  private static final int NUM_TILES_DOWN = 2;
  /* ------------------------------------------ */
  private static final String TILE_LOCATION = "/textures/tiles/";
  private static final String CASTLE_TILES = "castleTiles.png";
  private static final String DUNGEON = "dungeon.png";
  private static final String FOREST = "forest_tiles.png";
  private static final String LIGHT_DUNGEON = "lightDungeon.png";
  private static final String WINTER = "winter.png";
  private static final String[] TILE_PATHS = {CASTLE_TILES, DUNGEON, FOREST, LIGHT_DUNGEON, WINTER};
  /* ------------------------------------------ */
  private static TileSet[] tileSets;

  public TileSet() {
    // SonarQube
  }

  private static void init() {
    for (int i = 0; i < TILE_PATHS.length; i++) {
      tileSets[i] = new TileSet();
      tileSets[i].loadTiles(TILE_LOCATION + TILE_PATHS[i]);
    }
  }

  public static int getTileSize() {
    return TILE_SIZE;
  }

  /**
   * @return The array of tile sets.
   */
  public static TileSet[] getTileSets() {
    if (tileSets == null) {
      tileSets = new TileSet[TILE_PATHS.length];
      init();
    }
    return tileSets;
  }

  public Tile[][] getTiles() {
    return tiles;
  }

  public static String[] getTilePaths() {
    return TILE_PATHS;
  }

  public static int getNumTilesAcross() {
    return NUM_TILES_ACROSS;
  }

  public static int getNumTilesDown() {
    return NUM_TILES_DOWN;
  }

  public static String getPathLocation() {
    return TILE_LOCATION;
  }

  /**
   * @param path The file path.
   */
  public void loadTiles(String path) {
    BufferedImage allTiles;
    try {
      allTiles = ImageIO.read(getClass().getResourceAsStream(path));
      tiles = new Tile[2][NUM_TILES_ACROSS];
      BufferedImage tile;
      for (int col = 0; col < NUM_TILES_ACROSS; col++) {
        tile = allTiles.getSubimage(col * TILE_SIZE, 0, TILE_SIZE, TILE_SIZE);
        tiles[0][col] = new Tile(tile, Tile.NO_COLLISION);
        tile = allTiles.getSubimage(col * TILE_SIZE, TILE_SIZE, TILE_SIZE, TILE_SIZE);
        tiles[1][col] = new Tile(tile, Tile.COLLISION);
      }
    } catch (IOException exception) {
      GameLogger.getLogger().log(java.util.logging.Level.FINE, "Exception", exception);
    }
  }
}
