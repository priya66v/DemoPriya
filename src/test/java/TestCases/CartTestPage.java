package TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBAse;

import pages.InventoryPage;
import pages.LoginPages;
import utility.ReadData;
import pages.CartPage;

public class CartTestPage extends TestBAse
{
	
	LoginPages login;// these are objects of the classes
	InventoryPage invent;
	CartPage cart;
	
	@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
		initialization();
		
		login=new LoginPages();
		invent  = new InventoryPage();
		cart = new CartPage();
		
		login.loginToApplication();
		
		invent.add6product();
		invent.ClickCartCount();
	}

@Test(priority = 0)

public void verifyURLCartPageTest() throws EncryptedDocumentException, IOException
{
	String expURL = ReadData.readExcel(4, 0);//"https://www.saucedemo.com/cart.html";//4,0
	String actURL=cart.verifyURLCartPage();
	Assert.assertEquals(expURL, actURL);
	Reporter.log("URL of Cart PAge is "+ actURL);	
}

@Test (priority = 1 /*, dependsOnMethods = verifyURLCartPage*/)

public void verifySwagLabslabelCartPageTest() throws EncryptedDocumentException, IOException
{
	String explabel = ReadData.readExcel(4, 1);//"Swag Labs";//4,1
	String actlabel=cart.verifySwagLabslabelCartPage();
	Assert.assertEquals(explabel, actlabel);
	Reporter.log("label of Cart PAge is "+ actlabel);	
}
@Test
public void verifyYourCartLabelTest() throws EncryptedDocumentException, IOException
{
	String explabel = ReadData.readExcel(4, 2);//"Your Cart";//4,2
	String actlabel=cart.verifyYourCartLabel();
	Assert.assertEquals(explabel, actlabel);
	Reporter.log("label of your cart is "+ actlabel);	
}

//
@AfterMethod

public void closeBrowser() 
{
driver.close();	
}
}