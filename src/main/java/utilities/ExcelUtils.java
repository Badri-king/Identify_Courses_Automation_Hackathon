package utilities;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public  String getCellData(String filePath, String sheetName, int rowNum, int colNum)
            throws IOException {

        FileInputStream fis = new FileInputStream(filePath);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        String value = sheet.getRow(rowNum).getCell(colNum).toString();

        workbook.close();
        fis.close();

        return value;
    }
}
