package clarity.ui;

import clarity.graphics.entity.Player;
import clarity.main.Game;
import clarity.utilities.Vector2i;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class UserInterface {

  private BufferedImage ui;
  private final String path = "/textures/backgrounds/healthAndEnergyBars.png";
  private Player player;
  private Rectangle health;
  private Rectangle energy;
  private static final Vector2i HEALTH_POSITION = new Vector2i(Game.WINDOW_WIDTH / 3, 0);
  private static final Vector2i ENERGY_POSITION = new Vector2i(Game.WINDOW_WIDTH / 3, 6);
  private static final Vector2i HEALTH_SIZE = new Vector2i(Game.WINDOW_WIDTH / 3, 6);
  private static final Vector2i ENERGY_SIZE = new Vector2i(Game.WINDOW_WIDTH / 3, 6);

  /**
   * @param player The player.
   */
  public UserInterface(Player player) {
    this.player = player;
    health = new Rectangle(HEALTH_POSITION.getX(), HEALTH_POSITION.getY(), HEALTH_SIZE.getX(),
        HEALTH_SIZE.getY());
    energy = new Rectangle(ENERGY_POSITION.getX(), ENERGY_POSITION.getY(), ENERGY_SIZE.getX(),
        ENERGY_SIZE.getY());
    try {
      ui = ImageIO.read(getClass().getResourceAsStream(path));
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  /**
   * Update the UI.
   */
  public void update() {
    int tempHealth = (int) (HEALTH_SIZE.getX() * player.getHealth() / player.getMaxHealth());
    int tempEnergy = (int) (ENERGY_SIZE.getX() * player.getEnergy() / player.getMaxEnergy());
    health.setBounds(HEALTH_POSITION.getX(), HEALTH_POSITION.getY(), tempHealth,
        HEALTH_SIZE.getY());
    energy.setBounds(ENERGY_POSITION.getX(), ENERGY_POSITION.getY(), tempEnergy,
        ENERGY_SIZE.getY());
  }

  /**
   * @param graphics The graphics.
   */
  public void render(Graphics2D graphics) {
    graphics.setColor(new Color(255, 0, 0, 150));
    graphics.fill(health);
    graphics.setColor(new Color(0, 255, 0, 150));
    graphics.fill(energy);
    graphics.drawImage(ui, Game.WINDOW_WIDTH / 3, 0, HEALTH_SIZE.getX(),
        HEALTH_SIZE.getY() + ENERGY_SIZE.getY(), null);
  }

}
