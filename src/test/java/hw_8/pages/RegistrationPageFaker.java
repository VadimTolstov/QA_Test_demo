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
            dateOfBirthInput = $("#dateOfBirthInput"),
            genderInput = $("#genterWrapper"),
            userPhoneInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            filePathInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateClickInput = $("#state"),
            stateInput = $("#stateCity-wrapper"),
            cityClickInput = $("#city"),
            cityInput = $("#stateCity-wrapper"),
            registerFormClickInput = $("#submit");

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
        genderInput.$(byText(gender)).click();

        return this;

    }

    public RegistrationPageFaker setUserPhone(String userPhone) {
        userPhoneInput.setValue(userPhone);

        return this;

    }

    public RegistrationPageFaker setBirthData(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;

    }

    public RegistrationPageFaker setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();

        return this;

    }

    public RegistrationPageFaker setHobby(String hobby) {
        hobbyInput.$(byText(hobby)).click();

        return this;

    }

    public RegistrationPageFaker setUploadImage(String filePath) {
        filePathInput.uploadFromClasspath(filePath);

        return this;

    }

    public RegistrationPageFaker setAddress(String address) {
        addressInput.setValue(address);

        return this;

    }

    public RegistrationPageFaker setState(String state) {
        stateClickInput.click();
        stateInput.$(byText(state)).click();

        return this;

    }

    public RegistrationPageFaker setCity(String city) {
        cityClickInput.click();
        cityInput.$(byText(city)).click();

        return this;

    }

    public void registerForm() {
        registerFormClickInput.click();

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