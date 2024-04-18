package Com.Pages;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.whatACart.Action.Action;
import Com.jbk.base.BaseClass;

public class IndexPage extends BaseClass {


	Action action= new Action();
	
	@FindBy(xpath = "/html/body/nav/div/div[2]/ul/li[1]/a/span")
	WebElement myaccount;
	
	@FindBy(xpath = "/html/body/nav/div/div[2]/ul/li[1]/ul/li[2]/a")
	WebElement signInBtn;
	
	@FindBy(id="logo")
	WebElement whatACartLogo;
	
	@FindBy(id="navbarsearchform-keyword")
	WebElement searchProductBox;
	
	@FindBy(xpath="//*[@id=\"search\"]/span/button")
	WebElement serchButton;
	
	 public IndexPage () {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() {
		Action.click(getDriver(), myaccount);
		Action.click(getDriver(), signInBtn);
		
		return new LoginPage();
	}
	
	public boolean validateLogo() {
	return	Action.isDisplayed(getDriver(), whatACartLogo);
	}
	
	
	public String getwhatCartTitle() {
		String whatACartTitle = getDriver().getTitle();
	return whatACartTitle;
	}
	
		
	public SearchResultPage searchProduct(String productName) {
		Action.type(searchProductBox, productName);
		Action.click(getDriver(), serchButton);
		
		return new SearchResultPage();
	}
	
	}
	
	

