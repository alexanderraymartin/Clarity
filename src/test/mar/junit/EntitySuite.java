package test.mar.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// Jason Mar

@RunWith(Suite.class)
@SuiteClasses({TestGhost.class, TestPlayer.class})
public class EntitySuite {

}
