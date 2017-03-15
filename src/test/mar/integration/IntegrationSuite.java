package test.mar.integration;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestMobIdToGhost.class, TestMobIdToZombie.class})
public class IntegrationSuite {

}
