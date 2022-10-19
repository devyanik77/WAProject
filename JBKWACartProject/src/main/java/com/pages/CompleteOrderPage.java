package com.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.TestBase;
import com.utilities.Action;

public class CompleteOrderPage extends TestBase{
	Action action=new Action();
	@FindBy(xpath="//div[@class='well']//p") private static WebElement orderConfirmMsg;
	@FindBy(xpath="//div[@class='well']//p[1]//a") private static WebElement myOrderLink;
	@FindBy(xpath="//div[@class='well']//p[2]//a") private static WebElement sendEmailLink;
	@FindBy(xpath="//a[@class='btn btn-success']") private static WebElement continueButton;
	
	public CompleteOrderPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public String getCompleteOrderPageTitle() {
		Log.info("Validate CompleteOrderPage Title with Expected title");
		String title=driver.getTitle();
		return title;
	}
	
	public String validateConfirmMsg() {
		return orderConfirmMsg.getText();
	}
	
	public HomePage clickOnContinue() {
		action.click1(driver, continueButton);
		return new HomePage();
	}

}
