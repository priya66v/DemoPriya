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
import pages.InventoryPage;
import pages.LoginPages;
import utility.ReadData;

public class CheckOutTestPage1 extends TestBAse
{
	LoginPages login;
	InventoryPage invent;
	CartPage cart;
	CheckOutPage1 check1;

@BeforeMethod
public void setUp() throws InterruptedException, IOException
{
 initialization();

login = new LoginPages();// teeno classes ka global object created
invent  = new InventoryPage();
cart = new CartPage();
check1 =new CheckOutPage1();

login.loginToApplication();

invent.add6product();
invent.ClickCartCount();

cart.Clickcheckoutbutton();
}

@Test

public void verifyURLCheckOut1Test() throws EncryptedDocumentException, IOException
{
String expurl = ReadData.readExcel(3, 3);  //"https://www.saucedemo.com/checkout-step-one.html";3,3
String acturl = check1.verifyURLCheckOut1();
Assert.assertEquals(expurl, acturl);
Reporter.log("checkout page1 URL is "+acturl);
}

@Test

public void verifySwagLabsCheckOut1LabelTest() throws EncryptedDocumentException, IOException
{
	String explabel = ReadData.readExcel(3, 4);//"Swag Labs";3,4
	String actlabel = check1.verifySwagLabsCheckOut1Label();
	Assert.assertEquals(explabel, actlabel);
	Reporter.log("checkout page1 label is "+actlabel);
}
@Test

public void verifyCheckOutLabelTest() throws EncryptedDocumentException, IOException
{
	String explabel = ReadData.readExcel(3, 6);//"Checkout: Your Information";3,4
	String actlabel = check1.verifyCheckOutLabel();
	Assert.assertEquals(explabel, actlabel);
	Reporter.log("checkout your info page1 label is "+actlabel);
}
//
@Test

public void inputCheckOutInfoTest() throws EncryptedDocumentException, IOException
	{
	String expurl = ReadData.readExcel(3, 5); //"https://www.saucedemo.com/checkout-step-two.html";3,5
	String acturl = check1.inputCheckOutInfo();
	Assert.assertEquals(expurl, acturl);
	Reporter.log("checkout page2 URL is "+acturl);
}

@AfterMethod

public void closeBrowser()
{
	driver.close();
}
}