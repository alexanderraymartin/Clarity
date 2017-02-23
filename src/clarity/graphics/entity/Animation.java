package clarity.graphics.entity;

import clarity.utilities.Timer;

import java.awt.image.BufferedImage;

public class Animation {
  private BufferedImage[] frames;
  private int currentFrame;
  private Timer timer;
  private boolean playedOnce;
  private static final int DELAY_IN_MILLISECONDS = 100;

  public Animation() {
    playedOnce = false;
    timer = new Timer();
  }

  /**
   * @param frames The array of buffered images that hold the frames of an animation.
   */
  public void setFrames(BufferedImage[] frames) {
    this.frames = frames;
    currentFrame = 0;
    timer.reset();
    playedOnce = false;
  }

  /**
   * @return The first frame of an animation.
   */
  public BufferedImage getFirstFrame() {
    return frames[0];
  }

  /**
   * @param frame The index of a frame to set the current frame to.
   */
  public void setFrame(int frame) {
    currentFrame = frame;
  }

  /**
   * Update the animation.
   */
  public void update() {
    if (timer.hasElapsed(DELAY_IN_MILLISECONDS)) {
      currentFrame++;
      timer.reset();
    }
    if (currentFrame == frames.length) {
      currentFrame = 0;
      playedOnce = true;
    }
  }

  /**
   * @return The current frame.
   */
  public int getFrames() {
    return currentFrame;
  }

  /**
   * @return The buffered image at the current frame.
   */
  public BufferedImage getImage() {
    return frames[currentFrame];
  }

  /**
   * @return True if the animation has played at least once.
   */
  public boolean hasPlayedOnce() {
    return playedOnce;
  }
}
