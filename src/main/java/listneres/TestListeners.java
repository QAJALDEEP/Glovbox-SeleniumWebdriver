package listneres;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.ExtentReportUtils;
import utils.TestUtils;

public class TestListeners extends ExtentReportUtils implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		threadLocalTest.set(getExtentReport().createTest(result.getName()));
		getTest().info("Test started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		getTest().pass("Test Passed");
		getTest().addScreenCaptureFromPath(TestUtils.captureFullPageScreenshot());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		getTest().fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		generateExtentHTMLReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		getExtentReport().flush();
		threadLocalTest.remove();
	}

}