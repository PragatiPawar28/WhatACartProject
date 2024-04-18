package Com.Pages;

import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.jbk.base.BaseClass;
import Com.whatACart.Action.Action;


public class SearchResultPage extends BaseClass {

	Action action = new Action();
	
	@FindBy (xpath ="//*[@id=\"search-results-list-view\"]/div[1]/div")
	WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable()  {
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct() {
		Action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
}
