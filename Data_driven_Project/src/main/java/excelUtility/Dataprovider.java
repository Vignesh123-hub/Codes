package excelUtility;
import org.testng.annotations.DataProvider;
public class Dataprovider {

	@DataProvider(name = "registerData")
	public Object[][] getRegisterData() throws Exception {
	    return ExcelReader.getData("src/test/resources/testdata/data.xlsx", "Sheet1");
	}
	
	
	
}
