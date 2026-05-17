package base;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Properties;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest {

	
public static Properties props;
	
	public static FileReader reader;
	
	public static Page newPage ;
	
	public static Browser launch;
	
	public static ExtentSparkReporter spark ;
	public static ExtentReports reports;
	
	public static ExtentTest test;
	
	
	
	
public void readfile() throws IOException {
		
		try {
			 props=new Properties();
			 
			  reader=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfile\\Config.properties");
			 
			 props.load(reader);
			 
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		 

	}
	
	
	
	
	public void Browser_Launch() {
	
		
		
		
		
		String	 brow = props.getProperty("browse");
			 
		String	url=  props.getProperty("url");
			
			
			if(brow.equals("chrome")) {
			
			
				 launch = Playwright.create().chromium().launch(new
						BrowserType.LaunchOptions()
						.setHeadless(false).setArgs(Arrays.asList("--start-maximized")));

				BrowserContext context = launch.newContext(
						new Browser.NewContextOptions()
						.setViewportSize(null)); 


				 newPage =context.newPage();
				newPage.navigate(url);
				
				
				
				
				
			}
			
			else if(brow.equals("edge"))
			{
				launch = Playwright.create().chromium().launch(new
						BrowserType.LaunchOptions()
						.setHeadless(false).setArgs(Arrays.asList("--start-maximized"))
						.setExecutablePath(Paths.get("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe")));

				BrowserContext context = launch.newContext(
						new Browser.NewContextOptions()
						.setViewportSize(null)); 


				 newPage =context.newPage();
				 newPage.navigate(url);
				
			}
			else
			{
				launch = Playwright.create().firefox().launch(new
						BrowserType.LaunchOptions()
						.setHeadless(false).setArgs(Arrays.asList("--start-maximized")));

				BrowserContext context = launch.newContext(
						new Browser.NewContextOptions()
						.setViewportSize(null)); 


				 newPage =context.newPage();
				 newPage.navigate(url);
				
			}
			
		}
		
		
		
		
		
	
	
	
	
	
	
	
	
	public void Final_reports() {
		
		String rep = System.getProperty("user.dir")+"\\src\\test\\resources\\reports\\ParaReport.html";
		
		
		
		 spark = new ExtentSparkReporter(rep);
		 reports = new ExtentReports();
		reports.attachReporter(spark);
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
