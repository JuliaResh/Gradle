package myPackage;

import junit.framework.TestCase;

public class MathTest2 extends TestCase {

	private int value1;
	private int value2;

	public MathTest2(String testName) {
		super(testName);
	}

	protected void setUp() throws Exception {
		super.setUp();
		value1 = 10;
		value2 = 15;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		value1 = 0;
		value2 = 0;
	}

	public void testAdd() {
        int total = 25;
        int sum = Calculation.add(value1, value2);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(sum, total);
    }

    public void testAddNegZero() {
        int total = -value1;
        int sum = Calculation.add(-value1, 0);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(sum, total);
    }

    public void testAddZeroZero() {
        int total = 0;
        int sum = Calculation.add(0, 0);
        assertEquals(sum, total);
    }

    public void testSubZero5() {
        int total = -value1;
        int sub = Calculation.sub(-value1, 0);
        assertEquals(sub, total);
    }

}
