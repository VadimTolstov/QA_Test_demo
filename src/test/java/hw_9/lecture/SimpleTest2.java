package hw_9.lecture;


import hw_9.annotations.Blocker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@Disabled("Можно ставить над классом елси хотите отключить")
@DisplayName("Выводит название  тестсьютов")
public class SimpleTest2 {

    @BeforeEach
        //Прекрасно подходит для предусловия нестоить использовать @BeforeAll и  @AfterAll не работают при многопоточности  доклад Юпитер паралейная реальность
    void setUp() {

    }

    @CsvSource(value = {    //Позваляет передовать несколько параметров в тест как таблица
            "apple |         1",
            "banana |        2",
    },
            delimiter = '|' //делаем разделитель в таблици | если в тексте есть запятые
    )

    @CsvFileSource(resources = "/testdata_hw_9/steamDisplayingDescriptionGameText.csv", delimiter = '|') //используешь если есть файл с данными

    //Вызываем датапровайдер и через него смотрим какие методы у него есть, предоставляет 1 параметр в тест
    @ValueSource(strings = {
            "Селенид", "Аллюр"

    })

    @ParameterizedTest(name = "Выводит название теста {0}")//вызав параметризированого теста
    @Tag("BLOCKER") //Позваляет запустить тест блокер
    @Tags({   //можно комбенировать и запускать какие нужно тесты блокеры веб и тд
            @Tag("BLOCKER"),
            @Tag("WEB")
    })
    void simpleTest(String data) { //data возмется из датапровайдера и для этого надо использовать уже @ParameterizedTest

    }

    @Disabled("Можно написать почему отключили тест. Текит в джира к примеру")
    @Test
    @DisplayName("Выводит название теста")
    void disabledTest() {

    }


    @Test
    @DisplayName("Выводит название теста ")
    @Tag("BLOCKER") //Позваляет запустить тест блокер
    @Tags({   //можно комбенировать и запускать какие нужно тесты блокеры веб и тд
            @Tag("BLOCKER"),
            @Tag("WEB")
    })
    @Blocker
        //Создаем свою анатацию тестов Tag
    void simpleTest2() {

    }

    @Disabled("Можно написать почему отключили тест. Текит в джира к примеру")
    @Test
    @DisplayName("Выводит название теста")
    void disabledTest2() {

    }
}
