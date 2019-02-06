import org.testng.annotations.DataProvider;

public class MyDataProvider {

    //trigger change

    @DataProvider
    public static Object[][] data() {
        return new Object[][] {
                {"String with \n new line"},
                {"String, with comma"},
                {"String2, with comma"},
                {"String3, with comma"},
                {"String, with \"quotes\""},
        };
    }

}
