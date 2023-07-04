package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBAse;
import pages.LoginPages;
import utility.CaptureScreenshot;
import utility.ReadData;

public class VerifyMultipleCredentialsTest extends TestBAse
{
LoginPages login;	
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException 
	{
		initialization();
		login=new LoginPages();
	}

	@Test (enabled=true)
	public void loginToApplication() throws IOException 
	{
		String exploginURL="https://www.saucedemo.com/inventory.html";
		//String exploginURL=ReadData.readExcel(1,2);
		String actloginURL=login.loginToApplication();
		Assert.assertEquals(exploginURL, actloginURL);//hard assertion or assert
		//Reporter.log("login to application"+actloginURL);
	}
	@Test (dataProvider = "credentials")
	public void loginToAppWithMultipleCredTest(String un, String pw) throws IOException
	{
		
		SoftAssert s=new SoftAssert();
		String exploginURL="https://www.saucedemo.com/inventory.html";
		//String exploginURL=ReadData.readExcel(1,2);
		String actloginURL=login.loginToAppWithMultipleCredTest(un,pw);
		s.assertEquals(exploginURL, actloginURL);
		s.assertAll();
	}
	@DataProvider(name = "credentials")
	public Object getData()
	{
		return new Object[] [] {// first array username second is pw
			{"standard_user","secret_sauce"},
			{"standarduser","secret_sauce"},
			{"standard_user "," secret_sauce"},
			{" standard_user","secret_sauce "},
				               };
	}
	@AfterMethod(alwaysRun = true) 
	public void closeBrowser(ITestResult it) throws IOException, InterruptedException 
	{
		if (it.FAILURE==it.getStatus())
		{
			CaptureScreenshot.screenShot(it.getName());
		}
	    Thread.sleep(3000);
		driver.close();
	}
}