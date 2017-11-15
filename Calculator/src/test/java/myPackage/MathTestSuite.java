package myPackage;

import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({myPackage.MathTest.class, myPackage.MathTest2.class})
public class MathTestSuite extends TestSuite {
    public MathTestSuite() {
        addTestSuite(MathTest.class);
        addTestSuite(MathTest2.class);
    }
}
