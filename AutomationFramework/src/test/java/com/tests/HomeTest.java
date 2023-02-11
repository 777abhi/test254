package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testComponent.BaseTest;

public class HomeTest extends BaseTest {
	

	@Test
	public void VerifySearchedProductFromList()	
	 {
		homePage.clickAndInputSearchBar("iphone");
		homePage.clickOnSearchIcon();
		
		String product = homePage.getDesiredProductFromList("Apple iphone");
		System.out.println(product);
		Assert.assertTrue(product.contains("iPhone"));

	 }

}
