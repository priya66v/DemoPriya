package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import base.TestBAse;
import pages.LoginPages;
import utility.CaptureScreenshot;
import utility.ReadData;

public class LoginTestPages extends TestBAse
{
	LoginPages login;
	
	@BeforeMethod (alwaysRun = true)
	public void setUp() throws InterruptedException, IOException 
	{
		initialization();
		login=new LoginPages();
	}


@Test (enabled=true)
public void loginToApplication() throws IOException
{
	//String exploginURL="https://www.saucedemo.com/inventory.html";
	String exploginURL=ReadData.readExcel(1,2); 
	String actloginURL=login.loginToApplication();
	Assert.assertEquals(exploginURL, actloginURL);
	Reporter.log("login to application"+actloginURL);
}
@Test (enabled=false)
public void verifyURLTest() throws EncryptedDocumentException, IOException
{
	//String expectedURL="https://www.saucedemo.com/";
	String expectedURL=ReadData.readExcel(1,1);
	String actualURl=login.verifyURL();
	Assert.assertEquals(expectedURL, actualURl);
	Reporter.log("verify URl"+actualURl);	
}
@Test(enabled=false)
public void verifyTitleTest() throws EncryptedDocumentException, IOException
{
	//String expectedTitle="Swag Labs111";
	String expectedTitle=ReadData.readExcel(1,0);
	String actualTitle=login.verifyTitleofApp();
	Assert.assertEquals(expectedTitle, actualTitle);
	Reporter.log("verify title - text"+actualTitle);
}



@AfterMethod
public void closeBrowser(ITestResult it) throws IOException 
{
	if (it.FAILURE==it.getStatus())
	{
		CaptureScreenshot.screenShot(it.getName());
	}
	report.flush();//for extent
	driver.close();  //for series
	
}
}