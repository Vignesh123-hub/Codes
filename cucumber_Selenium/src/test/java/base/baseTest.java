package base;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ExtentManager;
import utils.Screenshot;

public class baseTest {

	   protected WebDriver driver;
	    protected ExtentReports extent;
	    protected ExtentTest test;

	    @Before
	    public void setUp() {
	    	 String browser = ConfigReader.getProperty("browser");
	    	    String url = ConfigReader.getProperty("url");

	    	    if (browser == null || url == null) {
	    	        throw new RuntimeException("Browser or URL not set in config.properties!");
	    	    }

	    	    driver = DriverFactory.getDriver(browser);
	    	    driver.get(url);

	    	    extent = ExtentManager.getInstance();
	    	    test = extent.createTest("Registration Test on " + browser);
	    	    test.info("Browser launched: " + browser);
	    	    test.info("Navigated to: " + url);
	    }
	    
	    @Before
	    public void setUp(Scenario scenario) {
	  
	        driver = DriverFactory.getDriver(); // no-arg version recommended
	        extent = ExtentManager.getInstance();
	       test = extent.createTest(scenario.getName());
	        test.info("Starting scenario: " + scenario.getName());
	    }
	    
	    @AfterStep
	    public void captureScreenshot( Scenario scenario) {
	        if (scenario.isFailed()) {
	            String screenshotPath = Screenshot.captureScreenshot(driver, scenario.getName());
	            test.fail("Step failed: " + scenario.getName())
	                .addScreenCaptureFromPath(screenshotPath);
	        }
	    }
	    
	    @After
	    public void tearDown(Scenario scenario) {
	    	 if (!scenario.isFailed()) {
	             test.pass("Scenario passed successfully");
	         }
	         extent.flush();	
	         DriverFactory.quitDriver();
	     }
	    }
	
	

