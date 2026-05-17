package Utils;


import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;



import com.microsoft.playwright.Page;

import base.basetest;

public class commonUtils extends basetest {

	
	public static String getscreenshot(  ) {
		
		
		
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        String path =System.getProperty("user.dir")+"\\src\\test\\resources\\screenshot\\"+timestamp+".png";
	        newPage.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
	        return path;
	    }
		
		
		
		
	
	}
	
	
	
	
	
	

