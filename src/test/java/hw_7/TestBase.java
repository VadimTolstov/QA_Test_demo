package hw_7;

import com.codeborne.selenide.Configuration;
import hw_7.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    protected RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
}
