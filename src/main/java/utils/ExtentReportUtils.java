package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtils {

	public ExtentReports generateExtentHTMLReport() {
		ExtentReports extentReports = new ExtentReports();
		File extentReportFile = new File("");
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportFile);

		extentReports.attachReporter(reporter);

		return extentReports;
	}

}
