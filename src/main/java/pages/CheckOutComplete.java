package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBAse;

public class CheckOutComplete extends TestBAse
{
	@FindBy(xpath="//span[@class='title']")private WebElement CheckoutCompleteLabel;
	
	@FindBy(xpath="//img[@class='pony_express']")private WebElement ponyExpressImage;
	@FindBy(xpath="//h2[@class='complete-header']")private WebElement ThankyouforyourorderLabel;
	@FindBy(xpath="//div[@class='complete-text']")private WebElement YourOrderLabel;
	
	@FindBy(xpath="//button[@id='back-to-products']")private WebElement BackHomeBtn;


public CheckOutComplete()
{
	PageFactory.initElements(driver, this);
}

public String verifyCheckOutCompleteURL()
{
	return driver.getCurrentUrl();
}

public String verifyCheckoutCompleteLabel()
{
return 	CheckoutCompleteLabel.getText();
}


public boolean verifyponyExpressImage()
{
return 	ponyExpressImage.isDisplayed();
}
public String verifyThankyouforyourorderLabel()
{
return 	ThankyouforyourorderLabel.getText();
}
public String verifyYourOrderLabel()
{
return 	YourOrderLabel.getText();


}
/*public void clickBackHomeBtn()
{
	BackHomeBtn.click();
}*/
}