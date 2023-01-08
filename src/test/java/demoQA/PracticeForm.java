package demoQA;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
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
        File picture = new File ("src/test/resources/image.png");
        String currentAddress = "13, Lenina Street, Moscow, Russia, 593637";

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $(".main-header").shouldHave(text("Practice Form"));
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
        $("#subjectsContainer input").setValue(subject);
        $(".subjects-auto-complete__menu").$(byText(subject)).click();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFile(picture);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();
        $(".modal-content").isDisplayed();
        //Проверка диалога успешного заполнения Thanks for submitting the form
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text(firstName + " " + lastName), (text(email)), (text(gender)),
                (text(phoneNumber)), (text("23 January,1992")), (text(subject)),
                (text(hobbies)), (text("image.png")),
                (text(currentAddress)), (text("Haryana Karnal")));
        $("#closeLargeModal").isDisplayed();
    }
}
