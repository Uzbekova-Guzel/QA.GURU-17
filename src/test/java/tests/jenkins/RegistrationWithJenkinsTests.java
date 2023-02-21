package tests.jenkins;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBaseExtended;

import java.util.Locale;

import static io.qameta.allure.Allure.step;

public class RegistrationWithJenkinsTests extends TestBaseExtended {

    @Test
    @Tag("remote")
    @Owner("uzbekovagv")
    @Feature("Practice Form")
    @Story("Заполнение Practice Form")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка заполнения формы Practice Form и отображения диалога успешного заполнения")
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

        step("Заполняется форма 'Practice Form' тестовыми данными", () -> {
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
                });

        step("Проверяется успешное заполнение диалога 'Thanks for submitting the form'", () -> {
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
        });

    }
}
