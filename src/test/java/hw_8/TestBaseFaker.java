package hw_8;

import com.codeborne.selenide.Configuration;
import hw_8.pages.RegistrationPageFaker;
import hw_8.utils.DataGenerator;
import hw_8.utils.StudentData;
import org.junit.jupiter.api.BeforeAll;

public class TestBaseFaker {
    RegistrationPageFaker registrationPage = new RegistrationPageFaker();
    StudentData studentData = DataGenerator.getRandomStudent();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
}
