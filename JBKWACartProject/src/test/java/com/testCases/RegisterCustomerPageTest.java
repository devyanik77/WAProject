package com.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.base.TestBase;
import com.pages.IndexPage;
import com.pages.LoginPage;
import com.pages.RegisterCustomerPage;
import com.utilities.DataProviders;

public class RegisterCustomerPageTest extends TestBase{
	
	LoginPage loginPage;
	 IndexPage indexPage;
	RegisterCustomerPage registerCustomerPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws Exception {
		initialization(browser);			
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown (){
		driver.quit();		
	}
	
	@Test(groups = "Regression",dataProvider = "newcustomer", dataProviderClass = DataProviders.class, description="Register new customer")
	public void verifyRegisterNewCustomerTest(String uname, String timezone,String pwd, String cpwd, String fname, String lname,String email, String mbno ,String adr1, String adr2,String city, String state ,String country, String postalcode){
		Log.info("User is going to open the application link");
		indexPage=new IndexPage();
		Log.info("Clicking to 'Register New Customer' on IndexPage");
		registerCustomerPage=indexPage.clickRegisterMenu();
		boolean actualFlag=registerCustomerPage.registerNewCustomer(uname,timezone, pwd, cpwd, fname, lname, email, mbno, adr1, adr2, city, state, country, postalcode);
		Assert.assertTrue(actualFlag);
		Log.info("User is Registered successfully");
	}

}
