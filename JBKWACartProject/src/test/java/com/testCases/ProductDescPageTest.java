package com.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.base.TestBase;
import com.pages.CheckoutPage;
import com.pages.HomePage;
import com.pages.IndexPage;
import com.pages.LoginPage;
import com.pages.ProductDescPage;
import com.pages.SearchResultPage;
import com.pages.ShoppingCartPage;
import com.utilities.DataProviders;

public class ProductDescPageTest extends TestBase{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	ProductDescPage productDescPage;
	SearchResultPage searchResultPage;
	ShoppingCartPage shoppingCartPage;
	CheckoutPage checkoutPage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		initialization(browser);
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown(){
		driver.quit();
	}
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void validateAddToCartTest(String uname, String pswd) {
		indexPage=new IndexPage();
		loginPage=indexPage.clickLoginMenu();
		homePage=loginPage.clickOnLogin(uname, pswd);
		productDescPage=homePage.clickOnProductImage();	
		boolean result=productDescPage.validateAddToCart();
		Assert.assertTrue(result);
	}
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void writeReviewTest(String uname, String pswd) {
		String reviewText="This is a good product";
		indexPage=new IndexPage();
		loginPage=indexPage.clickLoginMenu();
		homePage=loginPage.clickOnLogin(uname, pswd);
		productDescPage=homePage.clickOnProductImage();	
		boolean result=productDescPage.writeReview(reviewText);	
		Assert.assertTrue(result);
	}
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void navigateToShoppingCartPage(String uname, String pswd) {
		indexPage=new IndexPage();
		loginPage=indexPage.clickLoginMenu();
		homePage=loginPage.clickOnLogin(uname, pswd);
		productDescPage=homePage.clickOnProductImage();	
		shoppingCartPage=productDescPage.clickShoppingCart();
		String actualTitle=driver.getTitle();
		String expectedTitle="Shopping Cart";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void navigateToCheckoutPage(String uname, String pswd) {
		indexPage=new IndexPage();
		loginPage=indexPage.clickLoginMenu();
		homePage=loginPage.clickOnLogin(uname, pswd);
		productDescPage=homePage.clickOnProductImage();	
		checkoutPage=productDescPage.clickCheckout();
		String actualTitle=driver.getTitle();
		String expectedTitle="Checkout";
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	
	
}
