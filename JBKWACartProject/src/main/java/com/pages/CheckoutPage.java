package com.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.base.TestBase;
import com.utilities.Action;

public class CheckoutPage extends TestBase{
	Action action=new Action();
	WebDriverWait wait;
	@FindBy(id="billinginfoeditform-firstname") private static WebElement firstname;
	@FindBy(id="billinginfoeditform-lastname") private static WebElement lastname;
	@FindBy(id="billinginfoeditform-email") private static WebElement email;
	@FindBy(id="billinginfoeditform-mobilephone") private static WebElement mobilephone;
	@FindBy(id="billinginfoeditform-address1") private static WebElement address1;
	@FindBy(id="billinginfoeditform-city") private static WebElement city;
	@FindBy(id="billinginfoeditform-state") private static WebElement state;
	@FindBy(id="billinginfoeditform-postal_code") private static WebElement postalcode;
	@FindBy(xpath="//span[@id='select2-chosen-1']") private static WebElement countryElement;
	@FindBy(xpath="//input[@id='deliveryinfoeditform-sameasbillingaddress']") private static WebElement sameasbillingaddressCheckbox;
	@FindBy(xpath="//input[@value='cashondelivery']") private static WebElement cashondeliveryRadioButton;
	@FindBy(xpath="//input[@value='paypal_standard']") private static WebElement paypalRadioButton;
	@FindBy(id="paymentmethodeditform-agree") private static WebElement agreeCheckbox;
	@FindBy(xpath="//*[@id='save']") private static WebElement continueButton;
	@FindBy(xpath="//div[@class='select2-result-label']") private static List<WebElement> countries;
	@FindBy(xpath="//*[@id=\"reviewview\"]/div[1]/div[3]/legend") private static WebElement shippingMethod;

	public CheckoutPage() {
		PageFactory.initElements(driver, this);	
	}

	public String getCheckoutPageTitle() {
		String title=driver.getTitle();
		return title;
	}
	public ConfirmOrderPage fillCheckoutDetails(String fname, String lName, String emailId,String mno,String add1,String city, String state, String country, String postal_code){
		action.type(firstname, fname);
		action.type(lastname, lName);
		action.type(email, emailId);
		action.type(mobilephone, mno);
		action.type(address1, add1);
		action.type(CheckoutPage.city, city);
		action.type(CheckoutPage.state, state);
		action.click(countryElement);
		Action.IMPLICIT_WAIT=10;
		for (WebElement option : countries) {	
			if(option.getText().equals(country)) {
				option.click();
				break;
			}
		}
		action.type(postalcode, postal_code);	

		action.click(sameasbillingaddressCheckbox);
		if(!sameasbillingaddressCheckbox.isSelected()) {
			sameasbillingaddressCheckbox.click();
		}

		action.click(cashondeliveryRadioButton);
		action.click(agreeCheckbox);
		action.click(continueButton);
		action.fluentWait(driver, shippingMethod, 10);
		return new ConfirmOrderPage();
	}

	public void selectCashOndelivery() {
		action.click(cashondeliveryRadioButton);	
	}
	public void selectPayPalStandard() {
		action.click(cashondeliveryRadioButton);	
	}

	public ConfirmOrderPage goToConfirmOrderPageCart() {
		action.fluentWait(driver, continueButton, 20);
		action.click1(driver, continueButton);
		return new ConfirmOrderPage();
	}
}
