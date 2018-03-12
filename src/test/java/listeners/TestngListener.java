package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestngListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("###Testcase under execution :" + result.getName());
		Reporter.log("Testcase started at :" + result.getStartMillis());
		Reporter.log(result.getName());		// To report in tesng report
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Testcase successfully passed :" + result.getName() );
		System.out.println("Testcase status :" + result.getStatus());
		Long timeElapsed = result.getEndMillis() - result.getStartMillis();
		System.out.println("Testcase execution time :" + timeElapsed);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Testcase Failed :" + result.getName() );
		System.out.println("Testcase status :" + result.getStatus());
		Long timeElapsed = result.getEndMillis() - result.getStartMillis();
		System.out.println("Testcase execution time :" + timeElapsed);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcase Skipped " + result.getName() );
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

}
