package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
	ExtentReports extent ;
	ExtentTest test;
	protected void startreport() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./TestReport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	protected void stopreport(){
		extent.flush();
	}
	void createtest(String desc , String author , String category) {
		test = extent.createTest(desc);
		test.assignAuthor(author);
		test.assignCategory(category);
	}
	void stepReport(String status,String description) {
		switch(status.toLowerCase()) {
		case "pass":
			test.fail(description);
			break;
		case "fail":
			test.fail(description);
			break;
		case "info":
			test.info(description);
			break;
		case "warning":
			test.warning(description);
			break;
		default:
			System.err.println("Status is not defined");
		}
	}
}
