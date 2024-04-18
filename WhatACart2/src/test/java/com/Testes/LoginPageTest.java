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
import Com.whatACart.dataProvider.DataProviders;

public class LoginPageTest extends BaseClass{

	IndexPage indexPage=null;
	LoginPage loginPage=null;
	HomePage homePage=null;
	
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup( )throws Exception {
		initialization();
		loginPage= new LoginPage();
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class,groups = {"Smoke","Sanity"})
	public void verifyLoginTest(String uname , String passwd) throws Throwable  {
		Log.startTestCase("verifyLoginTest");
		indexPage  =new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		Log.info("Enter sucsessfully valid credentials");
		//homePage=loginPage.login(propertyUtils.prop.getProperty("Username"), propertyUtils.prop.getProperty("password"));
		homePage=loginPage.login(uname,passwd);
		String actualUrl=homePage.getCurrURL(); 
		String expectedUrl ="https://ingecnotechnologies.com/other/Wcart/";
		Assert.assertEquals(actualUrl, expectedUrl);
		Log.info("Login sucsessfully with valid credentials");
		Log.endTestCase("verifyLoginTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
