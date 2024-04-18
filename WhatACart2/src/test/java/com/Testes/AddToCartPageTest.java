package com.Testes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Com.Pages.AddToCartPage;
import Com.Pages.IndexPage;
import Com.Pages.SearchResultPage;
import Com.jbk.base.BaseClass;
import Com.jbk.utilities.Log;

public class AddToCartPageTest extends BaseClass {
	IndexPage indexPage=null;
	SearchResultPage searchResultPage=null;
	AddToCartPage addToCartPage =null;
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup()throws Exception {
		initialization();
		
		addToCartPage= new AddToCartPage();
	}
	
	@Test(groups ={"Regression","Sanity"} )
	public void verifyAddToCartProd() throws Throwable {
		Log.startTestCase("verifyAddToCartProd");
		indexPage =new IndexPage();
		searchResultPage = indexPage.searchProduct("mobile");
	    addToCartPage    = searchResultPage.clickOnProduct();
	    addToCartPage.enterQuantity("2");
	    addToCartPage.clickOnAddToCart();
	   boolean result  = addToCartPage.validiateAddToCart();
	    Assert.assertTrue(result);
	    Log.endTestCase("verifyAddToCartProd");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
