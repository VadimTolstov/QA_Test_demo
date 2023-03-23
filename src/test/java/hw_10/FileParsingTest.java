package hw_10;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Files;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class FileParsingTest {


    private final ClassLoader cl = FileParsingTest.class.getClassLoader();

    @Test
    void zippedPdfParseTest() throws Exception {
        try (InputStream is = cl.getResourceAsStream("testdata_hw_10/zipFile.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                switch (Files.getFileExtension(entry.getName())) {
                    case "pdf" -> {
                        PDF pdf = new PDF(zis);

                        Assertions.assertEquals("Adobe InDesign CC 2015 (Macintosh)", pdf.creator,
                                "pdf parsed failed");
                    }
                    case "xlsx" -> {
                        XLS xls = new XLS(zis);
                        Assertions.assertTrue(
                                xls.excel.getSheetAt(0).getRow(4).getCell(2).getStringCellValue()
                                        .startsWith("John"),
                                "xlsx parsed failed");
                    }
                    case "csv" -> {
                        CSVReader reader = new CSVReader(new InputStreamReader(zis));
                        List<String[]> content = reader.readAll();
                        Assertions.assertArrayEquals(new String[]{"Тучс", " JUnit5", " 123"}, content.get(1),
                                "csv parsed failed");
                    }
                }
            }
        }
    }

    @Test
    void jsonTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = cl.getResourceAsStream("testdata_hw_10/file.json");
             InputStreamReader isr = new InputStreamReader(is)) {
            ParserJson parserJson = mapper.readValue(isr, ParserJson.class);

            Assertions.assertEquals("12-03-2022", parserJson.date);
            Assertions.assertEquals("Vadim", parserJson.friend.get(0).name);
        }
    }
}