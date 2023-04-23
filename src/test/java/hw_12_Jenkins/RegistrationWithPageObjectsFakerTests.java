package hw_12_Jenkins;


import hw_12_Jenkins.pages.RegistrationPageFaker;
import hw_12_Jenkins.pages.components.RegistrationResultsModal;
import hw_12_Jenkins.utils.DataGenerator;
import hw_12_Jenkins.utils.StudentData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Регистрация студента")

public class RegistrationWithPageObjectsFakerTests extends TestBaseFaker {
    RegistrationPageFaker registrationPage = new RegistrationPageFaker();
    StudentData studentData = DataGenerator.getRandomStudent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    @Test
    @Tag("simple")
    @Regress
    @DisplayName("Регистрация студента")
    void fillFormTest() {

        registrationPage.openPage()
                .removeBanner()
                .removeFooter()
                .setFirstName(studentData.getFirstName())
                .setLastName(studentData.getLastName())
                .setUserEmail(studentData.getUserEmail())
                .setGender(studentData.getGender())
                .setUserPhone(studentData.getUserPhone())
                .setBirthData(studentData.getDay(),
                        studentData.getMonth(),
                        studentData.getYear())
                .setSubjects(studentData.getSubject())
                .setHobby(studentData.getHobby())
                .setUploadImage(studentData.getFilePath())
                .setAddress(studentData.getAddress())
                .setState(studentData.getState())
                .setCity(studentData.getCity())
                .registerForm();


        registrationResultsModal.verifyModalAppears()
                .verifyResult("Student Name", studentData.getFirstName() + " " + studentData.getLastName())
                .verifyResult("Student Email", studentData.getUserEmail())
                .verifyResult("Gender", studentData.getGender())
                .verifyResult("Mobile", studentData.getUserPhone())
                .verifyResult("Date of Birth", studentData.getDay() + " " + studentData.getMonth() + "," + studentData.getYear())
                .verifyResult("Subjects", studentData.getSubject())
                .verifyResult("Hobbies", studentData.getHobby())
                .verifyResult("Picture", studentData.getFilePath()
                        .substring(studentData.getFilePath().lastIndexOf("/") + 1))
                .verifyResult("Address", studentData.getAddress())
                .verifyResult("State and City", studentData.getState() + " " + studentData.getCity());

    }
}