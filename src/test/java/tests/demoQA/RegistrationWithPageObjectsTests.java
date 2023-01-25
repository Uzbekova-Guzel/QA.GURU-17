package tests.demoQA;

import org.junit.jupiter.api.Test;
import tests.TestBase;

public class RegistrationWithPageObjectsTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
        String firstName = "Guzel";
        String lastName = "Uzbekova";
        String email = "guzeluz.qa@gmail.com";
        String gender = "Female";
        String dateOfBirth = "23 January,1992";
        String phoneNumber = "9111234567";
        String subject = "Computer Science";
        String hobbies = "Reading";
        String picture = "image.png";
        String currentAddress = "13, Lenina Street, Moscow, Russia, 593637";
        String state = "Haryana";
        String city = "Karnal";

        //Проверка заполнения формы Practice Form
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phoneNumber)
                .setBirthDate("23", "January", "1992")
                .setSubject(subject)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .selectState(state)
                .selectCity(city)
                .clickSubmitButton();

        //Проверка диалога успешного заполнения Thanks for submitting the form
        registrationPage.verifyResultsModalAppears()
                 .verifyResult("Student Name", firstName + " " + lastName)
                 .verifyResult("Student Email", email)
                 .verifyResult("Gender", gender)
                 .verifyResult("Mobile", phoneNumber)
                 .verifyResult("Date of Birth", dateOfBirth)
                 .verifyResult("Subjects", subject)
                 .verifyResult("Hobbies", hobbies)
                 .verifyResult("Picture", picture)
                 .verifyResult("Address", currentAddress)
                 .verifyResult("State and City", state + " " + city)
                 .displayedCloseButton();

    }
}
