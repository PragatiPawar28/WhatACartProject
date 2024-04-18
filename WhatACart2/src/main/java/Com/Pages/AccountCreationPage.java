package Com.Pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import Com.jbk.base.BaseClass;
import Com.whatACart.Action.Action;



public class AccountCreationPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath ="/html/body/div[2]/ul/li[3]")
     WebElement formTitle;
	
	
	public boolean validateAcountCreatePage() throws Throwable {
		 return Action.isDisplayed(getDriver(), formTitle);
	}
}
