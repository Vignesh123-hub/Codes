package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class Screenshot   {

	
	

	 public static String captureScreenshot(WebDriver driver, String screenshotName) {
	        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	        String path = System.getProperty("user.dir") + "/src/test/resources/reports/Screenshots/" 
	                      + screenshotName + "_" + timestamp + ".png";

	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
	            FileUtils.copyFile(src, new File(path));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return path;
	    }
	

	
	
	
}
