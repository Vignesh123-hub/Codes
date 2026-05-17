package testcase;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import ExcelUtility.Dataprovider;
import base.baseTest;
import pages.HomePage;

public class RegisterAccount extends baseTest {

	
	@Test(dataProvider = "specificCellData",dataProviderClass = Dataprovider.class)
	public void create_newAccount(String firstname, String lastname, String address, String city, String state, String zip, String phone, String ssn, String username, String password) {
		
		test = reports.createTest("Creating new account");
		
		HomePage Home = new HomePage(driver);
		
		Home.Registerclick();
		test.log(Status.INFO, "Register is selected");
		
		Home.RegisterFname(firstname);
		test.log(Status.INFO, "First name entered");
		
		Home.RegisterLname(lastname);
		test.log(Status.INFO, "last name entered");
		
		
		Home.RegisterAdd(address);
		test.log(Status.INFO, "Address entered");
		
		
		Home.RegisterCity(city);
		test.log(Status.INFO, "City entered");
		
		
		Home.RegisterState(state);
		test.log(Status.INFO, "State entered");
		
		Home.RegisterZip(zip);
		test.log(Status.INFO, "Zip entered");
		
		Home.RegisterPhone(phone);
		test.log(Status.INFO, "Phone number entered");
		
		Home.RegisterSSn(ssn);
		test.log(Status.INFO, "SSN entered");
		
		Home.RegisterUsername(username);
		test.log(Status.INFO, "username entered");
		
		Home.RegisterPassword(password);
		test.log(Status.INFO, "Password entered");
		
	Home.RegisterRepeat(password);
		test.log(Status.INFO, "Password repeated");
		
		Home.RegisterSubmit();
		test.log(Status.INFO, "submit button clicked");
		
		Assert.assertEquals(Home.RegisterSuccess(),"Your account was created successfully. You are now logged in.");
		test.log(Status.INFO, "Comparison done");
	}
	
	
	
	
	
}
