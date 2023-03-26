package tests.owner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import tests.owner.config.WebDriverProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest {

    public WebDriver driver;

    @BeforeEach
    public void startDriver() {
        driver = new WebDriverProvider().get();
    }

    @Test
    @Tag("owner")
    public void testGitHub() {
        String title = driver.getTitle();
        assertEquals("GitHub: Let’s build from here · GitHub", title);
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }
}
