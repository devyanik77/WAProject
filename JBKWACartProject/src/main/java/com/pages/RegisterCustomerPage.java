package com.pages;

import java.util.List;


import java.util.Random;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.TestBase;
import com.utilities.Action;

public class RegisterCustomerPage extends TestBase{
	Action action=new Action();
	Random randomGenerator = new Random(); 
	int randomInt = randomGenerator.nextInt(1000); 
	@FindBy (xpath="//a[normalize-space()='Register']")private static WebElement newCustHomeRegister;
	@FindBy (xpath="//a[contains(text(),'Continue')]")private static WebElement newCustRegContinueButton;	
	@FindBy(xpath="//*[@id=\"customerprofileeditview\"]/div[1]/ul/li[1]/a")private static WebElement newCustGenaralTab;
	@FindBy(xpath="//*[@id='customerprofileeditview']/div[1]/ul/li[2]/a")private static WebElement newCustPersonTab;	
	@FindBy(xpath="//*[@id=\"customerprofileeditview\"]/div[1]/ul/li[3]/a")private static WebElement newCustAddressTab;	
	@FindBy(id="customer-username")private static WebElement newCustUsername;
    @FindBy(id="customer-password") private static WebElement newCustPassword;	
	@FindBy(id="customer-confirmpassword")private static WebElement newCustConfPassword;	
	@FindBy(id="person-firstname") private static WebElement newCustFname;
	@FindBy(id="person-lastname")private static WebElement newCustLname;	
	@FindBy(id="person-email") private static WebElement newCustEmail ;
	@FindBy(id="person-mobilephone") private static WebElement newCustMobile;
	@FindBy(id="address-address1") private static WebElement newCustAdr1;
	@FindBy(id="address-address2") private static WebElement newCustAdr2;
	@FindBy(id="address-city") private static WebElement newCustCity;	
	@FindBy(id="address-state") private static WebElement newCustState;
	@FindBy(id="address-postal_code") private static WebElement newCustPostalCode;	
	@FindBy(xpath="//span[@id='select2-chosen-1']")  private static WebElement newCustClickTimezone;
	@FindBy(xpath="//div[@class='select2-result-label']")  private static  List<WebElement> timezoneOptions;
	@FindBy(xpath="//span[@id='select2-chosen-2']")  private static WebElement newCustClickCounty;
	@FindBy(xpath="//div[@class='select2-result-label']")  private static  List<WebElement> countryOptions;
	@FindBy(xpath="//button[@id='save']") private static WebElement newCustContinueButton;
	@FindBy(xpath="//*[@id=\"w10-success-0\"]")  private static WebElement regSuccessfulMsg;
	public RegisterCustomerPage() {
		PageFactory.initElements(driver, this);	
	}
	

	public boolean registerNewCustomer(String newUsername, String newTime,String newPassword, String newConfpwd, String newFirstname, String newLastname,String newEmail, String newMobile ,String newAdr1, String newAdr2,String newCity, String newState ,String newCountry, String newPostalcode )
	{	
//	action.click(newCustRegContinueButton);
//	action.click(newCustGenaralTab);
	action.type(newCustUsername, newUsername+randomInt);
	action.click(newCustClickTimezone);
	action.IMPLICIT_WAIT=20;
	for (WebElement option : timezoneOptions) {	
		if(option.getText().equals(newTime)) {
			option.click();
			break;
		}
	}
	Action.IMPLICIT_WAIT=10;
	action.type(newCustPassword, newPassword);
	action.type(newCustConfPassword, newConfpwd);
	action.click(newCustPersonTab);
	action.type(newCustFname, newFirstname);
	action.type(newCustLname, newLastname);
	action.type(newCustEmail, (newFirstname+ randomInt +"@gmail.com"  ));
	action.type(newCustMobile, newMobile);	
	action.click(newCustAddressTab);
	action.type(newCustAdr1, newAdr1);
	action.type(newCustAdr2, newAdr2);
	action.type(newCustCity, newCity);
	action.type(newCustState, newState);
	action.click(newCustClickCounty);
	Action.IMPLICIT_WAIT=10;
	for (WebElement option : countryOptions) {	
		if(option.getText().equals(newCountry)) {
			option.click();
			break;
		}
	}
	action.type(newCustPostalCode, newPostalcode);
	action.click(newCustContinueButton);
	action.fluentWait(driver, regSuccessfulMsg, 20);
	return regSuccessfulMsg.isDisplayed();		
	}

}
