package hw_6;


import com.codeborne.selenide.Configuration;
import hw_6.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTests extends TestBaes{


    @Test
    void fillFormTest() {
        String firstName = "Антон Иванович";
        String lastName = "Ivanov";
        String userEmail = "Ivanov@google.com";
        String gender = "Female";
        String userPhone = "7878787878";



        registrationPage.openPage()
                .deleteBanner()
                .deleteFooter()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserPhone(userPhone);



        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("April")).click();
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("English").pressEnter();

        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();


//        $("label[for=hobbies-checkbox-1]").click();
//        $("label[for=hobbies-checkbox-2]").click();
//        $("label[for=hobbies-checkbox-3]").click();

        $("#uploadPicture").uploadFromClasspath("pictures/JAVA_20.6_10.jpg");
//      $("#uploadPicture").uploadFile(new File("src/test/resources/pictures/JAVA_20.6_10.jpg"));
//      File file = new File("src/test/resources/pictures/JAVA_20.6_10.jpg");
//      $("#uploadPicture").uploadFile(file);


        $("#currentAddress").setValue("Hello");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

//        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
//        $("table tbody tr:nth-child(1) td:nth-child(2)").shouldHave(exactText("Алексей Иванович Ivanov"));
//        $("table tbody tr:nth-child(2) td:nth-child(2)").shouldHave(exactText("Ivanov@google.com"));
//        $("table tbody tr:nth-child(3) td:nth-child(2)").shouldHave(exactText("Female"));

        $(".modal-dialog").should(appear);
        $(".modal-content").shouldHave(
                text("Thanks for submitting the form"),
                text("Антон Иванович Ivanov"),
                text("Ivanov@google.com"),
                text("Female"),
                text("7878787878"),
                text("30 April,1988"),
                text("Music, Reading, Sports"),
                text("JAVA_20.6_10.jpg"),
                text("Hello"),
                text("NCR Delhi")
        );
//        $(".modal-content").shouldHave(text("Алексей Иванович Ivanov"));
//        $(".modal-content").shouldHave(text("Ivanov@google.com"));
//        $(".modal-content").shouldHave(text("Female"));
//        $(".modal-content").shouldHave(text("7878787878"));
//        $(".modal-content").shouldHave(text("25 May,1988"));
//        $(".modal-content").shouldHave(text("Music, Reading, Sports"));
//        $(".modal-content").shouldHave(text("JAVA_20.6_10.jpg"));
//        $(".modal-content").shouldHave(text("Hello"));
//        $(".modal-content").shouldHave(text("NCR Delhi"));

        $("#closeLargeModal").click();

        // sleep(2000);

    }
}