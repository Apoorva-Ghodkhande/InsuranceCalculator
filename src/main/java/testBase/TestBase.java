package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EnterInsurantDataPageObject;
import pageObjects.EnterProductDataPageObject;
import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceOptionPageObject;
import reusableComponents.PropertiesOperations;

public class TestBase extends ObjectRepo {
	
	
	
	public void LaunchBrowserAndNavigate() throws Exception
	{
		String browser= PropertiesOperations.getPropertiesValue("browser");
		String url= PropertiesOperations.getPropertiesValue("url");
		//String browser= "chrome";
		if(browser.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
		WebDriverManager.iedriver().setup();
		driver= new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
		}	
	}
	@BeforeMethod
	public void startup() throws Exception
	{
		LaunchBrowserAndNavigate();
		homepage = new HomePageObjects();
		evdata = new EnterVehicleDataPageObjects();
		epdata = new EnterProductDataPageObject();
		eidata = new EnterInsurantDataPageObject();
		sp= new SelectPriceOptionPageObject();
		 //wait = new WebDriverWait(driver,30);
		
	}
	@AfterMethod
	public void afterTest() throws Exception
	{
		driver.quit();
		
	}

}
