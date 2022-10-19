package com.testCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.IndexPage;
import com.pages.LoginPage;

public class IndexPageTest extends TestBase{
	private IndexPage indexPage;
	private LoginPage loginPage;
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser){
		initialization(browser);
		indexPage=new IndexPage();
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown(){
		driver.quit();
	}
	@Test
	public void goToLoginPageTest() {
		indexPage=new IndexPage();
		Log.info("User is clicking on Login Menu");
		loginPage=indexPage.clickLoginMenu();
		String actualTitle=driver.getTitle();
		String expectedTitle="Login";
		Assert.assertEquals(actualTitle, expectedTitle);
		Log.info("Login page displayed");
	}
	
}
