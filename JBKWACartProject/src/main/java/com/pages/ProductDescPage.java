package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;
import com.utilities.Action;

public class ProductDescPage extends TestBase{

	Action action=new Action();
	WebDriverWait wait;
	
	@FindBy(xpath="//input[@id='product_quantity']") private static WebElement quantity;
	@FindBy(xpath="//button[@id='button-cart']") private static WebElement addToCart;
	@FindBy(xpath="//span[@class='caret']") private static WebElement caret;
	@FindBy(xpath="//*[@id='cart']//tr/td[2]/a") private static WebElement caretProductName;
	@FindBy(xpath="//*[@id='cart']//li[3]/div/p/a[1]") private static WebElement viewCartLink;
	@FindBy(xpath="//div[@class='radio']//label//input") private static List<WebElement> clickSizeSelect;
	@FindBy(xpath="//*[@id='content']//div[1]/h6") private static WebElement checkoutPanelTitle;
	@FindBy(xpath="//a[@title='Wish List']//span") private static WebElement wishListMenu;
	@FindBy(xpath="//a[@title='Shopping Cart']//span") private static WebElement shoppingCartMenu;
	@FindBy(xpath="//a[@title='Checkout']//span") private static WebElement checkoutMenu;
	@FindBy(xpath="//a[@title='Compare']//span") private static WebElement compareMenu;
	@FindBy(xpath="//*[@id='content']//div[1]/div[2]/button[1]") private static WebElement addToWishListButton;
	@FindBy(xpath="//*[@id='content']//div[1]/div[2]/button[1]") private static WebElement addToCompareButton;
	@FindBy(xpath="//a[@id='product-write-review']") private static WebElement writeReviewLink;
	@FindBy(xpath="//textarea[@id='productreview-review']") private static WebElement textAreaWriteReview;
	@FindBy(xpath="//button[@id='save']") private static WebElement submitReviewButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-review']") private static WebElement reviewSubmitAlert;
	@FindBy(xpath="//*[@id=\"content\"]/div/div/div/h2") private static WebElement shoppingCartPanelTitle;

	public ProductDescPage() {
		PageFactory.initElements(driver, this);	
	}

	public void enterQuantity(String qty) {
		action.type(quantity, qty);
	}
	public void clickAddToCart() {
		action.click1(driver, addToCart);
	}
	public boolean validateAddToCart() {
		action.click1(driver, caret);
		return action.isDisplayed(driver, caretProductName);
	}
	
//	public void clickToWriteReview() {
//		action.click1(driver, writeReviewLink);
//	}
	
	public boolean writeReview(String text) {
		action.click1(driver, writeReviewLink);
//		action.fluentWait(driver, textAreaWriteReview, 10);
		action.type(textAreaWriteReview, text);
		action.click(submitReviewButton);
		action.fluentWait(driver, reviewSubmitAlert, 20);
		return action.isDisplayed(driver, reviewSubmitAlert);		
	}
	
	public boolean writeReviewLink() {
		return action.isDisplayed(driver, writeReviewLink);
	}
	
	public CheckoutPage clickCheckout() {
		action.click1(driver, checkoutMenu);
		action.fluentWait(driver, checkoutPanelTitle, 20);
		return new CheckoutPage();
	}
	
	public ShoppingCartPage clickShoppingCart() {
		action.click1(driver, shoppingCartMenu);
		action.fluentWait(driver, shoppingCartPanelTitle, 20);
		return new ShoppingCartPage();
	}
	
	
	
}
