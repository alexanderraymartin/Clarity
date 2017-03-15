package test.loop;

import static org.junit.Assert.assertEquals;

import clarity.graphics.Map;

import org.junit.Test;

import java.awt.Graphics2D;

public class TestMap {

  private transient Graphics2D graphics;
  
  @Test
  public void testRenderNeverExecute() {
    Map map = new Map();
    map.initMap(0, 0);
    map.render(graphics);
    assertEquals(0, map.getNumOfRows(), 0);
  }
  
  @Test
  public void testRenderExecuteOnce() {
    Map map = new Map(); 
    map.initMap(1, 1);
    map.render(graphics);
    System.out.println(map.getNumOfRows());
    assertEquals(1, map.getNumOfRows(), 0);
  }
  
  @Test
  public void testRenderExecuteTwice() {
    Map map = new Map();
    map.initMap(2, 2);
    map.render(graphics);
    assertEquals(2, map.getNumOfRows(), 0);
  }
  
  @Test
  public void testRenderExecuteFiveTimes() {
    Map map = new Map();
    map.initMap(5, 5);
    map.render(graphics);
    assertEquals(5, map.getNumOfRows(), 0);
  }


}
