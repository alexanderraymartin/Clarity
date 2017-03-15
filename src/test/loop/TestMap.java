package test.loop;

import static org.junit.Assert.*;

import clarity.graphics.Map;

import java.awt.Graphics;
import java.awt.Graphics2D;

import org.junit.Test;

public class TestMap {

  private transient Graphics2D graphics;
  
  @Test
  public void testRender() {
    Map map = new Map();
//    map.loadMap(/asset/);
    map.render(graphics);
  }

}
