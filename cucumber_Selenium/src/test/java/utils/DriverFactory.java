package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class DriverFactory {

	 private static WebDriver driver;

	    public static WebDriver getDriver(String browser) {
	        if (driver == null) {
	            switch (browser.toLowerCase()) {
	                case "chrome":
	                    driver = new ChromeDriver();
	                    break;
	                case "firefox":
	                    driver = new FirefoxDriver();
	                    break;
	                case "edge":
	                    driver = new EdgeDriver();
	                    break;
	                default:
	                    throw new IllegalArgumentException("Unsupported browser: " + browser);
	            }
	        }
	        return driver;
	    }

	    // Overloaded no-arg method
	    public static WebDriver getDriver() {
	        if (driver == null) {
	            String browser = ConfigReader.getProperty("browser");
	            return getDriver(browser);
	        }
	        return driver;
	    }

	    public static void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	    }
	
	
	
	
	
	
	
	
	
}
