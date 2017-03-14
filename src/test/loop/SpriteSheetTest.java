package test.loop;

import static org.junit.Assert.assertEquals;

import clarity.graphics.entity.SpriteSheet;

import org.junit.Test;

public class SpriteSheetTest {

  @Test
  public void testConstructor() {
    int [] values = new int[]{1, 1, 1, 1, 1, 1}; 
    SpriteSheet ss = new SpriteSheet(30, 30, values, "/textures/characters/player.png" );
    assertEquals(30, ss.getHeight(), 0);
  }
}
