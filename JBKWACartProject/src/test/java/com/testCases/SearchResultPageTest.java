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

public class SearchResultPageTest extends TestBase {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
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
	@Test(groups = "Smoke")
	public void SearchResultPageTitleTest() {
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("Sony");
		String result=driver.getTitle();
		Assert.assertEquals(result, "Search Results");
	}
	@Test(groups = "Smoke")
	public void productAvailabilityWithoutLoginTest() {
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("Sony");
		boolean result=searchResultPage.isProductAvailable("Sony Vaio 25");
		Assert.assertTrue(result);
	}
//	@Test
//	public void productAvailabilityWithLoginTest() {
//		indexPage=new IndexPage();
//		loginPage=indexPage.clickLoginMenu();
//		homePage=loginPage.clickOnLogin();
//		
//		searchResultPage=indexPage.searchProduct("Sony");
//		boolean result=searchResultPage.isProductAvailable("Sony Vaio 25");
//		Assert.assertTrue(result);
//	}
	
	@Test
	public void clickOnSearchedProductTest() {
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("Sony");
		productDescPage =searchResultPage.clickOnProduct("Sony Vaio 25");
		boolean result=productDescPage.writeReviewLink();
		Assert.assertTrue(result);
	}

}
