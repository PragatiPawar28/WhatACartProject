package com.Testes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Com.Pages.AddToCartPage;
import Com.Pages.IndexPage;
import Com.Pages.SearchResultPage;
import Com.Pages.ShoppingCart;
import Com.jbk.base.BaseClass;
import Com.jbk.utilities.Log;
import Com.whatACart.dataProvider.DataProviders;

public class ShoppingCartTest extends BaseClass {
	IndexPage indexPage=null;
	SearchResultPage searchResultPage=null;
	AddToCartPage addToCartPage= null;
	ShoppingCart shoppingCart =null;
	
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup()throws Exception {
		initialization();
		shoppingCart= new ShoppingCart();
	}
	
	@Test(groups = "Regression",dataProvider = "getProduct",dataProviderClass = DataProviders.class)
		public void verifyProductPrice(String ProductName, String qty) throws Exception {
		Log.startTestCase("verifyProductPrice");
		indexPage =new IndexPage();
		searchResultPage = indexPage.searchProduct(ProductName);
	    addToCartPage    = searchResultPage.clickOnProduct();
	    addToCartPage.enterQuantity(qty);
	    addToCartPage.clickOnAddToCart();
	    Log.info("product is successfully added to cart ");
	    shoppingCart=  addToCartPage.clickOnVieCart();
	    Double unitPrice= shoppingCart.getUnitPrice();
	    Double totalPrice= shoppingCart.getTotalPrice();
	    Double expectedTotalPrice =(unitPrice*(Double.parseDouble(qty)));
	    Assert.assertEquals(totalPrice, expectedTotalPrice);
	    Log.endTestCase("verifyProductPrice");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
