package Com.Pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.jbk.base.BaseClass;
import Com.whatACart.Action.Action;


public class HomePage extends BaseClass {
	
	Action action = new Action();

	@FindBy(xpath = "/html/body/nav/div/div[2]/ul/li[1]/a/span")
	WebElement myaccount;
	
	@FindBy(xpath="//*[@id=\"accountsidebarlist\"]/li[2]/a")
	WebElement editProfile;
	
	@FindBy(xpath="//*[@id=\"accountsidebarlist\"]/li[3]/a")
	WebElement changePasswd;
	
	@FindBy(xpath="//*[@id=\"accountsidebarlist\"]/li[4]/a")
	WebElement myOrder;
	
	@FindBy(xpath="//*[@id=\"accountsidebarlist\"]/li[5]/a")
	WebElement wishList;
	
	@FindBy(xpath="//*[@id=\"accountsidebarlist\"]/li[6]/a")
	WebElement mydownLoad;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validiateWishList() {
		return Action.isDisplayed(driver, wishList);
	}
	
	public boolean validiateOrderHistory() {
		return Action.isDisplayed(driver, myOrder);
	}
	
	public boolean validiateEditProfile() {
		return Action.isDisplayed(driver, editProfile);
	}
	
	public String getCurrURL() throws Throwable {
		String homePageURL=driver.getCurrentUrl();
		return homePageURL;
	}
}
