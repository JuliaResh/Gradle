package junit;

import junit.framework.TestCase;


public class MathTest2 extends TestCase {

    public MathTest2(String testName) {
        super(testName);
    }

    public void testA() {
        String OS = System.getProperty("os.name").toLowerCase();
        assertEquals(OS.indexOf("win"), 0);
    }

    public void testB() {
        assertEquals(1+1, 2);
    }

    public void testC() {
        assertEquals(1-1, 0);
    }

    public void testD_fails() {
        assertEquals(1, 2);
    }

}
