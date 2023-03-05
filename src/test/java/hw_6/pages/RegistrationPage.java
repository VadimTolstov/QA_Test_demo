package hw_6.pages;

import com.codeborne.selenide.SelenideElement;
import hw_6.pages.components.CalendarComponent;
import hw_6.pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("[id=lastName]"),
            userEmailInput = $("#userEmail"),
            dateOfBirthInput = $("#dateOfBirthInput");

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
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;

    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String vale) {
        registrationResultsModal.verifyResult(key, vale);

        return this;
    }
}