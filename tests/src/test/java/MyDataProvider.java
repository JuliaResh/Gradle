import org.testng.annotations.DataProvider;

public class MyDataProvider {

    //trigger change

    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
                {"String with \n new line"},
                {"String, with comma"},
                {"String, with \"quotes\""},
        };
    }

}
