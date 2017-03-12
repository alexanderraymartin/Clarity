package clarity.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Save implements Serializable {
  private static final long serialVersionUID = 1L;
  public static final String DIRECTORY =
      System.getProperty("user.home") + "/Documents/My Games/Clarity/";
  public static final String SAVE_PATH = "default.save";
  public GameInfo gameInfo = new GameInfo();

  /**
   * Holds the save information.
   */
  public Save() {
    createDirectory();
    loadGame();
  }

  /**
   * Save the game.
   */
  public void saveGame() {
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(DIRECTORY + SAVE_PATH);
      ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
      outputStream.writeObject(gameInfo);
      outputStream.close();
      fileOutputStream.close();
    } catch (IOException exception) {
      GameLogger.getLogger().log(java.util.logging.Level.FINE, "Exception", exception);
    }
  }

  /**
   * Load the game.
   */
  public void loadGame() {
    File file = new File(DIRECTORY + SAVE_PATH);
    if (!file.exists()) {
      saveGame();
    }
    try {
      // load game
      FileInputStream fileInputStream = new FileInputStream(DIRECTORY + SAVE_PATH);
      ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
      gameInfo = (GameInfo) inputStream.readObject();
      inputStream.close();
      fileInputStream.close();
    } catch (IOException | ClassNotFoundException exception) {
      GameLogger.getLogger().log(java.util.logging.Level.FINE, "Corrupted Save File", exception);
    }
  }

  /**
   * Create the directory for the save files.
   */
  private void createDirectory() {
    File file = new File(DIRECTORY);
    {
      if (!file.exists()) {
        System.out.println("Creating: " + file);
        boolean successful = file.mkdirs();
        if (successful) {
          GameLogger.getLogger().log(java.util.logging.Level.FINE, "Folders created");
        }
      }
    }
  }


  /**
   * The class holds the information needed for a game save.
   *
   */
  public class GameInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    public boolean[] completedLevels;
    public float soundEffectVolume = 0;
    public float musicVolume = 0;
  }
}
