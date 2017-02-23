package clarity.utilities;

public class Vector2d {
  private double xcoordinate;
  private double ycoordinate;

  public Vector2d(double xcoordinate, double ycoordinate) {
    this.xcoordinate = xcoordinate;
    this.ycoordinate = ycoordinate;
  }

  /**
   * @return The x coordinate.
   */
  public double getX() {
    return xcoordinate;
  }

  /**
   * @param xcoordinate The value to be set as the x coordinate.
   */
  public void setX(double xcoordinate) {
    this.xcoordinate = xcoordinate;
  }

  /**
   * @return The y coordinate.
   */
  public double getY() {
    return ycoordinate;
  }


  /**
   * @param ycoordinate The value to be set as the y coordinate.
   */
  public void setY(double ycoordinate) {
    this.ycoordinate = ycoordinate;
  }

}
