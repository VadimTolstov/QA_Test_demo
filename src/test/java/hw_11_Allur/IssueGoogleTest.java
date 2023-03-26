package hw_11_Allur;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class IssueGoogleTest {

    private final int ISSUE = 4200;
    private static final String REPOSITORY = "google/googletest";
    private static final String GITHUB = "https://github.com/";
    @Feature("Issue в репозитории")
    @Test

   public void testIssueGoogle() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".header-search-wrapper").click();
        $(".header-search-wrapper").sendKeys("google/googletest");
        $(".header-search-wrapper").submit();
        $(linkText("google/googletest")).click();
        $("#issues-tab").click();
        $(withText("#4200")).should(Condition.exist);

    }

    @Test
    public void testLambda(){

        step("Открываем главную страницу " + GITHUB, () -> {
            open(GITHUB);
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-wrapper").click();
            $(".header-search-wrapper").sendKeys("google/googletest");
            $(".header-search-wrapper").submit();
        });

        step("Кликаем по ссылки репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем таб Issues", () -> {
            $("#issues-tab").click();
        });

        step("Првоеряем наличие Issue с номеров "+ ISSUE, () -> {
            $(Selectors.withText("#" + ISSUE)).should(Condition.exist);
        });
    }

    @Test
    public void testStep(){
        WebStep step = new WebStep();
        step.openMainPage(GITHUB);
        step.searchForRepository(REPOSITORY);
        step.clickOnRepositoryLink(REPOSITORY);
        step.openIssuesTab();
        step.shouldSeeIssueWithNumber(ISSUE);
        step.takeScreenshot();


    }
}
