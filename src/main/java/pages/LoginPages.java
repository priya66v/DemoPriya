package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBAse;
import utility.ReadData;

public class LoginPages extends TestBAse
{
	//object repository
@FindBy(xpath="//input[@id='user-name']") private WebElement userNameTextBox;
@FindBy(xpath="//input[@id='password']") private WebElement PasswordTextBox;
@FindBy(xpath="//input[@type='submit']") private WebElement LoginButton;
//constructor to initialize the web element (current class member )

public LoginPages()
{
  PageFactory.initElements(driver, this);
}


public String loginToApplication() throws IOException
{ 
	
	 logger = report.createTest("login to sauce lab application");// for extent
	userNameTextBox.sendKeys(ReadData.readProperfile("username"));
	
	logger.log(Status.INFO, "user name is entered");//4 extent report
 
	PasswordTextBox.sendKeys(ReadData.readProperfile("password"));
	logger.log(Status.INFO, "password is entered");

	
	/*userNameTextBox.sendKeys("standard_user");
	PasswordTextBox.sendKeys("secret_sauce");*/
	LoginButton.click();
	logger.log(Status.INFO, "login button is click");
	logger.log(Status.INFO, "login successful !");

	
	return driver.getCurrentUrl();
}

public String loginToAppWithMultipleCredTest (String un , String pw) 
{	
	userNameTextBox.sendKeys(un);
	PasswordTextBox.sendKeys(pw);
	LoginButton.click();
	return driver.getCurrentUrl();
}
public String verifyTitleofApp()
{
	return driver.getTitle();
}
public String verifyURL()
{
	return driver.getCurrentUrl();
}
}