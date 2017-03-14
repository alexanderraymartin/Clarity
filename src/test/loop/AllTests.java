package test.loop;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ParticleSpawnerTest.class, SpriteSheetTest.class, StateManagerTest.class,
    TileSetTest.class})
public class AllTests {

}
