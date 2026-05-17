package ExcelUtility;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Reader {

	public static String getCellData(String filePath, String sheetName, int rowIndex, int colIndex) {
        String cellValue = null;
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowIndex);
            if (row != null) {
                Cell cell = row.getCell(colIndex);
                if (cell != null) {
                    cellValue = cell.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cellValue;
    }
	
	
	
	}
	
	

