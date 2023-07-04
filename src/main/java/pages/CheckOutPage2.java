package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBAse;

public class CheckOutPage2 extends TestBAse
{
@FindBy(xpath="//div[@class='app_logo']") private WebElement SwagLabsCheckOutPage2Label;
@FindBy(xpath="//span[@class='title']")private WebElement CheckOutOverviewLabel;//checkoutPAGE2LABLE

@FindBy(xpath="//div[@class='summary_info_label'][1]")private WebElement PaymentInfoLabel;
@FindBy(xpath="//div[@class='summary_info_label'][2]")private WebElement ShippingInfoLabel;
@FindBy(xpath="//div[@class='summary_info_label'][3]")private WebElement PriceTotalLabel;

@FindBy(xpath="//button[@name='finish']")private WebElement FinishBtn;

public CheckOutPage2()// constructor create karenge , initelement is method
{
	PageFactory.initElements(driver, this);
}
public String verifyCheckOutOverviewLabel()
{
	return CheckOutOverviewLabel.getText();
}

public String verifyPaymentInfoLabel()
{
	return PaymentInfoLabel.getText();
}

public String verifyShippingInfoLabel()
{
	return ShippingInfoLabel.getText();
}
public String verifyPriceTotalLabel()
{
	return PriceTotalLabel.getText();
}

public void ClickFinishBtn()
{
	FinishBtn.click();
}
}