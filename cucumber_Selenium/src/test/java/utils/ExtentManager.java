package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	

	 public   ExtentTest test;
	private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir") + "\\src\\test\\resources\\reports\\ExtentReport.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setDocumentTitle("Automation Report");
            spark.config().setReportName("Registration Test Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }
        return extent;
    }
	
	
	
	
	
	
	
	
	
	
	
}
