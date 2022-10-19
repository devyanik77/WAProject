package com.pages;

import java.util.Random;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;
import com.utilities.Action;

public class IndexPage extends TestBase{
	
	Action action=new Action();
	Random randomGenerator = new Random(); 
	int randomInt = randomGenerator.nextInt(1000); 
	WebDriverWait wait;
	@FindBy (xpath="//a[@title='My Account']//span") private static WebElement myAccount;
	@FindBy (xpath="//li[@class='dropdown open']/ul/li/a[contains(text(),'Login')]") private static WebElement loginDrop;
	@FindBy (xpath="//li[@class='dropdown open']/ul/li/a[contains(text(),'Register')]") private static WebElement registerDrop;
	@FindBy (xpath="//*[@id=\"content\"]//div[1]/div/a") private static WebElement registerButton;
	@FindBy (id="navbarsearchform-keyword") private static WebElement searchBox;	
	@FindBy (xpath="//button[@class='btn btn-default btn-lg']") private static WebElement searchButton;
	@FindBy(xpath="//*[@id=\"content\"]/div/div/h2") private static WebElement searchResultPanelTitle;
	@FindBy (xpath="//a[normalize-space()='Register']")private static WebElement newCustHomeRegister;
	@FindBy (xpath="//h6[@class='panel-title']")private static WebElement registerPanelTitle;
	@FindBy (xpath="//*[@id=\"content\"]//div[1]/div/a")private static WebElement registertrationStartContinueButton;
	public IndexPage() {
		PageFactory.initElements(driver, this);
		
	}
	public SearchResultPage searchProduct(String productName) {
		action.type(searchBox, productName);
		wait=new WebDriverWait(driver, 10);
		action.click(searchButton);
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(searchResultPanelTitle));
		return new SearchResultPage();
	}
	
	public LoginPage clickLoginMenu() {
		action.click(myAccount);
		action.click(loginDrop);
		return new LoginPage();		
	}
	
	public RegisterCustomerPage clickRegisterMenu() {
		action.click1(driver, myAccount);
		action.click1(driver, registerDrop);
		action.fluentWait(driver, registerPanelTitle, 20);
		return new RegisterCustomerPage();		
	}
}
