package clarity.utilities;

import clarity.state.State;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class Save {
  private String path;
  private State savedState;

  public Save(String savePath, State savedState) {
    this.path = savePath;
    this.savedState = savedState;
  }

  private boolean isValidPath(String path) {
    try {
      Paths.get(path);
    }
    catch (InvalidPathException | NullPointerException exception) {
      return false;
    }
    return true;
  }

  /**
   * @param path The path to be set.
   */
  public void setPath(String path) {
    if (isValidPath(path)) {
      this.path = path;
    } else {
      throw new IllegalArgumentException("Invalid path specified for save");
    }
  }

  public String getPath() {
    return this.path;
  }

  public State getSavedState() {
    return this.savedState;
  }
}
