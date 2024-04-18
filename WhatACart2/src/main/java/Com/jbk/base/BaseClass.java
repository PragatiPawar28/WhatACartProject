package Com.jbk.base;

import java.util.concurrent.TimeUnit;


import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import Com.jbk.utilities.ExtentManager;
import Com.jbk.utilities.propertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	//public static WebDriver driver =null;
	
	// Declare ThreadLocal Driver
		public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

		
		@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
		public void beforeSuite() throws Throwable {
			DOMConfigurator.configure("log4j.xml");
			ExtentManager.setExtent();

		}
		public static WebDriver getDriver() {
			// Get Driver from threadLocalmap
					return driver.get();
				}
		
	@Parameters("browser")
	public void initialization () throws Exception {
		System.out.println("Reaging property file for browser");//console
		String browserName = propertyUtils.readproperty("browser");

		if(browserName.equalsIgnoreCase("Chrome")) 
		{
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			//driver= new ChromeDriver();
			// Set Browser to ThreadLocalMap
						driver.set(new ChromeDriver());
		}
		if (browserName.equalsIgnoreCase("Firefox")) 
		{
			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			//driver= new FirefoxDriver();
			driver.set(new FirefoxDriver());

		}
		
		//driver.manage().window().maximize()
		//Maximize the screen
				getDriver().manage().window().maximize();
		
				getDriver().get(propertyUtils.readproperty("url"));
		
					}
	
		@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
		public void afterSuite() {
		ExtentManager.endReport();
		}
	 
}
