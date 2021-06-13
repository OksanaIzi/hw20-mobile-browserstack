package tests.base;

import com.codeborne.selenide.Configuration;
import driver.BrowserstackAndroidDriver;
import org.junit.jupiter.api.BeforeAll;

public class AndroidTestBase extends TestBase{

    @BeforeAll
    public static void setup(){
        Configuration.browser = BrowserstackAndroidDriver.class.getName();
    }
}
