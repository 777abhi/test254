package com.utilityComponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractReusableComponents {
	
	WebDriver driver;
	
	public AbstractReusableComponents(WebDriver driver) {
		
		this.driver= driver; 
		
	}

	public void waitForElementVisible(WebElement element) {
		 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		
	}

}
