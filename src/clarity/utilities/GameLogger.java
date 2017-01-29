package clarity.utilities;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class GameLogger {

  private static Logger log;

  /**
   * @return A logger to the console.
   */
  public static Logger getLogger() {
    if (log == null) {
      log = Logger.getLogger("MyLogger");
      log.setLevel(Level.ALL);
      ConsoleHandler handler = new ConsoleHandler();
      handler.setLevel(Level.ALL);
      handler.setFormatter(new SimpleFormatter());
      log.addHandler(handler);
    }
    return log;
  }

}
