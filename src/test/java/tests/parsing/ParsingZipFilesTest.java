package tests.parsing;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ParsingZipFilesTest {

    ClassLoader cl = ParsingZipFilesTest.class.getClassLoader();

    @Test
    @DisplayName("Чтение содержимого файлов в формате  pdf, xlsx, csv из zip архива")
    void parsingZipFilesTest() throws Exception {

        try (
                InputStream resource = cl.getResourceAsStream("archive.zip");
                ZipInputStream zis = new ZipInputStream(resource)
        ) {
            ZipEntry entry;

            while((entry = zis.getNextEntry()) != null) {

                if (entry.getName().contains(".pdf")) {

                    PDF content = new PDF(zis);
                    assertThat(content.text).contains("Manual and Automation Testing");
                } else if (entry.getName().endsWith(".xls")) {

                    XLS content = new XLS(zis);
                    assertThat(content.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue()).contains("Dulce");
                } else if (entry.getName().endsWith(".csv")) {

                    CSVReader reader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> content = reader.readAll();
                    assertThat(content.get(0)[0]).contains("Identifier");
                }
            }
        }
    }
}
