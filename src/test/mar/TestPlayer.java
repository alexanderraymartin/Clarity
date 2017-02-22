package test.mar;

import clarity.graphics.entity.Player;
import static org.junit.Assert.*;
import org.junit.Test;


public class TestPlayer {

    @Test
    public void testHealth() {
      Player p = new Player();
      //p.gainHealth(10);
      int change = 10;
      double newHealth =  change + p.getHealth();
      p.gainHealth(change);
      
      assertEquals ((double) newHealth, p.getHealth(), 0);
    }
    
    @Test
    public void testLight() {
      Player p = new Player();
      p.gotLightSource(10);
      
      assertEquals ((double) p.getLight(), 110, 0);
    }
}
