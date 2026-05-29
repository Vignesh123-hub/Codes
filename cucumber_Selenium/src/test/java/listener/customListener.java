package listener;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.DriverFactory;
import utils.ExtentManager;
import utils.Screenshot;

public class customListener implements ITestListener{
	private static ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		  test = ExtentManager.getInstance().createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		   test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, "Test Failed: " + result.getThrowable());

        // Capture screenshot
        String screenshotPath = Screenshot.captureScreenshot(
            DriverFactory.getDriver(), result.getMethod().getMethodName()
        );
       
        try {
            test.addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
        	 e.printStackTrace();
		}
        
		
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		 ExtentManager.getInstance().flush();
	}

	
	
	
	
	
	
}
