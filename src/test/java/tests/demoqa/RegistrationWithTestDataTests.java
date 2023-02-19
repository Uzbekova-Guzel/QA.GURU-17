package tests.demoqa;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.util.Locale;

public class RegistrationWithTestDataTests extends TestBase {

    @Test
    void successfulRegistrationTest() {
        Faker faker = new Faker(new Locale("en"));

        String firstName = faker.name().firstName(),
               lastName = faker.name().lastName(),
               email = faker.internet().emailAddress(),
               gender = "Female",
               dateOfBirth = "23 January,1992",
               phoneNumber = faker.phoneNumber().subscriberNumber(10),
               subject = "Computer Science",
               hobbies = faker.options().option("Sports", "Reading", "Music"),
               picture = "image.png",
               currentAddress = faker.address().streetAddress(),
               state = "Haryana",
               city = "Karnal";

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
