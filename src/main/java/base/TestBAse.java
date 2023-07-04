 package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentReportManager;
import utility.ReadData;

public class TestBAse 
{
	//for rxtent report
	public ExtentReports report=ExtentReportManager.getReportInstance();
	public ExtentTest logger;
////for rxtent report
	public static ChromeDriver driver;
	public void initialization() throws InterruptedException, IOException
	{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(ReadData.readProperfile("url"));
		//driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
		driver.close();
	
	
		/*ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	    driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(ReadData.readProperfile("url"));
		driver.get("https://www.saucedemo.com/"); */
		Thread.sleep(3000);
}}