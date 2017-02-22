package test.ho;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import test.martin.TestSave;
import test.ho.TestSave;

@RunWith(Suite.class)
@SuiteClasses({TestSave.class, TestMap.class})
public class SaveSuite
{

}
