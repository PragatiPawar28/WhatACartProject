package Com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import Com.jbk.base.BaseClass;
import Com.whatACart.Action.Action;
import Com.Pages.LoginPage;


public class AccountCreationPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath ="/html/body/div[2]/ul/li[3]")
      WebElement formTitle;
	
	@FindBy(id="customer-username")
	 WebElement username;
	
	@FindBy(id="select2-chosen-1")
	 WebElement Timezone;
	
	@FindBy(id="customer-password")
	 WebElement password;
	
	@FindBy(id="customer-confirmpassword")
	 WebElement Conf_password;
	
	@FindBy(xpath="//*[@id=\"customerprofileeditview\"]/div[1]/ul/li[2]/a")
	 WebElement Person;
	
	@FindBy(id="person-firstname")
     WebElement firstname;
	
	@FindBy(id ="person-lastname")
     WebElement Lastname;
	
	@FindBy(id ="person-mobilephone")
     WebElement mobile;
	
	@FindBy(id ="person-email")
    WebElement email;
	
	@FindBy(id ="person-profile_image")
    WebElement profileImg;
	
	@FindBy(xpath ="//*[@id=\"customerprofileeditview\"]/div[1]/ul/li[3]/a")
    WebElement adress;
	
	@FindBy(id ="address-address1")
    WebElement address1;
	
	@FindBy(id ="address-address2")
    WebElement address2;
	
	@FindBy(id ="address-city")
    WebElement city;
	
	@FindBy(id ="address-state")
    WebElement state;
	
	@FindBy(xpath ="//*[@id=\"tabaddress\"]/div[5]/div")
    WebElement country;
	
	@FindBy(id ="id=\"address-postal_code\"")
    WebElement postal_Code;
	
	@FindBy(id="save")
	WebElement Continuebtn;
	
	public void createAccount1(String userName,String TimeZone,String passWord,String ConfirmPaswd ) 
	{
	Action.type(username,userName);
	Action.selectByVisibleText(TimeZone, Timezone);
	Action.type(password, passWord);
	Action.type(Conf_password, ConfirmPaswd);
		}
	
	public void createAccount2(String fName,String LName,String Email,String Mobile) 
	{
	Action.type(firstname, fName);
	Action.type(Lastname, LName);
	Action.type(email, Email);
	Action.type(mobile, Mobile);
		}
	
	public void createAccount3(String add1,String add2,String City,String State, String Country,String Postal_Code) 
	{
	Action.type(address1, add1);
	Action.type(address2, add2);
	Action.type(city, City);
	Action.type(state, State);
	Action.selectByVisibleText(Country, country);
	Action.type(postal_Code, Postal_Code);
		}
	
	public void clickOnPerson() {
	 Action.click(getDriver(), Person);

	}
	public void clickOnAddress() {
		Action.click(getDriver(), adress);
	
	}
	 
	public LoginPage validRegistration() {
		Action.click(getDriver(), Continuebtn);
		return new LoginPage();
	}
		
	public boolean validateAcountCreatePage() throws Throwable {
		 return Action.isDisplayed(getDriver(), formTitle);
	}
}
