package Com.Pages;

import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.jbk.base.BaseClass;
import Com.whatACart.Action.Action;


public class LoginPage extends BaseClass {

	Action action =new Action();
	
	@FindBy(id="loginform-username")
	WebElement username;
	
	@FindBy(id="loginform-password")
	WebElement password;
	
	@FindBy(id="loginform-rememberme")
	WebElement rememberMecheackBox;
	
	@FindBy(id="savebutton")
	WebElement signInBtn;
	
		
	@FindBy(xpath="//*[@id=\"content\"]/div/div/div/div/div[1]/div/a")
	WebElement createNewAccountBtn;
	
	public LoginPage () {
		PageFactory.initElements(getDriver(), this);
		
	}

	public HomePage login (String uname ,String passwd) {
		Action.type(username, uname);
		Action.type(password, passwd);
		Action.click(getDriver(), rememberMecheackBox);
		Action.click(getDriver(), signInBtn);
		
		return new HomePage();
	}
	
	public CheackOutPage login1 (String uname ,String passwd) {
		Action.type(username, uname);
		Action.type(password, passwd);
		Action.click(getDriver(), rememberMecheackBox);
		Action.click(getDriver(), signInBtn);
		
		return new CheackOutPage();
	}
	
	public AccountCreationPage createNewAccount() throws Throwable {
		
		Action.click(getDriver(), createNewAccountBtn);
		return new AccountCreationPage();
	}
	
}
