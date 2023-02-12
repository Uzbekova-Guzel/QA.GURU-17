package tests.selenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideDragDropTest {

    @Test
    void changeDragDrop() {
        //Открыть страницу drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //Перенести прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));
        //Проверить, что прямоугольники поменялись
        $("#column-b header").shouldHave(text("A"));
        $("#column-a header").shouldHave(text("B"));
    }
}
