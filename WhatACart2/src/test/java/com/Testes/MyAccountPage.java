package com.Testes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Com.Pages.HomePage;
import Com.Pages.IndexPage;
import Com.Pages.LoginPage;
import Com.jbk.base.BaseClass;
import Com.jbk.utilities.Log;
import Com.jbk.utilities.propertyUtils;

public class MyAccountPage extends BaseClass {
	IndexPage indexPage=null;
	LoginPage loginPage=null;
	HomePage homePage=null;
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup()throws Exception {
		initialization();
		homePage= new HomePage();
	}
	
	@Test(groups ="Smoke" )
	public void verifywishList() throws Throwable  {
		Log.startTestCase("verifywishList");
		indexPage  =new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(propertyUtils.prop.getProperty("Username"), propertyUtils.prop.getProperty("password"));
		boolean result=homePage.validiateWishList();
		Assert.assertTrue(result);
		Log.endTestCase("verifywishList");
	}
	
	@Test(groups ="Smoke" )
	public void verifyOrderHistroy() throws Throwable  {
		Log.startTestCase("verifyOrderHistroy");
		indexPage  =new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(propertyUtils.prop.getProperty("Username"), propertyUtils.prop.getProperty("password"));
		boolean result=homePage.validiateOrderHistory();
		Assert.assertTrue(result);
		Log.endTestCase("verifyOrderHistroy");
	}
	
	@Test(groups ="Smoke" )
	public void verifyEditProfileTest() throws Throwable  {
		Log.startTestCase("verifyEditProfileTest");
		indexPage  =new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(propertyUtils.prop.getProperty("Username"), propertyUtils.prop.getProperty("password"));
		boolean result=homePage.validiateEditProfile();
		Assert.assertTrue(result);
		Log.endTestCase("verifyEditProfileTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
