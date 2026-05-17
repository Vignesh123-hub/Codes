package testsetup;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import base.basetest;

public class Testsetup extends basetest {

	
	@BeforeSuite
	public void start_all() throws IOException {
		readfile();
		Browser_Launch();
	Final_reports();
		

	}
	
	
	@AfterSuite
	public void Close_All() {

	newPage.close();
		reports.flush();
		
	}
	
}
