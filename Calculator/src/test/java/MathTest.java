import junit.framework.TestCase;


public class MathTest extends TestCase {

	private int value1;
	private int value2;

	public MathTest(String testName) {
		super(testName);
	}

	protected void setUp() throws Exception {
		super.setUp();
		value1 = 3;
		value2 = 5;
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		value1 = 0;
		value2 = 0;
	}
    public void testAgentName() {
        String OS = System.getProperty("os.name").toLowerCase();
        assertEquals(OS.indexOf("win"), 0);
    }

    public void testAdd() {
        int total = 8;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sum = Calculation.add(value1, value2);
        assertEquals(sum, total);
    }

    public void testAdd_ShouldFail() {
        //int total = 18; //fail   2
        int total = 8;    //pass
        int sum = Calculation.add(value1, value2);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(sum, total);
    }

    public void testAddNeg() {
        int total = -8;
        int sum = Calculation.add(-value1, -value2);
        assertEquals(sum, total);
    }

    public void testAddNeg_ShouldFail() {
        int total = -18;    //fail
        //int total = -8; //pass
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sum = Calculation.add(-value1, -value2);
        assertEquals(sum, total);
    }

    public void testAddZero() {
        int total = value1;
        int sum = Calculation.add(value1, 0);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(sum, total);
    }

	public void testFailedAdd() {
		int total = 9;
		int sum = Calculation.add(value1, value2);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertNotSame(sum, total);
	}
	public void testSub() {
		int total = 0;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sub = Calculation.sub(4, 4);
		assertEquals(sub, total);
	}

    public void testSubNeg() {
        int total = -4;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sub = Calculation.sub(2, 6);
        assertEquals(sub, total);
    }

    public void testFailedSub() {
        int total = 6;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int sub = Calculation.sub(4, 3);
        assertNotSame(sub, total);
    }

    public void testFailedSub1() {
        int total = 6;
        int sub = Calculation.sub(4, 3);
        assertNotSame(sub, total);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
