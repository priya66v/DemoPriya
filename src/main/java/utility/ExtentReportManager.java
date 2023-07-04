package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {

	public static ExtentReports report;   // globally declare
	public static ExtentReports getReportInstance()
	{
		if(report==null)
		{
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("D:\\sel framework prog loc\\21stBatchTesting\\ExtentReport\\priyaextent.html");
		report=new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Environment", "Production");
		report.setSystemInfo("Build number", "1.22.33.44");
		report.setSystemInfo("Browser", "Chrome");
		htmlReporter.config().setDocumentTitle("UI Automation");
		htmlReporter.config().setReportName("UI Test Reports");
		}
		return report;
}}