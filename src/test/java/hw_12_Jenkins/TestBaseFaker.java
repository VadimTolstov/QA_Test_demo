package hw_12_Jenkins;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import hw_12_Jenkins.helpers.Attach;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBaseFaker {

    @BeforeAll
    @Step("chrome v 100.0, 1920x1080")
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0";
        Configuration.browserSize = "1920x1080";
        //подлючаем
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        //Включаем VNC окошка в окошке и  включаем запись видео Video
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterEach
    void addAttachments() {
        //скриншот
        Attach.screenshotAs("Last screenshot");
        //дерево
        Attach.pageSource();
        //логи
        Attach.browserConsoleLogs();
        //видео
        Attach.addVideo();
    }
}
