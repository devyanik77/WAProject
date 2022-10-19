package com.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.base.TestBase;
import com.pages.HomePage;
import com.pages.IndexPage;
import com.pages.LoginPage;
import com.pages.ProductDescPage;
import com.pages.SearchResultPage;
import com.pages.ShoppingCartPage;
import com.utilities.DataProviders;
import com.utilities.PropertiesUtil;

public class HomePageTest extends TestBase{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	ProductDescPage productDescPage;
	SearchResultPage searchResultPage;
	ShoppingCartPage shoppingCartPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		initialization(browser);
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown(){
		driver.quit();
	}
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void homePageTitleTest(String uname, String pswd) {
		
		indexPage=new IndexPage();
		Log.info("User is clicking on Login Menu");
		loginPage=indexPage.clickLoginMenu();
		Log.info("Enter Username and Password");
		homePage=loginPage.clickOnLogin(uname, pswd);
		Log.info("Login is Sucessful & Home Page displayed");
		String actTitle=homePage.getHomePageTitle();
		Assert.assertEquals(actTitle, "Home");
		Log.info("Validated Home Page title successfuly");
	}
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void searchOptDisplayTest(String uname, String pswd) {
		indexPage=new IndexPage();
		Log.info("User is going to click on Login Menu");
		loginPage=indexPage.clickLoginMenu();
		Log.info("Enter Username and Password");
		homePage=loginPage.clickOnLogin(uname,pswd);
		Log.info("Login is Sucessful & Home Page displayed");
		Log.info("Veryfing Search box on Home Page");
		boolean actResult=homePage.searchOptOnHomePage();
		Assert.assertTrue(actResult);
		Log.info("Search box is displayed");
	}
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void wishListTest(String uname, String pswd) {
		indexPage=new IndexPage();
		Log.info("User is going to click on Login Menu");
		loginPage=indexPage.clickLoginMenu();
		Log.info("Enter Username and Password");
		homePage=loginPage.clickOnLogin(uname,pswd);
		Log.info("Login is Sucessful & Home Page displayed");
		boolean result=homePage.validateWishList();	
		Assert.assertTrue(result);
		Log.info("Wish List Menu is displayed on top");
	}
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void shoppingCartTest(String uname, String pswd) {
		indexPage=new IndexPage();
		Log.info("User is going to click on Login Menu");
		loginPage=indexPage.clickLoginMenu();
		Log.info("Enter Username and Password");
		homePage=loginPage.clickOnLogin(uname,pswd);
		Log.info("Login is Sucessful & Home Page displayed");
		boolean result=homePage.validateShoppingCart();	
		Assert.assertTrue(result);
		Log.info("Shopping Cart Menu is displayed on top");
	}
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void checkoutTest(String uname, String pswd) {	
		indexPage=new IndexPage();
		Log.info("User is going to click on Login Menu");
		loginPage=indexPage.clickLoginMenu();
		Log.info("Enter Username and Password");
		homePage=loginPage.clickOnLogin(uname,pswd);
		Log.info("Login is Sucessful & Home Page displayed");
		Log.info("Validating Checkout Menu Link on top");
		boolean result=homePage.validateCheckout();	
		Assert.assertTrue(result);
		Log.info("Checkout Menu is displayed on top");
	}
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void compareTest(String uname, String pswd) {	
		indexPage=new IndexPage();
		loginPage=indexPage.clickLoginMenu();
		homePage=loginPage.clickOnLogin(uname,pswd);
		Log.info("Login is Sucessful & Home Page displayed");
		Log.info("Validating Checkout Menu Link on top");
		boolean result=homePage.validateCompare();	
		Assert.assertTrue(result);
		Log.info("Compare Menu is displayed on top");
	}
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void verifyProductSearchTest(String uname, String pswd) {
		indexPage=new IndexPage();
		Log.info("User is going to click on Login Menu");
		loginPage=indexPage.clickLoginMenu();
		Log.info("Enter Username and Password");
		homePage=loginPage.clickOnLogin(uname,pswd);
		Log.info("Login is Sucessful & Home Page displayed");
		Log.info("Veryfing Product search ");
		boolean actResult=homePage.searchProductResult();
		Assert.assertTrue(actResult);	
		
	}	
	@Test (dataProvider = "searchProductDP", dataProviderClass = DataProviders.class, description="Search Product by Brand")
	public void noSearchProductTest(String productName){
		indexPage=new IndexPage();
		Log.info("User is going to click on Login Menu");
		loginPage=indexPage.clickLoginMenu();
		Log.info("Enter Username and Password");
		homePage=loginPage.clickOnLogin((PropertiesUtil.readProperties("username")), (PropertiesUtil.readProperties("password")));
		Log.info("Login is Sucessful & Home Page displayed");
		Log.info("Veryfing Product search by product brandname ");
		int actualNoOfResults=homePage.noOfSearchProduct(productName);
		Assert.assertEquals(actualNoOfResults, 8);
		Log.info("Product searched successfully");
	}

	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void displayOfButtonsTest(String uname, String pswd) {
		indexPage=new IndexPage();
		Log.info("User is going to click on Login Menu");
		loginPage=indexPage.clickLoginMenu();
		Log.info("Enter Username and Password");
		homePage=loginPage.clickOnLogin(uname,pswd);
		boolean actResult=homePage.displayAllButtons();
		Assert.assertTrue(actResult);
		Log.info("AddtoCart,WishList & compare button is visible ");
	}

	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void addItemToCart(String uname, String pswd) {	
		indexPage=new IndexPage();
		loginPage=indexPage.clickLoginMenu();
		Log.info("Enter Username and Password");
		homePage=loginPage.clickOnLogin(uname,pswd);	
		Log.info("Login is Sucessful & Home Page displayed");
		Log.info("Adding product to shopping cart");
		homePage.addItemToCart("Sony Vaio 30");	
		Log.info("Product added to shopping cart");
	}
	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void navigateToProductDescPageTest(String uname, String pswd) {
		indexPage=new IndexPage();
		loginPage=indexPage.clickLoginMenu();
		Log.info("Enter Username and Password");
		homePage=loginPage.clickOnLogin(uname,pswd);
		Log.info("Login is Sucessful & Home Page displayed");
		Log.info("Navigating to ProductDescriptionPage");
		boolean result=homePage.clickProductImage();
		Assert.assertTrue(result);
		Log.info("Navigated to ProductDescriptionPage succesfully");
	}
}
