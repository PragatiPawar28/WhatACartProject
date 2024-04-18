package com.Testes;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Com.Pages.AccountCreationPage;
import Com.Pages.HomePage;
import Com.Pages.IndexPage;
import Com.Pages.LoginPage;
import Com.jbk.base.BaseClass;
import Com.jbk.utilities.Log;

public class AccountCreationTestPage extends BaseClass {
	 IndexPage indexPage;
	 LoginPage loginPage;
	 HomePage homePage;
	 AccountCreationPage acountCreationPage;


	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	 public void setup()throws Exception {
			initialization();
			acountCreationPage= new AccountCreationPage();
		}
	
	
	
	@Test(groups ="Sanity" )

	public void verifyCreateAccountPageTest() throws Throwable {
		Log.startTestCase("verifyCreateAccountPageTest");		
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		acountCreationPage=loginPage.createNewAccount();
		Log.info("sucsessfilly retive to Register Account Page");

		//boolean result=acountCreationPage.validateAcountCreatePage();
		//Assert.assertTrue(result);
		Log.endTestCase("verifyCreateAccountPageTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
