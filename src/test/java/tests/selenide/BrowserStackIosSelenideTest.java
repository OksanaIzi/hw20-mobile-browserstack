package tests.selenide;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.base.IosTestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

@Tag("selenide_ios")
public class BrowserStackIosSelenideTest extends IosTestBase {

    @Test
    @DisplayName("Check Text element in sample ios app")
    void searchTest() {
        sleep(10);

        step("Click on 'Text' button", () ->
                $(MobileBy.AccessibilityId("Text Button")).click());

        String inputValue = "hello@browserstack.com";
        step("Enter the text:" + inputValue, () ->
                $(MobileBy.AccessibilityId("Text Input")).val(inputValue).pressEnter());

        step("Check output field", () ->
                $(MobileBy.AccessibilityId("Text Output")).shouldHave(Condition.text(inputValue)));
    }
}
