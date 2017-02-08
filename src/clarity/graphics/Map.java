package clarity.graphics;

public class Map {
    private int width;
    private int height;

    /**
     * Absolute path to file that map is stored in.
     */
    public String mapFile;

    public Map(int mapWidth, int mapHeight, String mapFile) {
        this.width = mapWidth;
        this.height = mapHeight;
        this.mapFile = mapFile;
    }

    public void setWidth(int width) {
        if (width >= 0) {
            this.width = width;
        }
        else {
            throw new IllegalArgumentException("Specified width less than 0.");
        }
    }

    public void setHeight(int width) {
        if (width >= 0) {
            this.width = width;
        }
        else {
            throw new IllegalArgumentException("Specified height less than 0.");
        }
    }
}
