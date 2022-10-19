package com.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.base.TestBase;
import com.pages.CheckoutPage;
import com.pages.CompleteOrderPage;
import com.pages.ConfirmOrderPage;
import com.pages.HomePage;
import com.pages.IndexPage;
import com.pages.LoginPage;
import com.pages.ProductDescPage;
import com.pages.SearchResultPage;
import com.pages.ShoppingCartPage;
import com.utilities.DataProviders;
import com.utilities.PropertiesUtil;

public class CompleteOrderPageTest extends TestBase {

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	ProductDescPage productDescPage;
	SearchResultPage searchResultPage;
	ShoppingCartPage shoppingCartPage;
	CheckoutPage checkoutPage;
	ConfirmOrderPage confirmOrderPage;
	CompleteOrderPage completeOrderPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		initialization(browser);
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown(){
		driver.quit();
	}
	
	@Test(groups = "Regression",dataProvider = "BillingAddressDP", dataProviderClass = DataProviders.class)
	public void returnHomePageTest(String fname, String lName, String emailId,String mno,String add1,String city, String state, String country, String postal_code) {
		indexPage=new IndexPage();
		loginPage=indexPage.clickLoginMenu();
		homePage=loginPage.clickOnLogin((PropertiesUtil.readProperties("username")), (PropertiesUtil.readProperties("password")));
		productDescPage=homePage.clickOnProductImage();	
		productDescPage.clickAddToCart();
		checkoutPage=productDescPage.clickCheckout();	
		confirmOrderPage=checkoutPage.fillCheckoutDetails(fname,lName,emailId,mno,add1,city,state,country,postal_code);
		completeOrderPage=confirmOrderPage.clickConfirmOrder();
		homePage=completeOrderPage.clickOnContinue();
		Assert.assertEquals(driver.getTitle(), "Home");
	}
	
	@Test(groups = "Regression",dataProvider = "BillingAddressDP", dataProviderClass = DataProviders.class)
	public void endToEndTest(String fname, String lName, String emailId,String mno,String add1,String city, String state, String country, String postal_code) {
		Log.info("User is going to open the application link");
		indexPage=new IndexPage();
		Log.info("User is going to click on Login Menu");
		loginPage=indexPage.clickLoginMenu();
		Log.info("Enter Username and Password");
		homePage=loginPage.clickOnLogin((PropertiesUtil.readProperties("username")), (PropertiesUtil.readProperties("password")));
		Log.info("Login is Sucessful");
		Log.info("User is going to click on product image on Home Page");
		productDescPage=homePage.clickOnProductImage();	
		Log.info("User is going to add the product in Shopping Cart");
		productDescPage.clickAddToCart();
		Log.info("User is going to checkout the added product");
		checkoutPage=productDescPage.clickCheckout();	
		Log.info("User is going to fill the billing and shipping details");
		confirmOrderPage=checkoutPage.fillCheckoutDetails(fname,lName,emailId,mno,add1,city,state,country,postal_code);
		Log.info("User is confirmed order");
		completeOrderPage=confirmOrderPage.clickConfirmOrder();
		Log.info("User is successfully completed the order");
		Assert.assertEquals(driver.getTitle(), "Complete Order");

	}
}
