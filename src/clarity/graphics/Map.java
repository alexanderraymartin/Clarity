package clarity.graphics;

public class Map {
   private int height;
   private int width;

   public Map(int width, int height) {
      this.width = width;
      this.height = height;
   }

   public void setWidth(int width) {
      if (width > 0)
      {
         this.width = width;
      }
   }

   public int getWidth() {
      return this.width;
   }

   public void setHeight(int height) {
      if (height > 0) {
         this.height = height;
      }
   }

   public int getHeight() {
      return this.height;
   }
}
