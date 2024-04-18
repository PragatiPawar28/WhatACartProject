package Com.Pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.jbk.base.BaseClass;
import Com.whatACart.Action.Action;

public class CompliteOrderPage extends BaseClass {

	Action action = new Action();
	
	@FindBy(xpath="/html/body/div[2]/ul/li[2]")
	WebElement CompletOrder;
	

	@FindBy(xpath="//*[@id=\"content\"]/div/div/div/div/p[1]/a\r\n")
	WebElement MyOrder;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div/div/div/p[2]/a")
	WebElement sendEmail;
	
	@FindBy(xpath="//a[@class='btn btn-success']")
	WebElement ContinueBtn;
	
	
	
	public CompliteOrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String ValidateConfirmMsg() {
		String  ConfirmMasg= CompletOrder.getText();
		return ConfirmMasg;
	}
	
	public MyOrder clickOnMyOedr() {
		Action.click(getDriver(), MyOrder);
		
		return new MyOrder();
	}
	
	public HomePage continueToHomePage() {
		Action.click(getDriver(), ContinueBtn);
		
		return new HomePage();
	}
	
	
}
