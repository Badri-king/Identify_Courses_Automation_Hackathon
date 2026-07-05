package utilities;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {

    public  String getCellData(String filePath, String sheetName, int rowNum, int colNum)
            throws IOException {

        FileInputStream fis = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        String value = sheet.getRow(rowNum).getCell(colNum).toString();

        workbook.close();
        fis.close();

        return value;
    }
}
