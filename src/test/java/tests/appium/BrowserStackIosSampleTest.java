package tests.appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static config.Project.browserStackConfig;
import static config.Project.iosConfig;

public class BrowserStackIosSampleTest {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", browserStackConfig.getBaseUser());
        caps.setCapability("browserstack.key", browserStackConfig.getBasePassword());

        // Set URL of the application under test
        caps.setCapability("app", iosConfig.app());

        // Specify device and os_version for testing
        caps.setCapability("device", iosConfig.device());
        caps.setCapability("os_version", iosConfig.osVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java iOS");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(
                new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);


        // Test case for the BrowserStack sample iOS app.
        // If you have uploaded your app, update the test case here.
        IOSElement textButton = (IOSElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Button")));
        textButton.click();
        IOSElement textInput = (IOSElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Input")));
        textInput.sendKeys("hello@browserstack.com");
        Thread.sleep(5000);
        IOSElement textOutput = (IOSElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Output")));
        if(textOutput != null && textOutput.getText().equals("hello@browserstack.com"))
            assert(true);
        else
            assert(false);

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();

    }

}
