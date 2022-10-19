package com.pages;

import java.util.List;



import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;
import com.utilities.Action;

public class HomePage extends TestBase{

	Action action=new Action();
	WebDriverWait wait;
	
	@FindBy(id="loginform-username")private static WebElement username;	
	@FindBy(id="loginform-password")private static WebElement password;	
	@FindBy(xpath="//button[@id='savebutton']")private static WebElement loginButton;
	@FindBy (xpath="//span[normalize-space()='My Account']")private static WebElement myAccountLink;	
	@FindBy (xpath="//a[normalize-space()='Login']")private static WebElement loginLink;	
	@FindBy (xpath="//a[@title='My Account']") private static WebElement myAccount;	
	@FindBy (xpath="//a[normalize-space()='Login']") private static WebElement loginDrop;	
	@FindBy (xpath="//*[@class='add-cart']") private static List <WebElement> addCartList;
	@FindBy (xpath="//*[@class=\"add-cart\"  and  @data-productid='50']") private static WebElement addToCartBtn;
	@FindBy (xpath="//*[@id='navbarsearchform-keyword']") private static WebElement searchQueryTop;
	@FindBy (xpath="//*[@id='search']/span/button") private static WebElement submitSearchButton;
	@FindBy(xpath="//*[@id='content']/div/div/div/div[2]/div[1]/div/div[2]/h4/a") private static WebElement searchProdName;
	@FindBy(xpath="//*[@id=\"search-results-list-view\"]/div[1]/div/div/div/div[2]/h4/a") private static WebElement searchResProdName;
	@FindBy (xpath="//*[@class='product-thumb transition']") private static List <WebElement> listSearchResult;
	@FindBy (xpath="//div[@class='caption']//following-sibling::h4//a") private static List <WebElement> searchResultName;
	@FindBy(xpath="//a[normalize-space()='Sony Vaio 30\"']") private static WebElement prodName;
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[1]/a") private static WebElement desktopTab;
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[2]/a") private static WebElement laptopTab;
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[3]/a") private static WebElement cameraTab;
	@FindBy(xpath="//*[@id=\"search-results-list-view\"]/div[1]/div[1]/div/div/div[2]/h4/a") private static WebElement desktopTabProd;
	@FindBy(xpath="//*[@id=\"content\"]/div/div/div/div/div[2]/h1") private static WebElement prodDesc;
	@FindBy(xpath="//*[@id=\"button-cart\"]") private static WebElement addCartButtonOnProdDesc;
	@FindBy(xpath="//*[@id=\"//*[@id=\"content\"]/div/div/div/div[2]/div[2]/div/div[3]/button[1]") private static WebElement addCartClick;
	@FindBy(xpath="//a[@title='Shopping Cart']//span") private static WebElement shoppingCartMenuButton;
	@FindBy(xpath="//ul[@class='breadcrumb']//li//a") private static WebElement homeBreadCrumb;
	@FindBy(xpath="//*//h4//a") private static List<WebElement> homeItemsList;
	@FindBy(xpath="//*[@id='top-links']/ul/li[3]/a/span") private static WebElement clickShoppingCartMenu;
	@FindBy(xpath="//*[@id='cart']/div/ul/li[3]/div/p/a[1]") private static WebElement viewCartLink;
	
	@FindBy(xpath="//button[@type='button']//parent::div[@class='button-group']") private static List <WebElement> allGroupButtons;
	@FindBy(xpath="//*[@id=\"shopping-cart-full\"]/table/tbody/tr//td[2]") private static WebElement shoppingItemsNameList;
	
	@FindBy(xpath="//*[@id=\"wishlist-total\"]/span") private static WebElement wishListTopMenu;
	@FindBy(xpath="//li/a[@title='Shopping Cart']/span") private static WebElement shoppingCartTopMenu;
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[4]/a") private static WebElement checkoutTopMenu;
	@FindBy(xpath="//li/a[@title='Compare']/span") private static WebElement compareTopMenu;
	@FindBy(xpath="//*[@id='content']//div[2]/div[3]/div/div[1]/a/img") private static WebElement prodImage;
	@FindBy(xpath="//*[@id='content']//table/tbody/tr/td[1]/label/strong") private static WebElement rateThis;

	public HomePage() {
		PageFactory.initElements(driver, this);	
	}
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	public String getCurrentUrl() {
		String homePageURL= driver.getCurrentUrl();
		return homePageURL;
	}
	public boolean searchOptOnHomePage() {
		return action.isDisplayed(driver, searchQueryTop);
	}
	public boolean validateWishList() {
		return action.isDisplayed(driver, wishListTopMenu);
	}
	public boolean validateShoppingCart() {
		return action.isDisplayed(driver, shoppingCartTopMenu);
	}
	public boolean validateCheckout() {
		return action.isDisplayed(driver, checkoutTopMenu);
	}
	public boolean validateCompare() {
		return action.isDisplayed(driver, compareTopMenu);
	}

	public int noOfSearchProduct(String productName) {
		action.type(searchQueryTop, productName);
		action.click1(driver, submitSearchButton);
		Action.IMPLICIT_WAIT=20;
		int size=listSearchResult.size();
		action.click(homeBreadCrumb);
		return size;	
	}

	public boolean searchProductResult() {	
		boolean flag=false;
		String ProductName=searchProdName.getText();                // Get Product Name
		String strippedProductName= StringUtils.strip(ProductName, "\"");	
		action.type(searchQueryTop, strippedProductName);
		action.click1(driver, submitSearchButton);
		String SearchResultProductname=searchResProdName.getText();                // Get Name of Searched Product				
		if(ProductName.equalsIgnoreCase(SearchResultProductname)) {
			flag=true;
			
		}else{
			flag=false;
		}
		action.click(homeBreadCrumb);
		return flag;
	}	
	public void addItemToCart(String itemName) {	
		Log.info("Adding item to Cart");
		String addCartButtonXpath="//a[contains(text(), '%s')]//parent::h4//parent::div//following-sibling::div//button[@class='add-cart']";
		WebElement addToCartButton=driver.findElement(By.xpath(String.format(addCartButtonXpath, itemName)));
		addToCartButton.click();
	}
	
	public boolean displayAllButtons() {	
		boolean flag=false;
		for (WebElement buttonOpt : allGroupButtons) {
			flag=action.isDisplayed(driver, buttonOpt);
			break;
		}	
		return flag;		
	}
	public boolean clickProductImage() {
		action.click(prodImage);
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(rateThis));
		return action.isDisplayed(driver, rateThis);
	}
	public ProductDescPage clickOnProductImage() {
		action.click(prodImage);
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(rateThis));
		return new ProductDescPage();
	}
	
//	public ShoppingCartPage goToShoppingCartPageCart() {
//		Log.info("Navigating to the ShoppingCart Page ");	
//		action.click(shoppingCartMenuButton);
//		Log.info("Navigated to the ShoppingCart Page ");
//		return new ShoppingCartPage();
//	}

}
