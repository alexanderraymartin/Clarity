package test.Bolt;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import clarity.graphics.entity.SpriteSheet;
import clarity.state.State;

public class testSprite {
	@Test
	  public void testGetWidth() {
		
		SpriteSheet test = new SpriteSheet(30, 30, new int[] {6, 8, 1, 1, 1, 1}, "/textures/characters/player.png");
		assertEquals(30, test.getWidth());
	  }
	@Test
	  public void testGetHeight() {
		
		SpriteSheet test = new SpriteSheet(30, 30, new int[] {6, 8, 1, 1, 1, 1}, "/textures/characters/player.png");
		assertEquals(30, test.getHeight());
	  }

}
