package com.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilityComponents.AbstractReusableComponents;

public class HomePage extends AbstractReusableComponents{
	
	WebDriver driver;
	
	public HomePage (WebDriver driver)
	{
		super(driver);
		//initialize
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "#twotabsearchtextbox")
	WebElement searchBar;
	
	@FindBy(css = "#nav-search-submit-button")
	WebElement searchIcon;
	
	@FindBy(xpath = "//div[@data-component-type='s-search-result']")
	List <WebElement> allProducts;
	
	@FindBy(xpath = "//div[@data-component-type='s-search-result']/div[1]/div")
	WebElement firstsearchedResult;
	
	@FindBy(xpath = "//span[@id='productTitle']")
	WebElement firstsearchedResultText;
	
	public void clickAndInputSearchBar(String productName) {
		
		searchBar.click();
		searchBar.sendKeys(productName);
	}
	
	public void clickOnSearchIcon() {
		
		searchIcon.click();
		waitForElementVisible(firstsearchedResult);
		
	}
	
	public String getDesiredProductFromList(String requiredProduct) {
		
		String name = "";
		
        List<WebElement> products = allProducts;

        System.out.println(products.size());

        for (WebElement webElement : products) {
            name = webElement.getText();
            
            if (name == requiredProduct) {
            	
            	break;           	
            }
        }
		return name;		
	}
	
	public void clickOnFirstSearchResult() {
		
		firstsearchedResult.click();
	}
	
	public String getSearchedResultText() {
		
		return firstsearchedResultText.getText();
	}
}

