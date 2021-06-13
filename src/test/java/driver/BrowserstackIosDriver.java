package driver;

import com.codeborne.selenide.WebDriverProvider;
import helpers.Browserstack;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static config.Project.iosConfig;

public class BrowserstackIosDriver implements WebDriverProvider {


    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        return getIosDriver();
    }

    private DesiredCapabilities commonCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("project", "HW Java Project");
        desiredCapabilities.setCapability("build", "Java iOS");
        desiredCapabilities.setCapability("name", "hw_test");
        desiredCapabilities.setCapability("autoGrantPermissions", "true");
        /*desiredCapabilities.setCapability("browserstack.user", "oksanaizibekova_ytcmHa");
        desiredCapabilities.setCapability("browserstack.key", "r1z1qmnRRxysJUSSMUxk");*/

        return desiredCapabilities;
    }

    public IOSDriver getIosDriver() {
        DesiredCapabilities desiredCapabilities = commonCapabilities();
        desiredCapabilities.setCapability("device", iosConfig.device());
        desiredCapabilities.setCapability("os_version", iosConfig.osVersion());
        desiredCapabilities.setCapability("app", iosConfig.app());

        return new IOSDriver (Browserstack.getBrowserstackUrl(), desiredCapabilities);
    }


}
