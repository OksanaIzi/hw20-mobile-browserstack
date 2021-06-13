package tests.base;

import com.codeborne.selenide.Configuration;
import driver.BrowserstackIosDriver;
import org.junit.jupiter.api.BeforeAll;

public class IosTestBase extends TestBase{

    @BeforeAll
    public static void setup(){
        Configuration.browser = BrowserstackIosDriver.class.getName();
    }
}
