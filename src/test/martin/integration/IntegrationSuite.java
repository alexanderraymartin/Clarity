package test.martin.integration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// Alex Martin

@RunWith(Suite.class)
@SuiteClasses({TestLevelToPlayer.class, TestStateManagerToLevel.class})
public class IntegrationSuite {

}
