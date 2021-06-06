package driver;

import com.codeborne.selenide.WebDriverProvider;
import config.AndroidConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackAndroidDriver implements WebDriverProvider {


    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static final AndroidConfig androidConfig = ConfigFactory
            .create(AndroidConfig.class, System.getProperties());

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", "oksanaizibekova_ytcmHa");
        desiredCapabilities.setCapability("browserstack.key", "r1z1qmnRRxysJUSSMUxk");

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", androidConfig.getApp());

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", androidConfig.getDevice());
        desiredCapabilities.setCapability("os_version", androidConfig.getOsVersion());

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "Java Android");
        desiredCapabilities.setCapability("name", "first_test");

        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}