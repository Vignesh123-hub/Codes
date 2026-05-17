package Testlisterner;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Utils.commonUtils;
import base.basetest;

public class customelistener extends basetest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
String methodname = result.getName();
		
		String logtext = "<b>"+ "TEST CASE:- "+ methodname.toUpperCase()+"  PASSED "+"</b>";
		
		Markup m = MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
		
		test.log(Status.PASS,m);
	}

	@Override
	public void onTestFailure(ITestResult result) {
test.log(Status.FAIL,result.getName()+"   Test Failed  ");
		
		String Screenshotpath = commonUtils.getscreenshot();
		
		test.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(Screenshotpath).build());
		
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
	if(reports != null ) {
			
			reports.flush();
			
	}

	
	
	
	
	}
	
	
}
