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
import pages.InventoryPage;
import pages.LoginPages;
import utility.CaptureScreenshot;
import utility.ReadData;

public class InventoryPageTest extends TestBAse 
{
LoginPages login;
InventoryPage invent;
	
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException 
	{
		initialization();
		login=new LoginPages();
		invent  = new InventoryPage();
		login.loginToApplication();
	}
	
	@Test (enabled=false)
	public void verifyProductsTextTest() throws EncryptedDocumentException, IOException
	{
		//String expText="Products";
		String expText=ReadData.readExcel(1,3);

		String actText=invent.verifyProductsText();
		Assert.assertEquals(expText, actText);
	Reporter.log("text of the label is"+actText);
	}
	
	@Test (enabled=false)
	public void add6product() throws EncryptedDocumentException, IOException
	{
		//String expcount="6";
		
		String expcount=ReadData.readExcel(1,4);

		String actcount=invent.add6product();
		Assert.assertEquals(expcount, actcount);
		Reporter.log("total produts added are "+actcount);
	}
	
	@Test (enabled=false)
	
	public void remove2product() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		//String expcount="4";
		String expcount=ReadData.readExcel(1,5);

		String actcount=invent.remove2product();
		Assert.assertEquals(expcount, actcount);
		Reporter.log("count of products after removal is "+actcount);
	}
	
	@Test (enabled=false)
	
	public void verifyTwitterLogoTest()
	{
		boolean result = invent.verifyTwitterLogo();
		Assert.assertEquals(result, false);
		Reporter.log("twitter logo is visible" + result);
	}
	
@Test (enabled=true)
	
	public void verifyFacebookLogoTest()
	{
		boolean result = invent.verifyFacebookLogo();
		Assert.assertEquals(result, false);
		Reporter.log("fb logo is visible" + result);
	}
	
@Test (enabled=false)

public void verifyLinkedInLogoTest()
{
	boolean result = invent.verifyLinkedInLogo();
	Assert.assertEquals(result, false);
	Reporter.log("linkedin logo is visible" + result);
}

	
	
@AfterMethod

public void closeBrowser(ITestResult it) throws IOException 
{
	
	/*if (it.FAILURE==it.getStatus())
	{
		CaptureScreenshot.screenShot();
	}
	driver.close();*///for single screenshot
	/*if (it.FAILURE==it.getStatus())
	{
		CaptureScreenshot.screenShot(it);
	}
	driver.close();*///date incomplete
	if (it.FAILURE==it.getStatus())
	{
		CaptureScreenshot.screenShot(it.getName());
	}
	driver.close();  //for series
}
}