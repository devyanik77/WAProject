package com.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;
import com.utilities.Action;

public class SearchResultPage extends TestBase{

	Action action=new Action();
	@FindBy(xpath="//*[@id='center_column']//img") private static WebElement productResult;
	public SearchResultPage() {
		PageFactory.initElements(driver, this);	
	}
	public boolean isProductAvailable(String itemName) {
		String searchedProductList="//div[@class='caption']//a[contains(text(), '%s')]";
		WebElement searchedProduct=driver.findElement(By.xpath(String.format(searchedProductList, itemName)));	
		return searchedProduct.isDisplayed();
	}
	
	
	
	public ProductDescPage clickOnProduct(String itemName) {
		String searchedProductList="//div[@class='caption']//a[contains(text(), '%s')]";
		WebElement selectedProduct=driver.findElement(By.xpath(String.format(searchedProductList, itemName)));
		selectedProduct.click();
		return new ProductDescPage();
	}

}
