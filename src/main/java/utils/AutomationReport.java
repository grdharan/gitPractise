package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AutomationReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtentSparkReporter reporter = new ExtentSparkReporter("./TestReport.html");
		ExtentReports extent  = new ExtentReports();
		extent.attachReporter(reporter);
		ExtentTest test = extent.createTest("T001 - Search Product");
		test.assignAuthor("Surya");
		test.assignCategory("Regression");
		test.pass("Enter the desired product name");
		test.pass("Check if the product is listed");
		test.pass("Add the product to the cart");
		extent.flush();
	}

}
 