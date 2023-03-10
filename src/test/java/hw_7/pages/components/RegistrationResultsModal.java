package hw_7.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultsModal {

    public void verifyModalAppears() {
        $(".modal-dialog").should(appear);
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResult(String key, String vale) {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(vale));
    }

}
