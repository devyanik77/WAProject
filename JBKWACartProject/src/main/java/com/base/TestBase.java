package com.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.utilities.PropertiesUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver=null;
	public static Logger Log = Logger.getLogger(TestBase.class.getName());

	public static ExtentSparkReporter spark;
	public static ExtentReports extent=null;
	public static ExtentTest test=null;
	static PropertiesUtil propUtil;

	public static WebDriver initialization(String browserName){   
		Log.info("Initializing the browser");
		//	String browserName =PropertiesUtil.readProperties("browser");

		if(browserName.equals("Chrome")) {
			//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");	
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			launchApplication();
			return driver;
		}
		else if(browserName.equals("Firefox")) {
			//System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");    
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			launchApplication();
			return driver;
		}
		else if(browserName.equals("IE")){
			//System.setProperty("webdriver.ie.driver", "./Drivers/getIEPath()");           
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			launchApplication();
			return driver;
		}
		return driver;
	}

	private static void launchApplication() {
		Log.info("Launching the Application");
		driver.get(PropertiesUtil.readProperties("baseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);			

	}

	@BeforeSuite
	public void reportSetup() {
		extent = new ExtentReports ();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";	
		spark=new ExtentSparkReporter(System.getProperty("user.dir")+ "/Reports/"+repName);//specify location of the report			
		extent.attachReporter(spark);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","Devyani");

	}

	@AfterSuite
	public void endReport(){
		extent.flush();
	}
}
