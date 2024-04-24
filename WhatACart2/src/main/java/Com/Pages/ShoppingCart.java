package Com.Pages;

import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Com.jbk.base.BaseClass;
import Com.whatACart.Action.Action;

public class ShoppingCart extends BaseClass{
	
	Action action = new Action();
	
	
	@FindBy(xpath="//*[@id=\"shopping-cart-full\"]/table/tbody/tr/td[6]")
	WebElement unitPrice;
	
	@FindBy(xpath="//*[@id=\"shopping-container\"]/div[2]/div/table/tbody/tr[3]/td[2]")
	WebElement totalPrice;
	
	@FindBy(xpath="//*[@id=\"shopping-container\"]/div[3]/div[2]/a")
	WebElement CheckOut;
	
	@FindBy(xpath="//*[@id=\"shopping-container\"]/div[3]/div[1]/a")
	WebElement  ContinueShopping;
	
	public ShoppingCart() {
		PageFactory.initElements(driver, this);
	}
	
	public double getUnitPrice() {
		Action.fluentWait(driver, CheckOut, 20);
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		String totalPrice1=totalPrice.getText();
		String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice=Double.parseDouble(tot);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut() throws Throwable {
		Action.click(driver, CheckOut);
		return new LoginPage();
	}
}
