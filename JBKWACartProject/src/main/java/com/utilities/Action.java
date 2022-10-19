package com.utilities;

import java.util.List;
import java.time.Duration;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.TestBase;

public class Action extends TestBase{
	public WebDriverWait wait;
	public static long PAGE_LOAD_TIMEOUT=40;
	public static long IMPLICIT_WAIT=20;

	public void click(WebElement element){
		element.click();
	}

	public void type(WebElement element, String testData) {
		element.clear();
		element.sendKeys(testData);
	}

	public String getTitle(WebDriver driver) {
		String text = driver.getTitle();
		return text;
	}
    public String getText(WebElement element) {
        return element.getText();
    }
    
    public boolean selectBySendkeys(String value,WebElement ele) {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Select value from the DropDown");		
			} else {
				System.out.println("Not Selected value from the DropDown");
			}
		}
	}
    
	public void selectByValue(WebElement dropdown,String optionText) {
		Select select = new Select(dropdown);
		List<WebElement> options=select.getOptions();		
		for (WebElement option : options) {
			if(option.getText().equals(optionText)) {
				select.selectByValue(optionText);
				break;				
			}
		}
	}
	
	public void selectByVisibleText(WebElement dropdown,String optionText) {
			Select select = new Select(dropdown);
			List<WebElement> options=select.getOptions();		
			for (WebElement option : options) {
				System.out.println(option);
				if(option.getText().equals(optionText)) {
					select.selectByVisibleText(optionText);
					break;				
				}
			}	
	}
	public boolean selectByIndex(WebElement element, int index) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} 
	}

	public void click1(WebDriver driver, WebElement ele) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();

	}

	public boolean isDisplayed(WebDriver driver, WebElement element) {
		
		boolean flag = false;
		flag = findElement(driver, element);
		if (flag) {
			flag = element.isDisplayed();
			
		} else {
			System.out.println("Not displayed ");
		}
		return flag;
	}
	
	public boolean findElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			flag = false;
		} 
		return flag;
	}
	
	public void fluentWait(WebDriver driver,WebElement element, int timeOut) {
	    Wait<WebDriver> wait = null;
	    try {
	        wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(20))
	        	    .pollingEvery(Duration.ofSeconds(2))
	        	    .ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        element.click();
	    }catch(Exception e) {
	    }
	}
	
}
