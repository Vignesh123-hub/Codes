package Base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {

	
public static Properties props;
	
	public static FileReader reader;
	
	public static WebDriver driver;
	
	
	
	public static ExtentSparkReporter spark ;
	public static ExtentReports reports;
	
	public static ExtentTest test;
	
	
	
	
public void readfile() throws IOException {
		
		try {
			 props=new Properties();
			 
			  reader=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfile\\config.properties");
			 
			 props.load(reader);
			 
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		 

	}
	
	
	
	
	public void Browser_Launch() {
	
		
		
	String	 brow = props.getProperty("browse");
		 
	String	url=  props.getProperty("url");
		
		
		if(brow.equals("chrome")) {
		
		 driver = WebDriverManager.chromedriver().create();
		
		driver.manage().window().maximize();
		
		driver.get(url);
		
	//	test.log(Status.INFO, "Chrome browser launched");
		
		}
		
		else if(brow.equals("edge"))
		{
			 driver = WebDriverManager.edgedriver().create();
			
			driver.manage().window().maximize();
			driver.get(url);
		
		//	test.log(Status.INFO, "Edge browser launched");
		}
		else
		{
			
			 driver = WebDriverManager.firefoxdriver().create();
			
			driver.manage().window().maximize();
			driver.get(url);
			
		//	test.log(Status.INFO, "Firefox browser launched");
		}
		
	}
	
	
	
	
	
	
	
	public void Final_reports() {
		
		String rep = System.getProperty("user.dir")+"\\src\\test\\resources\\reports\\ParaReport.html";
		
		
		
		 spark = new ExtentSparkReporter(rep);
		 reports = new ExtentReports();
		reports.attachReporter(spark);
		
		

	}
	
	
	
	
}
