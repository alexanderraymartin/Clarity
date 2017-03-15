package test.loop;

import static org.junit.Assert.assertEquals;

import clarity.graphics.entity.SpriteSheet;

import org.junit.Test;

public class SpriteSheetTest {

  @Test
  public void testNeverExecute() {
    int [] values = new int[]{}; 
    SpriteSheet ss = new SpriteSheet(1, 1, values, "/textures/characters/player.png" );
    assertEquals(1, ss.getHeight(), 0);
  }
  
  @Test
  public void testExecuteOnce() {
    int [] values = new int[]{1}; 
    SpriteSheet ss = new SpriteSheet(1, 1, values, "/textures/characters/player.png" );
    assertEquals(1, ss.getHeight(), 0);
  }
  
  @Test
  public void testExecuteTwice() {
    int [] values = new int[]{1,1}; 
    SpriteSheet ss = new SpriteSheet(1, 1, values, "/textures/characters/player.png" );
    assertEquals(1, ss.getHeight(), 0);
  }
  
  @Test
  public void testExecuteFiveTimes() {
    int [] values = new int[]{1,1,1,1,1}; 
    SpriteSheet ss = new SpriteSheet(1, 1, values, "/textures/characters/player.png" );
    assertEquals(1, ss.getHeight(), 0);
  }
}
