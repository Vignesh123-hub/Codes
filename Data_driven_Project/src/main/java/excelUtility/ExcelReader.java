package excelUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	  public static String[][] getData(String filePath, String sheetName) throws Exception {
	        FileInputStream fis = new FileInputStream(filePath);
	        Workbook wb = WorkbookFactory.create(fis);
	        Sheet sheet = wb.getSheet(sheetName);

	        int rows = sheet.getPhysicalNumberOfRows();
	        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

	        String[][] data = new String[rows-1][cols];
	        for (int i = 1; i < rows; i++) {
	            for (int j = 0; j < cols; j++) {
	                data[i-1][j] = sheet.getRow(i).getCell(j).toString();
	            }
	        }
	        wb.close();
	        return data;
	    }
	
	
}
