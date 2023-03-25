package hw_5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void setUP() {
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void movingDragAndDrop() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        sleep(2000);
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(exactText("B"));
        $("#column-b").shouldHave(exactText("A"));
        sleep(2000);
    }

    //  Failed
//    @Test
//    void movingActions() {
//        open("https://the-internet.herokuapp.com/drag_and_drop");
//        actions().clickAndHold($("#column-a")).moveByOffset(250, 0).release().build().perform();
//        $("#column-b").shouldHave(exactText("A"));
//        $("#column-a").shouldHave(exactText("B"));
//        sleep(2000);


 //   }
}
