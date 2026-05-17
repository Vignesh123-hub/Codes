package ExcelUtility;


import org.testng.annotations.DataProvider;
public class Dataprovider {
	
	
	

	 @DataProvider(name = "specificCellData")
	    public Object[][] getSpecificCellData() {
		 
		 
		 String file = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\data.xlsx";
		 
		 
	        String firstname = Excel_Reader.getCellData(file, "Sheet1", 1, 1); 
	        
	        String lastname = Excel_Reader.getCellData(file, "Sheet1", 2, 1); 
	        
	        String address = Excel_Reader.getCellData(file, "Sheet1", 3, 1); 
	        
	        String city = Excel_Reader.getCellData(file, "Sheet1", 4, 1); 
	        
	        String state = Excel_Reader.getCellData(file, "Sheet1", 5, 1); 
	        
	        String zip = Excel_Reader.getCellData(file, "Sheet1", 6, 1); 
	        String phone = Excel_Reader.getCellData(file, "Sheet1", 7, 1); 
	        String ssn = Excel_Reader.getCellData(file, "Sheet1", 8, 1); 
	        String username = Excel_Reader.getCellData(file, "Sheet1", 9, 1); 
	        String password = Excel_Reader.getCellData(file, "Sheet1", 10, 1); 
	        
	        
	        
	        
	        
	        
	        
	        
	        // rowIndex=2 (3rd row), colIndex=1 (2nd column)

	        return new Object[][] { { firstname, lastname, address, city, state, zip , phone, ssn,username, password  } };
	    }
	
	
	
	
}