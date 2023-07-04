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
import pages.CheckOutPage1;
import pages.CheckOutPage2;
import pages.InventoryPage;
import pages.LoginPages;
import utility.ReadData;

public class CheckOutTestPage2 extends TestBAse

{
	LoginPages login;
	InventoryPage invent;
	CartPage cart;
	CheckOutPage1 check1;
	CheckOutPage2 check2;
	
@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
	 initialization();

	login = new LoginPages();// teeno classes ka global object created
	invent  = new InventoryPage();
	cart = new CartPage();
	check1 = new CheckOutPage1();
	check2 = new CheckOutPage2();
	
	login.loginToApplication();

	invent.add6product();
	invent.ClickCartCount();

	cart.Clickcheckoutbutton();
	
	check1.inputCheckOutInfo();// coz click continue btn is in this method inputcheck
}
@Test
public void verifyCheckOutOverviewLabelTest() throws EncryptedDocumentException, IOException
{
	String explabel = ReadData.readExcel(5, 0);//"Checkout: Overview";
	String actlabel = check2.verifyCheckOutOverviewLabel();
	Assert.assertEquals(explabel, actlabel);
	Reporter.log("checkout page2 label is "+actlabel);
}

@Test

public void verifyPaymentInfoLabelTest() throws EncryptedDocumentException, IOException
{
	String explabel = ReadData.readExcel(5, 1);//"Payment Information";
	String actlabel = check2.verifyPaymentInfoLabel();
	Assert.assertEquals(explabel, actlabel);
	Reporter.log("information payment label is "+actlabel);
}

@Test

public void verifyShippingInfoLabelTest() throws EncryptedDocumentException, IOException
{
	String explabel = ReadData.readExcel(5, 2);//"Shipping Information";
	String actlabel = check2.verifyShippingInfoLabel();
	Assert.assertEquals(explabel, actlabel);
	Reporter.log("shipping payment label is "+actlabel);
}

@Test

public void verifyPriceTotalLabelTest() throws EncryptedDocumentException, IOException
{
	String explabel =ReadData.readExcel(5, 3);// "Price Total";
	String actlabel = check2.verifyPriceTotalLabel();
	Assert.assertEquals(explabel, actlabel);
	Reporter.log("total price label is "+actlabel);
}

@AfterMethod

public void closeBrowser()
{
driver.close();	
}
}