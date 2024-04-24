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
	
	@FindBy (xpath="//*[@id=\"cart\"]/div/a/span[2]")
	WebElement addTocartdropdown;
	
	@FindBy (xpath="//*[@id=\"cart\"]/div/ul/li[3]/div/p/a[2]")
	WebElement viewCartCheckOutbutton;
	
	
	public CheackOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void  viewCartCheckout () {
		Action.click(driver, addTocartdropdown);
		Action.fluentWait(driver, viewCartCheckOutbutton, 10);

		Action.click(driver, viewCartCheckOutbutton);
	}
	public  void shippingMethod() {
		Action.isSelected(driver, FreeShipping);
	}
	public void PaymentMethod() {
		Action.fluentWait(driver, CashOnDilivery, 30);
		Action.isSelected(driver, CashOnDilivery);
		
		//Action.isSelected(driver, PaypalStandred );
		
		Action.click(driver, TearmsAndCond);

	}
	public OrderconfirmationPage continue_page() {
		Action.click(driver, Continue1);
		return new OrderconfirmationPage();
				}
	
}
