package selenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SelenideSoftAssertions {

    @Test
    void shouldFindSoftAssertions() {
        // открыть страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        // перейти в раздел Wiki проекта
        $("#wiki-tab").click();
        //в списке Pages есть SoftAssertions
        $("#wiki-pages-box button").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        //перейти в SoftAssertions
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        //Внутри SoftAssertions есть пример кода для JUnit5
        $("#wiki-body").$(byText("3. Using JUnit5 extend test class:"));
    }
}
