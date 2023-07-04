package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBAse;
import utility.ReadData;

public class CartPage extends TestBAse 
{
	@FindBy(xpath="//div[@class='app_logo']")private WebElement SwagLabslabelCartPage;
	@FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement shoppingcartlink;
	@FindBy(xpath="//span[@class='shopping_cart_badge']")private WebElement shoppingcartbadge;
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")private WebElement burgermenubutton;
	@FindBy(xpath="//button[@id='checkout']")private WebElement checkoutbutton;
	@FindBy(xpath="//button[@id='continue-shopping']")private WebElement continueshoppingbutton;

	
	@FindBy(xpath="//a[@id='item_4_title_link']")private WebElement saucelabsbackpacklink;
	@FindBy(xpath="//div[@class='inventory_item_name']")private WebElement saucelabsbackpacklabel;
	@FindBy(xpath="//div[@class='inventory_item_desc'][1]")private WebElement saucelabsbackpackdescption;
	@FindBy(xpath="//div[@class='cart_quantity']")private WebElement saucelabsbackpackqty;
	@FindBy(xpath="//div[@class='inventory_item_price']")private WebElement saucelabsbackpackprice;
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")private WebElement removeubttonsaucelabsbackpack;
	//------------------------------------------------------------------------------
	@FindBy(xpath="//span[@class='title']")private WebElement YourCartLabel;
	@FindBy(xpath="//div[@class='cart_quantity_labelClickcheckoutbutton']")private WebElement qtyLabel;
	@FindBy(xpath="//div[@class='cart_desc_label']")private WebElement DescriptionLabel;
//---------------------------------------------------------------------
	
	public CartPage()
	{
	PageFactory.initElements(driver,this);	
	}
	
	public String verifyURLCartPage()
	{
		return driver.getCurrentUrl();
	}
	public String verifySwagLabslabelCartPage()
	{
	return SwagLabslabelCartPage.getText();
	}
	public String verifyYourCartLabel()
	{
	return YourCartLabel.getText();
	}
	public boolean verifyshoppingcartlink()
	{
		return shoppingcartlink.isDisplayed();
	}
	public boolean verifyshoppingcartbadge()
	{
		return shoppingcartbadge.isDisplayed();
	}
	public boolean verifyburgermenubutton()
	{
		return burgermenubutton.isDisplayed();
	}
	
	public void Clickcheckoutbutton()
	{
		checkoutbutton.click();
	}
}