import org.testng.ITest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TestFactory implements ITest {

    private String name;

    @Factory(dataProvider = "data", dataProviderClass = MyDataProvider.class)
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
