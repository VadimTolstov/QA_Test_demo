package hw_6;


import org.junit.jupiter.api.Test;

public class RegistrationWithPageObjectsTests extends TestBase {

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
        String subjects = "English";
        String hobby1 = "Music";
        String hobby2 = "Reading";
        String hobby3 = "Sports";
        String filePath = "pictures/JAVA_20.6_10.jpg";
        String address = "Vologda";
        String state = "NCR";
        String city = "Delhi";


        registrationPage.openPage()
                .deleteBanner()
                .deleteFooter()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserPhone(userPhone)
                .setBirthData(day, month, year)
                .setSubjects(subjects)
                .setHobby(hobby1)
                .setHobby(hobby2)
                .setHobby(hobby3)
                .setUploadImage(filePath)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .registerForm();


        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", day +" "+ month + "," + year)
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobby1 + ", " + hobby2 + ", " + hobby3)
                .verifyResult("Picture", filePath.substring(9))
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);

    }
}