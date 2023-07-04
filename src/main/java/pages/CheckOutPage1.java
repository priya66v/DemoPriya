package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBAse;
import utility.ReadData;

public class CheckOutPage1 extends TestBAse
{
@FindBy (xpath = "//div[@class='app_logo']") private WebElement SwagLabsCheckOut1Label;
@FindBy (xpath = "//span [@class='title']") private WebElement CheckOutLabel;

@FindBy (xpath = "//input [@id='first-name']") private WebElement FirstNameLabel; 
@FindBy (xpath = "//input [@id='last-name']") private WebElement LastNameLabel; 
@FindBy (xpath = "//input [@id='postal-code']") private WebElement ZipPostalCodeLabel; 

@FindBy (xpath = "//button[@name='cancel']") private WebElement ButtonCancel; 
@FindBy (xpath = "//input[@name='continue']") private WebElement ButtonContinue; 


public CheckOutPage1()// constructor create karenge , initelement is method
{
	PageFactory.initElements(driver, this);
}


public String verifyURLCheckOut1() 
{
	return driver.getCurrentUrl();
}

public String verifySwagLabsCheckOut1Label()
{
return SwagLabsCheckOut1Label.getText();
}
public String verifyCheckOutLabel()
{
return CheckOutLabel.getText();
}
//

public String inputCheckOutInfo() throws EncryptedDocumentException, IOException
{
	FirstNameLabel.sendKeys(ReadData.readExcel(3, 0));//"Priya"); //3,0
	LastNameLabel.sendKeys(ReadData.readExcel(3, 1));////"v");//3,1
	ZipPostalCodeLabel.sendKeys(ReadData.readExcel(3, 2));//("123456");//3,2
	
	ButtonContinue.click();
	
	return driver.getCurrentUrl();//continue button pe click ke bad wale page ka url 
}}