package Com.Pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.jbk.base.BaseClass;
import Com.whatACart.Action.Action;


public class OrderconfirmationPage extends BaseClass {

	Action action = new Action();
	
	@FindBy (id="save")
	WebElement confirmOrderBtn;
	
	@FindBy(id="cancel-button")
	WebElement  BackBtn;
	
	@FindBy(id ="edit-button")
	WebElement EditcardBtn;
	
	public OrderconfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShoppingCart editorder() {
		Action.click(getDriver(), EditcardBtn);
		return new ShoppingCart();
	}
	public CheackOutPage cancelOrder() {
		Action.click(getDriver(), BackBtn);
		return new CheackOutPage();
	}
	public CompliteOrderPage orderconformation() {
		Action.click(getDriver(), confirmOrderBtn);
		return new CompliteOrderPage();
	}
}
