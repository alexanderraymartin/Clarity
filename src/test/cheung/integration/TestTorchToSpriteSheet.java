package test.cheung.integration;

import static org.junit.Assert.assertTrue;

import clarity.graphics.entity.SpriteSheet;
import clarity.graphics.entity.Torch;

// Liang Cheung

import org.junit.Test;

public class TestTorchToSpriteSheet {

  @Test
  public void test() {
    new Torch(4);
    assertTrue(SpriteSheet.DUMMY != null);
  }

}
