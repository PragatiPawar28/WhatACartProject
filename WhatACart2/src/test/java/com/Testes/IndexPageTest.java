package com.Testes;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import Com.Pages.IndexPage;
import Com.jbk.base.BaseClass;


public class IndexPageTest extends BaseClass {
	
	IndexPage indexPage=null;

	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup( )throws Exception {
		initialization();
		indexPage= new IndexPage();
	}
	
	@Test(groups ="Smoke" )
	public void verifyLogo() throws Throwable {
		
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
		
	}
	
	@Test(groups ="Smoke" )
	public void verifyTitle() {
	   String actTitle=indexPage.getwhatCartTitle();
		Assert.assertEquals(actTitle, "Home");
		
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
