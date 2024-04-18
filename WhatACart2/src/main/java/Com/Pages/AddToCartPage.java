package Com.Pages;

import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.jbk.base.BaseClass;
import Com.whatACart.Action.Action;



public class AddToCartPage extends BaseClass {

	Action action = new Action();
	@FindBy(xpath="//*[@id=\"search-results-list-view\"]/div[1]/div/div/div/div[1]/a/img") 
	WebElement product;
	
	@FindBy (id="quantity")
	WebElement quantity;
	
	@FindBy(id="button-cart")
	WebElement addToCartBtn;
	
	@FindBy (xpath="//*[@id=\"cart\"]/div/a/span[2]")
	WebElement addTocartdropdown;
	
	@FindBy (xpath="//*[@id=\"w1\"]/li[1]/a")
	WebElement Description;
	
	@FindBy(xpath ="//*[@id=\"cart\"]/div/ul/li[3]/div/p/a[1]")
	WebElement viewCart;
	
	public AddToCartPage () {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String quantity1)  {
		Action.click(getDriver(), product);
		Action.type(quantity, quantity1);
	}
	
	public void clickOnAddToCart()  {
		Action.click(getDriver(), addToCartBtn);
	}
	public boolean validiateAddToCart() {
		return Action.isDisplayed(getDriver(), Description);
	}
	
	
	public ShoppingCart clickOnVieCart() throws Exception {
		Action.fluentWait(getDriver(), viewCart, 30);
		Action.click(getDriver(), addTocartdropdown);
		Action.click(getDriver(), viewCart);
		return new ShoppingCart();
	}
}
