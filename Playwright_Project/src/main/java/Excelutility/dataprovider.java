package Excelutility;

import org.testng.annotations.DataProvider;



public class dataprovider {

	 @DataProvider(name = "specificCellData")
	    public Object[][] getSpecificCellData() {
		 
		 
		 String file = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\data.xlsx";
		 
		 
	        String firstname = excelreader.getCellData(file, "Sheet1", 1, 1); 
	        System.out.println(firstname);
	        String lastname = excelreader.getCellData(file, "Sheet1", 2, 1); 
	        
	        String address = excelreader.getCellData(file, "Sheet1", 3, 1); 
	        
	        String city = excelreader.getCellData(file, "Sheet1", 4, 1); 
	        
	        String state = excelreader.getCellData(file, "Sheet1", 5, 1); 
	        
	        String zip = excelreader.getCellData(file, "Sheet1", 6, 1); 
	        String phone = excelreader.getCellData(file, "Sheet1", 7, 1); 
	        String ssn = excelreader.getCellData(file, "Sheet1", 8, 1); 
	        String username = excelreader.getCellData(file, "Sheet1", 9, 1); 
	        String password = excelreader.getCellData(file, "Sheet1", 10, 1); 
	        
	        
	        
	        
	        
	        
	        
	        
	        // rowIndex=2 (3rd row), colIndex=1 (2nd column)

	        return new Object[][] { { firstname, lastname, address, city, state, zip , phone, ssn,username, password  } };
	    }
	
}
