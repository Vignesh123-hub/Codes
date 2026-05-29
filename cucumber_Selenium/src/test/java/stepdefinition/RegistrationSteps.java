package stepdefinition;



import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistrationPage;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ExcelReader;
import utils.ExtentManager;


public class RegistrationSteps {

	
	WebDriver driver;
    RegistrationPage regPage;
    ExtentReports extent;
    ExtentTest test;

    @Given("user is on the registration page")
    public void user_is_on_registration_page() {
    	
    	
    	
        String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("url");

        driver = DriverFactory.getDriver(browser);
        driver.get(url);

        regPage = new RegistrationPage(driver);
        extent = ExtentManager.getInstance();
        test = extent.createTest("Registration Scenario on " + browser);
        test.info("Navigated to Registration Page using " + browser);
   
    }
    	
    	
    @When("user enters registration details")
    public void user_enters_registration_details_from_excel() {
        String filePath ="C:\\Users\\vikib\\eclipse-workspace\\cucumber_Selenium\\src\\test\\resources\\testdata\\data.xlsx";
        String sheetName = ConfigReader.getProperty("excelSheet");

        List<String> values = ExcelReader.getSecondColumnValues(filePath, sheetName);

     // Example: use values in order
     regPage.enterFirstName(values.get(0));
     regPage.enterLastName(values.get(1));
     regPage.enterAddress(values.get(2));
     regPage.enterCity(values.get(3));
     regPage.enterState(values.get(4));
     regPage.enterZipCode(values.get(5));
     regPage.enterPhone(values.get(6));
     regPage.enterSSN(values.get(7));
     regPage.enterUsername(values.get(8));
     regPage.enterPassword(values.get(9));
     regPage.enterConfirm(values.get(9));
     
     test.info("all details entered ");  
    


    }
    @And("clicks on Register button")
    public void clicks_on_register_button() {
    	

        regPage.clickRegister();
        test.info("Clicked Register button");
    

    	
    }
    	
    @Then("registration should be successful")
    public void registration_should_be_successful() {
    
    	  
    	  System.out.println(regPage.successmsg());
    	assertEquals(
    		    "Your account was created successfully. You are now logged in.",
    		    regPage.successmsg()
    		);
        
      
      

      
      
      
        extent.flush();
        DriverFactory.quitDriver();
    }
	
	
	
	
	
}
