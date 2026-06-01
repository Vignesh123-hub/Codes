package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	
	public static List<String> getSecondColumnValues(String filePath, String sheetName) {
	    List<String> values = new ArrayList<>();

	    try (FileInputStream fis = new FileInputStream(filePath);
	         Workbook workbook = WorkbookFactory.create(fis)) {

	        Sheet sheet = workbook.getSheet(sheetName);
	        if (sheet == null) {
	            throw new RuntimeException("Sheet '" + sheetName + "' not found in Excel file!");
	        }

	        // Skip header row (row 0)
	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);
	            if (row != null) {
	                Cell valueCell = row.getCell(1); // second column
	                if (valueCell != null) {
	                    values.add(getCellValueAsString(valueCell));
	                }
	            }
	        }

	        if (values.isEmpty()) {
	            throw new RuntimeException("No values read from Excel second column!");
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return values;
	}

	
	private static String getCellValueAsString(Cell cell) {
	    switch (cell.getCellType()) {
	        case STRING:
	            return cell.getStringCellValue().trim();
	        case NUMERIC:
	            if (DateUtil.isCellDateFormatted(cell)) {
	                return cell.getDateCellValue().toString();
	            } else {
	                return String.valueOf((long) cell.getNumericCellValue()); // cast to long to avoid .0
	            }
	        case BOOLEAN:
	            return String.valueOf(cell.getBooleanCellValue());
	        case FORMULA:
	            return cell.getCellFormula();
	        case BLANK:
	            return "";
	        default:
	            return "";
	    }
}}