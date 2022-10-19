package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.base.TestBase;
import com.utilities.Action;

public class ShoppingCartPage extends TestBase{

	Action action=new Action();
	WebDriverWait wait;
	@FindBy(xpath="//*[@id=\"search-results-list-view\"]/div[1]/div[1]/div/div/div[1]/a/img") private static WebElement productResult;
	@FindBy(xpath="//button[@type='button']//a//i[@class='fa fa-shopping-cart']") private static WebElement addToCartBtn;
	@FindBy(xpath="//*[@id=\"shopping-cart-full\"]/table/tbody/tr/td[2]/a") private static WebElement cartProductName;
	@FindBy(xpath="//a[@class='btn btn-success']") private static WebElement contButton;
	@FindBy(xpath="//*[@id=\"shopping-cart-full\"]/table/tbody/tr[1]/td[6]") private static WebElement unitPrice;
	@FindBy(xpath="//*[@id=\"shopping-cart-full\"]/table/tbody/tr[1]/td[7]") private static WebElement unitTax;
	@FindBy(xpath="//*[@id=\"shopping-cart-full\"]/table/tbody/tr[1]/td[8]") private static WebElement totoalPrice;
	@FindBy(xpath="//*[@id='shopping-cart-full']/table/tbody/tr[1]/td[5]/div[1]/input") private static WebElement cartProductQuantity;
	@FindBy(xpath="//div[@class='pull-left']//a") private static WebElement continueShoppingButton;
	@FindBy(xpath="//a[@class='btn btn-success']") private static WebElement checkoutButton;
	@FindBy(xpath="//*[@id='content']//div[1]/h6") private static WebElement checkoutPanelTitle;
	@FindBy(xpath="//*[@id=\"shopping-cart-full\"]//tr[1]/td[5]/div[1]/input") private static WebElement quantity;
	public ShoppingCartPage() {
		PageFactory.initElements(driver, this);	
	}

	public String getShoppingCartPageTitle() {
		String title=driver.getTitle();
		return title;
	}

	public int getQuantity() {
		String qty1	=cartProductQuantity.getAttribute("value");
		//	String qty1=cartProductQuantity.getText();
		int quantity=Integer.parseInt(qty1);
		return quantity;
	}

	public double getUnitPrice(){
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;	
	}
	public double getTotalPrice() {
		String totalPrice1=totoalPrice.getText();
		String totalP=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice=Double.parseDouble(totalP);
		return finalTotalPrice/100;
	}
	public double getTaxPrice() {
		String taxPrice1=unitTax.getText();
		String totalP=taxPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalTax=Double.parseDouble(totalP);
		return finalTotalTax/100;
	}

	public Double totalPrice(){
		Double unitPrice=getTotalPrice();
		Double totalTax=getTaxPrice();
		int qt=getQuantity();
		Double totalPrice=getTaxPrice();
		System.out.println(unitPrice);
		System.out.println(totalTax);
		System.out.println(qt);
		System.out.println(totalPrice);
		Double tp=(unitPrice*qt)+totalTax;
		
		return tp;
	}
	
	public void proceedToContinueShopping() {		
		action.click(continueShoppingButton);
	}
	public void enterQuantity(String qty) {
		action.type(quantity, qty);
		
	}
	public CheckoutPage proceedToCheckout() {
		action.click1(driver, checkoutButton);
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(checkoutPanelTitle));
		return new CheckoutPage();
		
	}


}
