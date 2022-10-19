package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.utilities.Action;

public class ConfirmOrderPage extends TestBase{
	Action action=new Action();
	@FindBy(xpath="//*[@id=\"shopping-cart-full\"]//tbody/tr/td[6]") private static WebElement unitPrice;
	@FindBy(xpath="//*[@id=\"reviewview\"]/div[2]/div/div[2]/div/table/tbody/tr[3]/td[2]") private static WebElement total;
	@FindBy(xpath="//button[@id='save']") private static WebElement confirmOrderButton;
	@FindBy(xpath="//*[@id=\"shopping-cart-full\"]/table/tbody/tr/td[5]") private static WebElement qty;
	@FindBy(xpath="//div[@class='well']/p") private static WebElement confirmOrderMsg;
	
	public ConfirmOrderPage() {
		PageFactory.initElements(driver, this);	
	}
	
	public double getUnitPrice() {
		String unitS=unitPrice.getText();
		String unitP= unitS.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice=Double.parseDouble(unitP);
		return finalUnitPrice/100;	
	}
	public double getTotal() {
		String totalS=total.getText();
		String totalP= totalS.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotal=Double.parseDouble(totalP);
		return finalTotal/100;	
	}

	public CompleteOrderPage clickConfirmOrder() {
		action.click(confirmOrderButton);
		action.fluentWait(driver, confirmOrderMsg, 10);
		action.isDisplayed(driver, confirmOrderMsg);	
		return new CompleteOrderPage();
	}
	

}
