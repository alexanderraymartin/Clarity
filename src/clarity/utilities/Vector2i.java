package clarity.utilities;

public class Vector2i {
  private int xcoordinate;
  private int ycoordinate;

  public Vector2i(int xcoordinate, int ycoordinate) {
    this.xcoordinate = xcoordinate;
    this.ycoordinate = ycoordinate;
  }

  /**
   * @return The x coordinate.
   */
  public int getX() {
    return xcoordinate;
  }

  /**
   * @param xcoordinate The value to be set as the x coordinate.
   */
  public void setX(int xcoordinate) {
    this.xcoordinate = xcoordinate;
  }

  /**
   * @return The y coordinate.
   */
  public int getY() {
    return ycoordinate;
  }


  /**
   * @param ycoordinate The value to be set as the y coordinate.
   */
  public void setY(int ycoordinate) {
    this.ycoordinate = ycoordinate;
  }

}
