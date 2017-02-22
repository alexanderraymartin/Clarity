package test.ho;

import static junit.framework.TestCase.assertEquals;

import clarity.graphics.Map;

import org.junit.Test;

public class TestMap {
  @Test
  public void testGetHeight() {
    Map map = new Map(5, 10);

    assertEquals(10, map.getHeight());
  }

  @Test
  public void testGetWidth() {
    Map map = new Map(5, 10);

    assertEquals(5, map.getWidth());
  }

}
