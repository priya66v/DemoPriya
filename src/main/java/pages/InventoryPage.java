package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBAse;
import utility.HandleDropDown;
import utility.ReadData;

public class InventoryPage extends TestBAse 
{
@FindBy(xpath="//span[@class='title']")private WebElement ProductsText;
@FindBy(xpath="//div[@class='app_logo']")private WebElement SwagLAbText;
@FindBy(xpath="//button[@id='react-burger-menu-btn']")private WebElement ButtonOption;
@FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement ButtonCart;
@FindBy(xpath="//span[@class='shopping_cart_badge']")private WebElement CartCount;
@FindBy(xpath="//select[@class='product_sort_container']")private WebElement ButtonSortDropDown;

@FindBy(xpath="//li[@class='social_twitter']//a")private WebElement TwitterLogo;
@FindBy(xpath="//li[@class='social_facebook']//a")private WebElement FacebookLogo;
@FindBy(xpath="//li[@class='social_linkedin']//a")private WebElement LinkedInLogo;
//add to cart button
@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")private WebElement Buttonbackpack;
@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']")private WebElement Buttonbikelight;
@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")private WebElement ButtonboltTshirt;
@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']")private WebElement Buttonfleecejacket;
@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']")private WebElement Buttononesie;
@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")private WebElement buttontshirtred;

//remove button
@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']")private WebElement removeButtonbackpack;
@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']")private WebElement removeButtonbikelight;
@FindBy(xpath="//button[@id=remove-sauce-labs-bolt-t-shirt']")private WebElement removeButtonboltTshirt;
@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']")private WebElement removeButtonfleecejacket;
@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']")private WebElement removeButtononesie;
@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']")private WebElement removebuttontshirtred;
public InventoryPage()
{
PageFactory.initElements(driver,this);	
}

public String verifyProductsText()
{
return ProductsText.getText();
}
public boolean verifyTwitterLogo()
{
	return TwitterLogo.isDisplayed();
}
public boolean verifyFacebookLogo()
{
	return FacebookLogo.isDisplayed();
}
public boolean verifyLinkedInLogo()
{
	return LinkedInLogo.isDisplayed();
}

public String add6product() throws EncryptedDocumentException, IOException
{
	//Select s = new Select(ButtonSortDropDown);
	//s.selectByVisibleText("Name (Z to A)");
	HandleDropDown.handleSelectClass(ButtonSortDropDown, ReadData.readExcel(2, 0));  //"Name (A to Z)");//2,0
	Buttonbackpack.click();
	Buttonbikelight.click();
	ButtonboltTshirt.click();
	Buttonfleecejacket.click();
	Buttononesie.click();
	buttontshirtred.click();
	return CartCount.getText();
}
public String remove2product() throws InterruptedException, EncryptedDocumentException, IOException
{
	add6product();
	Thread.sleep(5000);
	removeButtonbackpack.click();
	removeButtononesie.click();
	return CartCount.getText();
}
public void ClickCartCount()
{
	CartCount.click();
}
}