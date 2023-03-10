package hw_8.pages;

import com.codeborne.selenide.SelenideElement;
import hw_8.pages.components.CalendarComponent;
import hw_8.pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageFaker {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("[id=lastName]"),
            userEmailInput = $("#userEmail"),
            dateOfBirthInput = $("#dateOfBirthInput");

    public RegistrationPageFaker openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));

        return this;
    }

    public RegistrationPageFaker deleteBanner() {
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPageFaker deleteFooter() {
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPageFaker setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;

    }

    public RegistrationPageFaker setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;

    }

    public RegistrationPageFaker setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;

    }

    public RegistrationPageFaker setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();

        return this;

    }

    public RegistrationPageFaker setUserPhone(String userPhone) {
        $("#userNumber").setValue(userPhone);

        return this;

    }

    public RegistrationPageFaker setBirthData(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;

    }

    public RegistrationPageFaker setSubjects(String subjects) {
        $("#subjectsInput").setValue(subjects).pressEnter();

        return this;

    }

    public RegistrationPageFaker setHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();

        return this;

    }

    public RegistrationPageFaker setUploadImage(String filePath) {
        $("#uploadPicture").uploadFromClasspath(filePath);

        return this;

    }

    public RegistrationPageFaker setAddress(String address) {
        $("#currentAddress").setValue(address);

        return this;

    }

    public RegistrationPageFaker setState(String state) {
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();

        return this;

    }

    public RegistrationPageFaker setCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        return this;

    }

    public void registerForm() {
        $("#submit").click();

    }

    public RegistrationPageFaker verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPageFaker verifyResult(String key, String vale) {
        registrationResultsModal.verifyResult(key, vale);

        return this;
    }
}