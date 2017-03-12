package clarity.graphics;

import clarity.graphics.entity.Entity;
import clarity.graphics.entity.MobId;
import clarity.graphics.tile.Tile;
import clarity.graphics.tile.TileSet;
import clarity.main.Game;
import clarity.state.Level;
import clarity.utilities.GameLogger;
import clarity.utilities.Vector2d;
import clarity.utilities.Vector2i;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Map {
  private static final double CAM_SCROLL_SPD = 0.07;

  // Tracks current position in the map
  private double xmap;
  private double ymap;

  // bounds
  private int xmin;
  private int xmax;
  private int ymin;
  private int ymax;
  // Size of the tile.
  private static int tileSize;
  // numbers of rows and columns in map
  private int numOfRows;
  private int numOfCols;
  // width and height of tileSet in pixels
  private int width;
  private int height;
  // the map
  private int[][] mapArray;
  // array of tile sets
  private TileSet[] tileSets;
  // offset based on how far player has moved
  private int rowOffset;
  private int colOffset;
  // number of rows and columns on the screen
  private int numOfRowsToDraw;
  private int numOfColsToDraw;
  // camera tracking speed
  private double moveSpeed = CAM_SCROLL_SPD;


  /**
   * Map constructor.
   */
  public Map() {
    tileSets = TileSet.getTileSets();
    tileSize = TileSet.getTileSize();
    numOfRowsToDraw = Game.WINDOW_HEIGHT / tileSize + 2;
    numOfColsToDraw = Game.WINDOW_WIDTH / tileSize + 2;
    initMap(100, 100);
  }

  /**
   * Add an entity to the list of entities at a certain position and orientation.
   * 
   * @param token String in file.
   */
  private void addEntity(String token) {
    boolean facingRight;
    if (token.charAt(0) == 'R') {
      facingRight = true;
    } else {
      facingRight = false;
    }
    int id = Integer.parseInt(token.substring(1, token.indexOf('(')));
    double xcoord = Double.parseDouble(token.substring(token.indexOf('(') + 1, token.indexOf(',')));
    double ycoord = Double.parseDouble(token.substring(token.indexOf(',') + 1, token.length() - 1));
    Entity entity = MobId.getEntity(id);
    entity.setPosition(new Vector2d(xcoord, ycoord), facingRight);
  }


  /**
   * @param path Path of the map file.
   */
  public void loadMap(String path) {
    try {
      InputStream input = getClass().getResourceAsStream(path);
      BufferedReader reader = new BufferedReader(new InputStreamReader(input));
      loadMap(reader);
    } catch (Exception exception) {
      GameLogger.getLogger().log(java.util.logging.Level.FINE, GameLogger.EXCEPTION, exception);
    }
  }

  /**
   * @param reader BufferedReader of the map file.
   */
  private void loadMap(BufferedReader reader) {
    try {
      boolean hasEntities = false;
      numOfCols = Integer.parseInt(reader.readLine());
      numOfRows = Integer.parseInt(reader.readLine());
      initMap(numOfCols, numOfRows);
      String whiteSpace = "\\s+"; // separates tokens by whitespace
      String line = "";
      int row = 0;
      while (line != null) {
        line = reader.readLine();
        if (line == null || line.isEmpty()) {
          break;
        }
        String[] tokens = line.split(whiteSpace);
        for (int col = 0; col < tokens.length; col++) {
          String temp = tokens[col].trim();
          if (!hasEntities) {
            if ("#Entities#".equals(temp)) {
              hasEntities = true;
              break;
            }
            // map tiles
            mapArray[row][col] = Integer.parseInt(tokens[col]);
            if (mapArray[row][col]
                % (TileSet.getNumTilesAcross() * TileSet.getNumTilesDown()) == 1) {
              Level.spawnLocation = new Vector2d((col + 1) * tileSize, row * tileSize);
            }
            if (mapArray[row][col]
                % (TileSet.getNumTilesAcross() * TileSet.getNumTilesDown()) == 2) {
              Level.winLocation = new Vector2d((col) * tileSize, row * tileSize);
            }
          } else {
            // map entities
            addEntity(temp);
          }
        }
        row++;
      }
      reader.close();
    } catch (Exception exception) {
      GameLogger.getLogger().log(java.util.logging.Level.FINE, GameLogger.EXCEPTION, exception);
    }
  }

  /**
   * @param cols Number of columns.
   * @param rows Number of rows.
   */
  public void initMap(int cols, int rows) {
    numOfCols = cols;
    numOfRows = rows;
    mapArray = new int[numOfRows][numOfCols];
    width = numOfCols * tileSize;
    height = numOfRows * tileSize;
    xmin = Game.WINDOW_WIDTH - width;
    xmax = 0;
    ymin = Game.WINDOW_HEIGHT - height;
    ymax = 0;
    Level.map = this;
  }

  /**
   * @param row The row index.
   * @param col The column index.
   * @return The type of tile.
   */
  public int getType(int row, int col) {
    if (row < 0 || row >= numOfRows || col < 0 || col >= numOfCols) {
      // bounds checking
      return Tile.NO_COLLISION;
    }
    int value = mapArray[row][col];
    int index = value / (TileSet.getNumTilesAcross() * 2);
    int rowIndex = value / TileSet.getNumTilesAcross();
    int colIndex = value % TileSet.getNumTilesAcross();
    return tileSets[index].getTiles()[rowIndex][colIndex].getType();
  }

  /**
   * @param row The row index.
   * @param col The column index.
   * @return The top left coordinates of the tile.
   */
  public Vector2i getCoordinates(int row, int col) {
    return new Vector2i(row * tileSize, col * tileSize);
  }

  /**
   * @param vector The position vector.
   * @return The vector.
   */
  public Vector2d setPosition(Vector2d vector) {
    if (vector.getX() - xmap < 1) {
      xmap = vector.getX();
    } else {
      xmap += (vector.getX() - xmap) * moveSpeed;
    }
    if (vector.getY() - ymap < 1) {
      ymap = vector.getY();
    } else {
      ymap += (vector.getY() - ymap) * moveSpeed;
    }
    fixBounds();
    colOffset = (int) -xmap / tileSize;
    rowOffset = (int) -ymap / tileSize;
    return new Vector2d(xmap, ymap);
  }

  /**
   * Sets the camera position to a specific vector instantly.
   * 
   * @param vector The position vector.
   * @return The vector.
   */
  public Vector2d setPositionInstantly(Vector2d vector) {
    xmap = vector.getX();
    ymap = vector.getY();
    fixBounds();
    colOffset = (int) -xmap / tileSize;
    rowOffset = (int) -ymap / tileSize;
    return new Vector2d(xmap, ymap);
  }

  /**
   * Keeps the screen inbounds.
   */
  public void fixBounds() {
    if (xmap < xmin) {
      xmap = xmin;
    }
    if (ymap < ymin) {
      ymap = ymin;
    }
    if (xmap > xmax) {
      xmap = xmax;
    }
    if (ymap > ymax) {
      ymap = ymax;
    }
  }

  /**
   * @param graphics The graphics to render.
   */
  public void render(Graphics2D graphics) {
    try {
      for (int row = rowOffset; row < rowOffset + numOfRowsToDraw; row++) {
        if (row >= numOfRows) {
          break;
        }
        for (int col = colOffset; col < colOffset + numOfColsToDraw; col++) {
          if (col >= numOfCols) {
            break;
          }
          int temp = mapArray[row][col] % (TileSet.getNumTilesAcross() * TileSet.getNumTilesDown());
          if (temp == 0 || temp == 1 || temp == 2) {
            continue; // Clear block / spawn location / win location
          }
          int value = mapArray[row][col]; // number in map file
          int index = value / (TileSet.getNumTilesAcross() * TileSet.getNumTilesDown());
          int number = value % (TileSet.getNumTilesAcross() * TileSet.getNumTilesDown());
          int rowIndex = number / TileSet.getNumTilesAcross();
          int colIndex = number % TileSet.getNumTilesAcross();
          graphics.drawImage(tileSets[index].getTiles()[rowIndex][colIndex].getImage(),
              (int) xmap + col * tileSize, (int) ymap + row * tileSize, null);
        }
      }
    } catch (Exception exception) {
      GameLogger.getLogger().log(java.util.logging.Level.FINE, GameLogger.EXCEPTION, exception);
    }
  }

  public int getMapX() {
    return (int) xmap;
  }

  public int getMapY() {
    return (int) ymap;
  }

  public int getNumOfRows() {
    return numOfRows;
  }

  public int getNumOfCols() {
    return numOfCols;
  }

  public static int getTileSize() {
    return tileSize;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
