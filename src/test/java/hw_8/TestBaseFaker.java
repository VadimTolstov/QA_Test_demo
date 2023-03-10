package hw_8;

import com.codeborne.selenide.Configuration;
import hw_8.pages.RegistrationPageFaker;
import org.junit.jupiter.api.BeforeAll;

public class TestBaseFaker {
    RegistrationPageFaker registrationPage = new RegistrationPageFaker();


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
}
