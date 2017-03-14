package clarity.utilities;

public class Timer {
  private static final double NS = 1000000000; // 10^9 nanoseconds in a second
  private static final double MS = 1000; // 1000 milliseconds in a second
  private long oldTime;

  public Timer() {
    reset();
  }

  /**
   * @param milliseconds Timer in milliseconds.
   * @return True if time has elapsed.
   */
  public boolean hasElapsed(double milliseconds) {
    if ((System.nanoTime() - oldTime) / NS > milliseconds / MS) {
      return true;
    }
    return false;
  }

  public void reset() {
    oldTime = System.nanoTime();
  }
}
