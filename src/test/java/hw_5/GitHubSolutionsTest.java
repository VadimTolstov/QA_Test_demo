package hw_5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubSolutionsTest {

    @BeforeAll
    static void setUP(){

//        Configuration.browser = "firefox";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;

    }

    @Test
    void name() {
        open("https://github.com");
        $(byText("Solutions")).hover();
        $("a[href=\"/enterprise\"]").click();
        $(".font-mktg").shouldHave(text("Build like the best"));

    }
}
