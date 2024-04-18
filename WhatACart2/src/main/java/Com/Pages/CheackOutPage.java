package Com.Pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.jbk.base.BaseClass;
import Com.whatACart.Action.Action;


public class CheackOutPage extends BaseClass {

	Action action = new Action();
	
	@FindBy(xpath="//*[@id=\"deliveryoptionseditform-shipping\"]/div/label/input")
	WebElement FreeShipping;
	
	@FindBy(xpath="//*[@id=\"paymentmethodeditform-payment_method\"]/div[1]/label/input")
	WebElement CashOnDilivery;
	
	@FindBy(xpath="//*[@id=\"paymentmethodeditform-payment_method\"]/div[2]/label/input")
	WebElement PaypalStandred;
	
	@FindBy(id="paymentmethodeditform-agree")
	WebElement TearmsAndCond;
	
	@FindBy(id="save")
	WebElement Continue1;
	
	public CheackOutPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public  void shippingMethod() {
		Action.isSelected(getDriver(), FreeShipping);
	}
	public void PaymentMethod() {
		Action.isSelected(getDriver(), CashOnDilivery);
		
		//Action.isSelected(getDriver(), PaypalStandred );
		
		Action.click(getDriver(), TearmsAndCond);

	}
	public OrderconfirmationPage continue_page() {
		Action.click(getDriver(), Continue1);
		return new OrderconfirmationPage();
				}
	
}
