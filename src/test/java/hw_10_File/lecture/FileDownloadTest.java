package hw_10_File.lecture;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;

public class FileDownloadTest {

//    //Если нет href
//    static { //Будет поднят прокси сервер и когда браузер будет отдавать файл проксисервир может его перехватить
//        //крайняя мера использовать только в одном тестовом класе а в другие вставлять дефольный файл HTTPGET
//        Configuration.fileDownload = FileDownloadMode.PROXY;
//    }

    @Test
        //Загружаем обьект с сайта
    void downloadTest() throws Exception {
        Selenide.open("https://github.com/qa-guru/niffler/blob/master/README.md");
        //download работает только с атрибутами href если нет href то выше static описан
        File download = $("a[href*='/qa-guru/niffler/raw/master/README.md']").download();
        //Файловый дискриптер на компьютере мы передаем файл download и надо закрыть InputStream или может быть утечка памяти
        try (InputStream is = new FileInputStream(download)) { //закроет все в круглых скобков само
            //читаем все содержимое это файла в види масива байт
            byte[] bytes = is.readAllBytes();
            //Создаем строку из массива передаем массив байт и передаем кодировку
            String fileAsString = new String(bytes, StandardCharsets.UTF_8);
            //Проверка что в файле есть такой текст
            Assertions.assertTrue(fileAsString.contains("Технологии, использованные в Niffler"));
        }

    }

    @Test
        //Загружаем на сайт обьект
    void uploadTest() throws Exception {
        Selenide.open("https://tus.io/demo.html");
         //Не пользуемся uploadFile а грузим из uploadFromClasspath это позволяет грузить из ресурсов в идеи
        // загрузка на сайт происходит всегда через input[type='file']
        $("input[type='file']").uploadFromClasspath("testdata_hw_10/lecture/hqdefault.jpg");
        $("#js-upload-container").shouldHave(Condition.text("The upload is complete!"));
    }
}
