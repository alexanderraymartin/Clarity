package test.loop;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestParticleSpawner.class, TestSpriteSheet.class, TestStateManager.class,
    TestTileSet.class})
public class AllTests {

}
