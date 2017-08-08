import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class MyTest {

    AtomicInteger count = new AtomicInteger(0);

    @Test (invocationCount = 10, threadPoolSize = 10)
    public void test() throws InterruptedException {
        int testId= count.addAndGet(1);

        for (int i=0; i<10; i++) {
            System.out.println("This is some test output from test #" + testId);
            Thread.sleep((long)(Math.random() * 100));
        }
    }

}
