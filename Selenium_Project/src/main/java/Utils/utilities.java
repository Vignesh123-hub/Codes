package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.baseTest;

public class utilities extends baseTest{

	
	
	public static String getscreenshot() {
		

	String currentdate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
	System.out.println(currentdate);
	File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
		String Dest = System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\"+currentdate+".png";
		
		 try {
	            FileUtils.copyFile(source, new File(Dest));
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("failed "+e.getMessage());
	        }
	        return Dest;
	    }
		
	}
	
	
	
	

