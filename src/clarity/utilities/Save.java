package clarity.utilities;

import clarity.state.State;

public class Save {
   private String path;
   private State savedState;

   public Save(String savePath, State savedState) {
      this.path = savePath;
      this.savedState = savedState;
   }

   // Needs an actual implementation
   private boolean isValidPath(String path) {
      return true;
   }

   public void setPath(String path) {
      if (isValidPath(path))
      {
         this.path = path;
      }
      else
      {
         throw new IllegalArgumentException("Invalid path specified for save");
      }
   }

   public String getPath() {
      return this.path;
   }

   public State getSavedState()
   {
      return this.savedState;
   }
}
