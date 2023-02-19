package tests.allure.homework;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideWithListenerTest {

    private static final String REPOSITORY = "allure-framework/allure-java";
    private static final String ISSUE = "Add Cucumber Scenario URI together with line number inside reports";

    @Test
    @Owner("uzbekovagv")
    @Feature("Issue в репозитории")
    @Story("Проверки Issue")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка Issue 'allure-java c Listener'")
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();

        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText(ISSUE)).should(Condition.exist);
    }
}
