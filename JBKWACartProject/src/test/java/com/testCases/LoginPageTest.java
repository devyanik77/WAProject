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
import com.utilities.DataProviders;

public class LoginPageTest extends TestBase{

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser){
		initialization(browser);	
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown(){
		driver.quit();
	}
	@Test(groups = "Smoke")
	public void loginPageTitleTest() {
		indexPage=new IndexPage();
		Log.info("Enter Username and Password");
		loginPage=indexPage.clickLoginMenu();
		String actTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, "Login");
	}
	@Test(groups = "Smoke")
	public void logoDisplayTest() {
		indexPage=new IndexPage();
		Log.info("User is clicking on Login Menu");
		loginPage=indexPage.clickLoginMenu();
		boolean result=loginPage.validateLogo();
		Assert.assertTrue(result);
		Log.info("Validated logo successfully");
	}

	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginCredentials(String uname, String pswd){
		indexPage=new IndexPage();
		Log.info("User is clicking on Login Menu");
		loginPage=indexPage.clickLoginMenu();
		Log.info("Enter Username and Password");
		String actualTitle=loginPage.logincredentials(uname,pswd);
		String expectedTitleL="Home";
		Assert.assertEquals(actualTitle, expectedTitleL);
		Log.info("Login is successful");

	}
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void navigateToHomePageTest(String uname, String pswd) {
		indexPage=new IndexPage();
		Log.info("User is clicking on Login Menu");
		loginPage=indexPage.clickLoginMenu();
		Log.info("Enter Username and Password");
		homePage=loginPage.clickOnLogin(uname,pswd);
		String actualURL=homePage.getCurrentUrl();
		String expectedURL="https://ingecnotechnologies.com/other/WACart/";
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Navigated to Home Page");
	}


}
