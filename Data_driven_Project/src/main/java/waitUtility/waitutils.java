package waitUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.baseTest;

public class waitutils  extends baseTest{

	int sec;
	 protected WebDriver driver;
	    protected WebDriverWait wait;

	    public waitutils(WebDriver driver ) {
	    	
	        this.driver = driver;
	        
	      int   sec = Integer.parseInt(props.getProperty("waittime"));
	        
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
	    }

	    public WebElement waitForVisibility(WebElement element) {
	        return wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    public WebElement waitForClickability(WebElement element) {
	        return wait.until(ExpectedConditions.elementToBeClickable(element));
	    }
	
	
	
	
	
}
