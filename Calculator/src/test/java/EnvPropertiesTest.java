import org.junit.Test;

import java.util.Map;
import java.util.Set;

/**
 * Created by Julia.Reshetnikova on 30-Mar-17.
 */
public class EnvPropertiesTest {

    @Test
    public void printProperties() {
       Set<Map.Entry<String, String>> envProps = System.getenv().entrySet();
        for (Map.Entry<String, String> prop : envProps) {
            System.out.println(prop);
        }

    }

}
