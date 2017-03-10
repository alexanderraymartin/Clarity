package clarity.graphics;

import clarity.main.Game;

import java.awt.Color;
import java.awt.Graphics2D;

public class Light {


  private static final float STARTING_DARKNESS_DEFAULT = 0f;
  private static final float DARKNESS_ACCELERATION_DEFAULT = 0.001f;
  private static final float THRESHOLD = 1f;

  /**
   * Amount of darkness between 0 and 1. Complete darkness is 1 and 0 is no darkness.
   */
  private float currentDarkness;

  /**
   * The rate at which the darkness appears.
   */
  private float darknessAcceleration;

  /**
   * @param startingDarkness The starting darkness. Complete darkness is 1 and 0 is no darkness.
   * @param darknessAcceleration The rate at which the darkness appears.
   */
  public Light(float startingDarkness, float darknessAcceleration) {
    this.currentDarkness = startingDarkness;
    this.darknessAcceleration = darknessAcceleration;
  }

  public Light() {
    this.currentDarkness = STARTING_DARKNESS_DEFAULT;
    this.darknessAcceleration = DARKNESS_ACCELERATION_DEFAULT;
  }


  /**
   * @return True if the screen darkness is above a predefined threshold.
   */
  public boolean isCompletelyDark() {
    if (currentDarkness >= THRESHOLD) {
      return true;
    }
    return false;
  }

  /**
   * Set the darkness value to 0.
   */
  public void resetDarkness() {
    currentDarkness = 0f;
  }


  /**
   * Update the light.
   */
  public void update() {
    currentDarkness += darknessAcceleration;
    currentDarkness = Math.min(currentDarkness, 1);
  }

  /**
   * Render the light.
   * 
   * @param graphics The graphics to render.
   */
  public void render(Graphics2D graphics) {
    graphics.setColor(new Color(0, 0, 0, currentDarkness));
    int width = (int) (Game.WIDTH);
    int height = (int) (Game.HEIGHT);
    int xcoord = (int) (Game.WIDTH / 2 - width / 2);
    int ycoord = (int) (Game.HEIGHT / 2 - height / 2);
    graphics.fillRect(xcoord, ycoord, width, height);
  }

}
