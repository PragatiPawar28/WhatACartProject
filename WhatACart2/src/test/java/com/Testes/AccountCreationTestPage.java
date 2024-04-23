package com.Testes;

import java.util.HashMap;
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
import Com.whatACart.dataProvider.DataProviders;

public class AccountCreationTestPage extends BaseClass {
	 IndexPage indexPage;
	 LoginPage loginPage;
	 
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
	
	//@Test(groups = "Regression",dataProvider = "newAcountDetailsData",dataProviderClass = DataProviders.class)
	public void createAccountTest(HashMap<String,String> hashMapValue) throws Throwable {
		Log.startTestCase("createAccountTest");
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		acountCreationPage=loginPage.createNewAccount();
		acountCreationPage.createAccount1(
				hashMapValue.get("UserName"),
				hashMapValue.get("TimeZone"),
				hashMapValue.get("PassWord"),
				hashMapValue.get("ConfirmPassWord"));
		acountCreationPage.clickOnPerson();
		acountCreationPage.createAccount2(
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("Email"),
				hashMapValue.get("MobilePhone"));
		acountCreationPage.clickOnAddress();
		acountCreationPage.createAccount3(
				hashMapValue.get("Address1"),
				hashMapValue.get("Address2"),
				hashMapValue.get("City"),
				hashMapValue.get("State"),
				hashMapValue.get("Country"),
				hashMapValue.get("Postal_Code"));
//		loginPage=acountCreationPage.validRegistration();
//		Assert.assertEquals("acountCreationPage", loginPage.getCurrURL() );
//		Log.endTestCase("createAccountTest");

	}
		@AfterMethod(groups = {"Smoke","Sanity","Regression"})
		public void tearDown() {
			//getDriver().quit();
		}
}
