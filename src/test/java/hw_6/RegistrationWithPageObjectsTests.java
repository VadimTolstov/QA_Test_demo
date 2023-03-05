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
        String day = "30";
        String month = "April";
        String year = "1988";




        registrationPage.openPage()
                .deleteBanner()
                .deleteFooter()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserPhone(userPhone)
                .setBirthData(day,month, year );




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


        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", day+month+","+year)
                .verifyResult("Subjects", firstName + " " + lastName)
                .verifyResult("Hobbies", firstName + " " + lastName)
                .verifyResult("Picture", firstName + " " + lastName)
                .verifyResult("Address", firstName + " " + lastName)
                .verifyResult("State and City", firstName + " " + lastName);

//                $(".modal-content").shouldHave(
//                text("Антон Иванович Ivanov"),
//                text("Ivanov@google.com"),
//                text("Female"),
//                text("7878787878"),
//                text("30 April,1988"),
//                text("Music, Reading, Sports"),
//                text("JAVA_20.6_10.jpg"),
//                text("Hello"),
//                text("NCR Delhi")
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