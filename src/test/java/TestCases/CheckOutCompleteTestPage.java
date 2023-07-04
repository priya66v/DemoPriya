package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBAse;
import pages.CartPage;
import pages.CheckOutComplete;
import pages.CheckOutPage1;
import pages.CheckOutPage2;
import pages.InventoryPage;
import pages.LoginPages;
import utility.ReadData;

public class CheckOutCompleteTestPage extends TestBAse
{
	LoginPages login;
	InventoryPage invent;
	CartPage cart;
	CheckOutPage1 check1;
	CheckOutPage2 check2;
	CheckOutComplete complete;
	
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
	 initialization();

	login = new LoginPages();// teeno classes ka global object created
	invent  = new InventoryPage();
	cart = new CartPage();
	check1 = new CheckOutPage1();
	check2 = new CheckOutPage2();
	complete = new CheckOutComplete();
	
	login.loginToApplication();

	invent.add6product();
	invent.ClickCartCount();

	cart.Clickcheckoutbutton();
	
	check1.inputCheckOutInfo();// coz click continue btn is in this method inputcheck
	check2.ClickFinishBtn();
	}
	
	@Test
	public void verifyCheckOutCompleteURLTest() throws EncryptedDocumentException, IOException
	{
		String expURL = ReadData.readExcel(6, 0);// "https://www.saucedemo.com/checkout-complete.html";
		String actURL = complete.verifyCheckOutCompleteURL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of complete checkout page is "+ actURL);
	}
	
	@Test
	public void verifyCheckoutCompleteLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel = ReadData.readExcel(6, 1);//"Checkout: Complete!";
		String actLabel = complete.verifyCheckoutCompleteLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("label of complete checkout page is "+ actLabel);
	}
	
	@Test
	public void verifyponyExpressImageTest()
	{
		boolean result = complete.verifyponyExpressImage();
		Assert.assertEquals(result, true);
		Reporter.log("pony image "+ result);
	}

	@Test
	public void verifyThankyouforyourorderLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel = ReadData.readExcel(6, 2);// "Thank you for your order!";
		String actLabel = complete.verifyThankyouforyourorderLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("label of thank you on complete checkout page is "+ actLabel);
	}
	@Test
	public void verifyYourOrderLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel = ReadData.readExcel(6, 3);// "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actLabel = complete.verifyYourOrderLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("label of your order on complete checkout page is "+ actLabel);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
		
	}
	
}
