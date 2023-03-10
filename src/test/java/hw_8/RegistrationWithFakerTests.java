package hw_8;


import org.junit.jupiter.api.Test;

public class RegistrationWithFakerTests extends TestBaseFaker {


    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .deleteBanner()
                .deleteFooter()
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


        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", studentData.getFirstName() + " " + studentData.getLastName())
                .verifyResult("Student Email", studentData.getUserEmail())
                .verifyResult("Gender", studentData.getGender())
                .verifyResult("Mobile", studentData.getUserPhone())
                .verifyResult("Date of Birth", studentData.getDay() + " " + studentData.getMonth() + "," + studentData.getYear())
                .verifyResult("Subjects", studentData.getSubject())
                .verifyResult("Hobbies", studentData.getHobby())
                .verifyResult("Picture", studentData.getFilePath().substring(9))
                .verifyResult("Address", studentData.getAddress())
                .verifyResult("State and City", studentData.getState() + " " + studentData.getCity());

    }
}