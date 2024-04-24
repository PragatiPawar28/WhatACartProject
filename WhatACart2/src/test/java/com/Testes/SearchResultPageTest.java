package com.Testes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.Pages.IndexPage;
import Com.Pages.SearchResultPage;
import Com.jbk.base.BaseClass;
import Com.jbk.utilities.Log;

public class SearchResultPageTest extends BaseClass {
	IndexPage indexPage=null;
	SearchResultPage searchResultPage=null;
	
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup( )throws Exception {
		initialization();
		searchResultPage= new SearchResultPage();
	}
	
	@Test(groups ="Smoke" )

	public void verifyAvaliblityProduct() {
		Log.startTestCase("verifyAvaliblityProduct");
		indexPage =new IndexPage();
		searchResultPage =	indexPage.searchProduct("mobile");
		boolean result =searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		Log.info("Product is available");
		Log.endTestCase("verifyAvaliblityProduct");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	
}
