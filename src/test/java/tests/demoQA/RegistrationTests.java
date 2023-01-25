package tests.demoQA;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void practiceFormTest() {
        String firstName = "Guzel";
        String lastName = "Uzbekova";
        String email = "guzeluz.qa@gmail.com";
        String gender = "Female";
        String phoneNumber = "9111234567";
        String subject = "Computer Science";
        String hobbies = "Reading";
        String picture = "image.png";
        String currentAddress = "13, Lenina Street, Moscow, Russia, 593637";

        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        //Проверка заполнения формы Practice Form
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1992");
        $(".react-datepicker__day--023").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();
        $(".modal-content").isDisplayed();
        //Проверка диалога успешного заполнения Thanks for submitting the form
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text(firstName + " " + lastName), (text(email)), (text(gender)),
                (text(phoneNumber)), (text("23 January,1992")), (text(subject)),
                (text(hobbies)), (text("image.png")),
                (text(currentAddress)), (text("Haryana Karnal")));
        $("#closeLargeModal").isDisplayed();
    }
}
