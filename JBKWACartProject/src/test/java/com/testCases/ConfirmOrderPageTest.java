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

public class ConfirmOrderPageTest extends TestBase{

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
	public void checkoutPageTitleTest(String fname, String lName, String emailId,String mno,String add1,String city, String state, String country, String postal_code) {
		indexPage=new IndexPage();
		Log.info("User is going to click on Login Menu");
		loginPage=indexPage.clickLoginMenu();
		Log.info("User is going to click on Login Menu");
		Log.info("Enter Username and Password");
		homePage=loginPage.clickOnLogin((PropertiesUtil.readProperties("username")), (PropertiesUtil.readProperties("password")));
		Log.info("Clicking on product image on Home Page");
		productDescPage=homePage.clickOnProductImage();	
		Log.info("Adding the product in Shopping Cart");
		productDescPage.clickAddToCart();
		Log.info("Clicking the Checkout on the top & Navigating to Checkout Page");
		checkoutPage=productDescPage.clickCheckout();
		Log.info("Filling out the checkout billing & shipping details,and navigating to ConfirmOrder page");
		confirmOrderPage=checkoutPage.fillCheckoutDetails(fname,lName,emailId,mno,add1,city,state,country,postal_code);
		Log.info("Proceed further by clicking ConfirmOrder");
		completeOrderPage=confirmOrderPage.clickConfirmOrder();
		Assert.assertEquals(driver.getTitle(), "Complete Order");
		Log.info("User successfully completed order");

	}



}
