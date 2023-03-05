package hw_6.pages;

import com.codeborne.selenide.SelenideElement;
import hw_6.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("[id=lastName]"),
            userEmailInput = $("#userEmail");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));

        return this;
    }

    public RegistrationPage deleteBanner() {
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage deleteFooter() {
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;

    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;

    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;

    }

    public RegistrationPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();

        return this;

    }

    public RegistrationPage setUserPhone(String userPhone) {
        $("#userNumber").setValue(userPhone);

        return this;

    }

    public RegistrationPage setBirthData(String day, String month, String year) {
        $("#dateOfBirthInput").click();

        return this;

    }
}
