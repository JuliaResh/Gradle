import org.testng.ITest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TestFactory implements ITest {

    private String name;

    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
                {"String with \n new line"},
                {"String, with comma"}
        };
    }

    @Factory(dataProvider = "data")
    public TestFactory(String name) {
        this.name = name;
    }

    @Test
    public void test() {
        System.out.println(name);
        assert true;
    }

    @Override
    public String getTestName() {
        return name;
    }
}
