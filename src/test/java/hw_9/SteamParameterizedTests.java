package hw_9;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import hw_9.annotations.Blocker;
import hw_9.annotations.Regress;
import hw_9.annotations.Smoke;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SteamParameterizedTests {

    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1920x1080";
        Selenide.open("https://store.steampowered.com/");

    }


    @ValueSource(strings = {
            "Sekiro™: Shadows Die Twice - GOTY Edition", "The Callisto Protocol™", "Mount & Blade II: Bannerlord"
    })

    @ParameterizedTest(name = "Поиск игры на сайте Steam {0}")
    @Smoke
    void steamSearchTest(String gameData) {
        $("[placeholder=поиск]").setValue(gameData).pressEnter();
        $(".title").click();
        $("#appHubAppName").shouldHave(text(gameData));


    }


    @CsvSource(value = {
            "Sekiro™: Shadows Die Twice - GOTY Edition | Игра года - The Game Awards 2019 Лучший боевик 2019 г. " +
            "- IGN Составляйте и воплощайте собственные планы мести в удостоенном множества наград боевике от студии " +
            "FromSoftware, создавшей Bloodborne и серию Dark Souls. Отомстите врагам. Верните свою честь. Освойте искусство убивать.",

            "The Callisto Protocol™ |  Survive to escape the horrors of Callisto and uncover the dark secrets of Jupiter’s dead moon.",

            "Mount & Blade II: Bannerlord |   Это стратегическая ролевая игра. Ваш персонаж будет плести интриги, " +
            "заниматься ремеслами, торговать и воевать в огромной средневековой «песочнице». Командуйте воинами в режиме реального времени. " +
            "Сражайтесь с видом от первого или третьего лица, осваивая интуитивно понятную систему боевых навыков.",
    }, delimiter = '|')

    @ParameterizedTest(name = "Поиск игры на сайте Steam {0} отображается описания игры {1}")
    @Regress
    void steamDisplayingDescriptionGameText1(String gameData, String expectedText) {
        $("[placeholder=поиск]").setValue(gameData).pressEnter();
        $(".title").click();
        $(".game_description_snippet").shouldHave(Condition.text(expectedText));


    }


    @CsvFileSource(resources = "/testdata_hw_9/steamDisplayingDescriptionGameText.csv", delimiter = '|')


    @ParameterizedTest(name = "Поиск игры на сайте Steam {0} отображается описания игры {1}")
    @Blocker
    void steamDisplayingDescriptionGameText2(String gameData, String expectedText) {
        $("[placeholder=поиск]").setValue(gameData).pressEnter();
        $(".title").click();
        $(".game_description_snippet").shouldHave(Condition.text(expectedText));

    }


    static Stream<Arguments> steamDisplayingDescriptionGameText3() {
        return Stream.of(
                Arguments.of("Sekiro™: Shadows Die Twice - GOTY Edition", List.of("Для одного игрока",
                        "Достижения Steam", "Контроллер (полностью)", "Коллекционные карточки", "Steam Cloud",
                        "Remote Play на планшете", "Remote Play на телевизоре")),
                Arguments.of("The Callisto Protocol™", List.of("Для одного игрока", "Достижения Steam",
                        "Контроллер (полностью)", "Steam Cloud")),
                Arguments.of("Mount & Blade II: Bannerlord", List.of("Для одного игрока",
                        "Против игроков (по сети)", "Достижения Steam", "Коллекционные карточки", "Мастерская Steam",
                        "Контроллер (частично)", "Steam Cloud", "Включает редактор уровней", "Remote Play на планшете"))
        );
    }

    @MethodSource()
    @ParameterizedTest(name = "Поиск игры на сайте Steam {0} отображение кнопок на страницы игры {1}")
    @Regress
    @Blocker
    void steamDisplayingDescriptionGameText3(String gameData, List<String> expectedButtons) {
        $("[placeholder=поиск]").setValue(gameData).pressEnter();
        $(".title").click();
        $$(".game_area_features_list_ctn a").filter(visible).shouldHave(texts(expectedButtons));

    }


    @Disabled
    @ValueSource(strings = {
            "Привет", "Пока", "УРА"
    })

    @ParameterizedTest(name = "Ломаный тест {0}")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB")
    })

    void steamSearchTest2(String gameData) {
        $("[placeholder=поиск]").setValue(gameData).pressEnter();
        $(".title").click();
        $("#appHubAppName").shouldHave(text(gameData));
    }


}