package test.ho.integration;

import clarity.graphics.entity.projectile.Fireball;
import clarity.state.Level;
import clarity.state.StateManager;
import clarity.utilities.input.Keyboard;
import org.junit.Test;

/**
 * This test was written by Calvin Ho.
 */
public class TestPlayerFireball {

  @Test
  public void testFireball() {
    StateManager manager = new StateManager(new Keyboard());
    manager.setCurrentLevelIndex(0);
    new Level(manager);

    Fireball testFireball = new Fireball();

    assert (testFireball != null);
  }

}
