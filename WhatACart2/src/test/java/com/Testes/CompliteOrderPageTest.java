package com.Testes;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Com.Pages.AddToCartPage;
import Com.Pages.CheackOutPage;
import Com.Pages.CompliteOrderPage;
import Com.Pages.IndexPage;
import Com.Pages.LoginPage;
import Com.Pages.OrderconfirmationPage;
import Com.Pages.SearchResultPage;
import Com.Pages.ShoppingCart;
import Com.jbk.base.BaseClass;
import Com.jbk.utilities.Log;
import Com.jbk.utilities.propertyUtils;
import Com.whatACart.dataProvider.DataProviders;

public class CompliteOrderPageTest extends BaseClass {
	 IndexPage index;
	 SearchResultPage searchResultPage;
	 AddToCartPage addToCartPage;
	 ShoppingCart  shoppingCart;
	 LoginPage loginPage;
	 CheackOutPage cheackOutPage;
	 OrderconfirmationPage orderConfirmationPage;
	 CompliteOrderPage compliteOrderPage=null;
	 
	
	 @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	 public void setup()throws Exception {
		initialization();
		compliteOrderPage= new CompliteOrderPage();
	 	}
	
	
	
	
	 @Test(dataProvider = "credentials", dataProviderClass = DataProviders.class,groups ="Regression" )
	 public void endToEndTest(String uname, String passwd) throws Throwable {
		Log.startTestCase("endToEndTest");
		index= new IndexPage();
		searchResultPage=index.searchProduct("mobile");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("2");
		addToCartPage.clickOnAddToCart();
		shoppingCart=addToCartPage.clickOnVieCart();
		loginPage=shoppingCart.clickOnCheckOut();
		//cheackOutPage=loginPage.login1(propertyUtils.prop.getProperty("Username"), propertyUtils.prop.getProperty("password"));
		cheackOutPage=loginPage.login1(uname,passwd);
		cheackOutPage.viewCartCheckout();
		cheackOutPage.PaymentMethod();
		orderConfirmationPage=cheackOutPage.continue_page();
		compliteOrderPage =orderConfirmationPage.orderconformation();
	
		String actualMessage=compliteOrderPage.ValidateConfirmMsg();
		String expectedMsg="Complete Order";
		Assert.assertEquals(actualMessage, expectedMsg);
		Log.info("order is sucsessfully placed");
		Log.endTestCase("endToEndTest");
	}
	 
	 @AfterMethod(groups = {"Smoke","Sanity","Regression"})
		public void tearDown() {
			driver.quit();
		}

}

