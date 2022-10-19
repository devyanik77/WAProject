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

public class ShoppingCartPageTest extends TestBase{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	ShoppingCartPage shoppingCartPage;
	CheckoutPage checkoutPage;
	ProductDescPage productDescPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws Exception {
		initialization(browser);
	}	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void shoppingCartPageTitleTest(String uname, String pswd) {
		indexPage=new IndexPage();
		loginPage=indexPage.clickLoginMenu();
		homePage=loginPage.clickOnLogin(uname,pswd);
		productDescPage=homePage.clickOnProductImage();	
		shoppingCartPage=productDescPage.clickShoppingCart();
		String actTitle=shoppingCartPage.getShoppingCartPageTitle();
		Assert.assertEquals(actTitle, "Shopping Cart");
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void navigateToCheckoutPageTest(String uname, String pswd) {
		indexPage=new IndexPage();
		loginPage=indexPage.clickLoginMenu();
		homePage=loginPage.clickOnLogin(uname,pswd);
		productDescPage=homePage.clickOnProductImage();	
		shoppingCartPage=productDescPage.clickShoppingCart();
	
		checkoutPage=shoppingCartPage.proceedToCheckout();
		String actualTitle=driver.getTitle();
		String expectedTitle="Checkout";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
//	@Test
//	public void verifyTotPriceTest() {
//		Log.startTestCase("verifyTotPriceTest()");
//		Double totalActualPrice=shoppingCartPage.totalPrice();
//		Double totalExpectedPrice=500.2;
//		Assert.assertEquals(totalActualPrice, totalExpectedPrice);
//		Log.endTestCase("verifyTotPriceTest()");
//	}

}
