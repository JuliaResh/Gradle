package myPackage;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IgnoredTests {

    private int value1;
    private int value2;

    @Test
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

    @Test
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

    @Test
    public void testAddNeg() {
        int total = -8;
        int sum = Calculation.add(-value1, -value2);
        assertEquals(sum, total);
    }

    @Ignore ("some ignore reason")
    @Test
    public void testIgnored1() {
        int total = -8;
        int sum = Calculation.add(-value1, -value2);
        assertEquals(sum, total);
    }

    @Ignore ("some ignore reason")
    @Test
    public void testIgnored2() {
        int total = -8;
        int sum = Calculation.add(-value1, -value2);
        assertEquals(sum, total);
    }

}
