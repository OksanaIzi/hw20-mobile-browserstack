package driver;

import com.codeborne.selenide.WebDriverProvider;
import helpers.Browserstack;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static config.Project.androidConfig;

public class BrowserstackAndroidDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        return getAndroidDriver();
    }

    private DesiredCapabilities commonCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("project", "HW Java Project");
        desiredCapabilities.setCapability("build", "Java Android");
        desiredCapabilities.setCapability("name", "hw_test");
        desiredCapabilities.setCapability("autoGrantPermissions", "true");
        /*desiredCapabilities.setCapability("browserstack.user", "oksanaizibekova_ytcmHa");
        desiredCapabilities.setCapability("browserstack.key", "r1z1qmnRRxysJUSSMUxk");*/

        return desiredCapabilities;
    }

    public AndroidDriver getAndroidDriver() {
        DesiredCapabilities desiredCapabilities = commonCapabilities();
        desiredCapabilities.setCapability("device", androidConfig.device());
        desiredCapabilities.setCapability("os_version", androidConfig.osVersion());
        desiredCapabilities.setCapability("app", androidConfig.app());

        return new AndroidDriver(Browserstack.getBrowserstackUrl(), desiredCapabilities);
    }
}