package hw_10_File.lecture.parsing;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import com.codeborne.xlstest.XLS;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.opencsv.CSVReader;
import hw_10_File.lecture.Human;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;

public class FileParsingTest1 {

    //Класслодер Позволяет читать файлы из ресурсов еще можно получить из класса если класс был загружен раньше начала теста
    private ClassLoader cl = FileParsingTest1.class.getClassLoader();
    // private ClassLoader cl = this.getClass().getClassLoader(); тоже самое что выше

    @Test
//Посмотреть содержимую часть пдф
    void pdfParseTest() throws Exception {
        Selenide.open("https://junit.org/junit5/docs/current/user-guide/");
        File download = $("a[href*='junit-user-guide-5.9.2.pdf']").download();
        //вызываем библиотеку PDF
        PDF pdf = new PDF(download);
        Assertions.assertEquals(
                "Stefan Bechtold, Sam Brannen, Johannes Link, Matthias Merdes, Marc Philipp, Juliette de Rancourt, Christian Stein",
                pdf.author);
    }

    @Test
//Посмотреть что в экселе
    void xlsParseTest() throws Exception {
        Selenide.open("https://excelvba.ru/programmes/Teachers?ysclid=lfcu77j9j9951587711");
        File download = $("a[href*='teachers.xls'").download();
        XLS xls = new XLS(download);
//открываем хls.сам файл.первы лит(0).строчка(3).столбец(2).получаем что в ячейки лежит  отчет идет от нуля как в массиви
        //xls.excel.getSheetAt(0).getRow(3).getCell(2).getStringCellValue()
        Assertions.assertTrue(xls.excel.getSheetAt(0).getRow(3).getCell(2).getStringCellValue()
                .startsWith("1. Суммарное количество часов планируемое на штатную по всем разделам плана"));
    }

    @Test
//csv файл чтение из ресурса
    void csvParseTest() throws Exception {
        //метад Класлодера позволит прочитать файл try закроит ИнпутСтрем сам
        try (InputStream is = cl.getResourceAsStream("testdata_hw_10/lecture/gaguru.csv");
             // для того что бы закрыть еще ИспутСтримерРидер пишем вот так
             InputStreamReader isr = new InputStreamReader(is)) {
            CSVReader csvReader = new CSVReader(isr);
            //цсвРидер предоставляет интерфейс взамиодействия с ЦСВ самый простой метод редолАЛЛ возращяет лист массивов
            //стрингов
            List<String[]> content = csvReader.readAll();
            //проверяем                                        content - откуда .get(2) - 3 строка в файле
            Assertions.assertArrayEquals(new String[]{"Васенков", "PageObject"}, content.get(2));
        }
    }

    //Можем сравнить два файла один скаченый другой с ресурса
    @Test
    void fileEqulsTest() throws Exception {
        Selenide.open("https://github.com/qa-guru/qa_guru_18_files/blob/master/src/test/resources/qaguru.csv");
        File download = $("#raw-url").download();
        try (InputStream isExpected = cl.getResourceAsStream("testdata_hw_10/lecture/expectedfiles/gaguru.csv");
             InputStream downloaded = new FileInputStream(download)) {
            //и сравниваем файлы побайтно
            Assertions.assertArrayEquals(isExpected.readAllBytes(), downloaded.readAllBytes());
            //Другая проверка аналог
            //  Assertions.assertEquals(
            //       Objects.hash(isExpected.readAllBytes()),
            //     Objects.hash( downloaded.readAllBytes())
            // );
            //Другая проверка построчно
            //   Assertions.assertEquals(
            //           new String(isExpected.readAllBytes(), StandardCharsets.UTF_8),
            //          new String(downloaded.readAllBytes(), StandardCharsets.UTF_8)
            //          );
        }
    }

    @Test
        //Разжатие zip архива
    void zipTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("testdata_hw_10/lecture/expectedfiles/Dvsq.zip");
             // таким образом мы разжимаем zip архив
             ZipInputStream zs = new ZipInputStream(is)) {
            ZipEntry entry;
            //В цикли вайл присваем на каждой итерации присваем переменной содержимое архива когда вернет null цикл кончется
            while ((entry = zs.getNextEntry()) != null) {
                Assertions.assertEquals("Dvs.pdf", entry.getName());
                //аналог ниже
                //  Assertions.assertTrue(entry.getName().contains("Dvs.pdf"));
            }
        }
    }

    @Test
        //использование библиотеки Гугл для json
    void jsonTest() throws Exception {
        Gson gson = new Gson();
        try (InputStream is = cl.getResourceAsStream("testdata_hw_10/lecture/human.json");
             // для того что бы закрыть еще ИспутСтримерРидер пишем вот так
             InputStreamReader isr = new InputStreamReader(is)) {
            //JsonObject это мапа в него можно положить любой мпу
            JsonObject jsonObject = gson.fromJson(isr, JsonObject.class);

            Assertions.assertTrue(jsonObject.get("isClever").getAsBoolean());
            Assertions.assertEquals(33, jsonObject.get("age").getAsInt());
        }

    }

    @Test
        //использование библиотеки Гугл для json принемает класс Humman
    void jsonCleverTest() throws Exception {
        Gson gson = new Gson();
        try (InputStream is = cl.getResourceAsStream("testdata_hw_10/lecture/human.json");
             // для того что бы закрыть еще ИспутСтримерРидер пишем вот так
             InputStreamReader isr = new InputStreamReader(is)) {
            //Тут уже используем нашу модельку Humman
            Human human = gson.fromJson(isr, Human.class);

            Assertions.assertTrue(human.isClever);
            Assertions.assertEquals(33, human.age);
            Assertions.assertEquals("Dima", human.name);
        }
    }

}
