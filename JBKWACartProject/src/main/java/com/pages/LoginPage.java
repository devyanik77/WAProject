package com.pages;

import java.util.Random;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;
import com.utilities.Action;
import com.utilities.PropertiesUtil;


public class LoginPage extends TestBase{

	Action action=new Action();
	Random randomGenerator = new Random(); 
	int randomInt = randomGenerator.nextInt(1000); 
	WebDriverWait wait;
	
	@FindBy(xpath="//*[@id='logo']/h1/a") private static WebElement logo;
	@FindBy(id="loginform-username") private static WebElement username;
	@FindBy(id="loginform-password")private static WebElement password;	
	@FindBy(id="savebutton") private static WebElement loginButton;
//	@FindBy (xpath="//a[@title='My Account']") private static WebElement myAccount;
//	@FindBy (xpath="//*[@id=\"w13\"]/li[2]/a") private static WebElement logoutDrop;	
	@FindBy (xpath="//*[@id=\"w5\"]/li[1]/a")private static WebElement newCustHomeRegister;
	@FindBy (xpath="//a[normalize-space()='Login']") private static WebElement loginDrop;	
//	@FindBy (xpath="//a[contains(text(),'Continue')]")private static WebElement newCustRegContinueButton;
	@FindBy(id="navbarsearchform-keyword") private static WebElement searchIcon;
	@FindBy(xpath="//span[contains(text(),'Item')]") private static WebElement itemHomeDisplay;
	@FindBy(xpath="//*[@id='loginform-rememberme']") private static WebElement rememberMeCheckBox;
	@FindBy(xpath="//*[@id=\"content\"]//div[2]/div[1]/h6") private static WebElement registerPanelText;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	public String getLoginPageTitle() {
		return driver.getTitle();
	}	
	
	public boolean validateLogo() {
		return action.isDisplayed(driver, logo);	
	}

	public String logincredentials(String uname, String pswd) {
		action.type(username, uname);	
		action.type(password, pswd);
		boolean shouldRememberMe=true;
		if(shouldRememberMe) {
			action.click(rememberMeCheckBox);
		}
		action.click(loginButton);
		action.fluentWait(driver, itemHomeDisplay, 20);
		return driver.getTitle();
	}

	public HomePage clickOnLogin(String uname, String pwd) {
		action.type(username, uname);
		action.type(password, pwd);
		action.click(loginButton);
		action.fluentWait(driver, itemHomeDisplay, 20);	
		return new HomePage();	
	}
	


}
