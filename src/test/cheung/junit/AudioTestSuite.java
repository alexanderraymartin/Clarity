package test.cheung.junit;

// Liang Cheung

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestAudio.class, TestMute.class})
public class AudioTestSuite {

}
