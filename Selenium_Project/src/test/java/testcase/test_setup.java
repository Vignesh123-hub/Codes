package testcase;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import base.baseTest;

public class test_setup extends baseTest {

	
	
	@BeforeSuite
	public void start_all() throws IOException {
		readfile();
		Browser_Launch();
	Final_reports();
		

	}
	
	
	@AfterSuite
	public void Close_All() {

	driver.close();
		reports.flush();
		
	}
	
	
}
