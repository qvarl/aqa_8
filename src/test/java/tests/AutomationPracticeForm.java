package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Configuration.*;

public class AutomationPracticeForm {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData data = new TestData();

    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://demoqa.com";
        pageLoadTimeout = 90000;
        browser = "edge";
        holdBrowserOpen = true;
    }

    @Test
    void practiceFillFormTest() {

        registrationPage
                .openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setNumber(data.phoneNumber)
                .setDateOfBirth(data.yearOfBirth, data.monthOfBirth, data.dayOfBirth)
                .setSubject(data.subject_1)
                .setHobby(data.hobby)
                .setFile(data.picture)
                .setAddress(data.address)
                .setState(data.state)
                .setCity(data.city)
                .submit()

                .verifyModalWindowAppears()
                .verifyModalWindowResult("Student Name " + data.firstName + " " + data.lastName)
                .verifyModalWindowResult("Student Email " + data.email)
                .verifyModalWindowResult("Gender " + data.gender)
                .verifyModalWindowResult("Mobile " + data.phoneNumber)
                .verifyModalWindowResult("Date of Birth " + data.dayOfBirth + " " + data.monthOfBirth + "," + data.yearOfBirth)
                .verifyModalWindowResult("Subjects " + data.subject_1)
                .verifyModalWindowResult("Hobbies " + data.hobby)
                .verifyModalWindowResult("Picture " + data.picture)
                .verifyModalWindowResult("Address " + data.address)
                .verifyModalWindowResult("State and City " + data.state + " " + data.city);
    }
}
