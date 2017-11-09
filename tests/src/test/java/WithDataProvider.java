import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WithDataProvider {

    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
                {"String with \n new line"},
                {"String, with comma"}
        };
    }

    @Test(dataProvider = "data", dataProviderClass = MyDataProvider.class)
    public void test(String str) {
        System.out.println(str);
        assert true;
    }

}
