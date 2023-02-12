package tests.selenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideSolutionsTest {

    @Test
    void loadingEnterpriseTitle() {
        //Открыть главную страницу гитхаба https://github.com
        open("https://github.com");
        //Навести мышку на Solutions
        $(byText("Solutions")).hover();
        //В сплывающем меню выбрать Enterprise
        $(byText("Enterprise")).click();
        //Отображается текст "Build like the best"
        $("h1").shouldHave(text("Build like the best"));
    }
}
