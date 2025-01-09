package utils;

import java.io.File;
import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtils {

	protected static ThreadLocal<ExtentReports> threadLocalExtentReport = new ThreadLocal<>();
	protected static ThreadLocal<ExtentSparkReporter> threadLocalSparkReporter = new ThreadLocal<>();
	protected static ThreadLocal<ExtentTest> threadLocalTest = new ThreadLocal<>();

	public static ExtentReports getExtentReport() {
		if (threadLocalExtentReport.get() == null) {
			throw new IllegalStateException("ExtentReports is not initialized. Call generateExtentHTMLReport first.");
		}
		return threadLocalExtentReport.get();
	}

	public static ExtentSparkReporter getSparkReporter() {
		if (threadLocalSparkReporter.get() == null) {
			throw new IllegalStateException(
					"ExtentSparkReporter is not initialized. Call generateExtentHTMLReport first.");
		}
		return threadLocalSparkReporter.get();
	}

	public static ExtentTest getTest() {
		if (threadLocalTest.get() == null) {
			throw new IllegalStateException("ExtentTest is not initialized. Call generateExtentHTMLReport first.");
		}
		return threadLocalTest.get();
	}

	public static ExtentReports generateExtentHTMLReport() {
		if (threadLocalExtentReport.get() == null) {
			ExtentReports extentReports = new ExtentReports();
			threadLocalExtentReport.set(extentReports);

			String htmlReportFile = Paths
					.get(Constants.HTMLREPORT_FILE_PATH.toString(), TestUtils.getCurrentDateAndTime() + ".html")
					.toString();

			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(new File(htmlReportFile));
			threadLocalSparkReporter.set(sparkReporter);

			sparkReporter.config().setTheme(Theme.STANDARD);
			sparkReporter.config().setReportName("AcuityRisk Test Automation Report");
			sparkReporter.config().setDocumentTitle("AcuityRisk Test Automation Report");
			sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

			extentReports.attachReporter(sparkReporter);
			extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
			extentReports.setSystemInfo("Username", System.getProperty("user.name"));
			extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		}
		return threadLocalExtentReport.get();
	}
}