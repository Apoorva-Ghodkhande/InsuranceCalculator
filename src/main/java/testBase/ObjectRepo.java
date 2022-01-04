package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.EnterInsurantDataPageObject;
import pageObjects.EnterProductDataPageObject;
import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceOptionPageObject;

public class ObjectRepo {

	public HomePageObjects homepage;
	public EnterVehicleDataPageObjects evdata;
	public EnterProductDataPageObject epdata;
	public EnterInsurantDataPageObject eidata;
	public SelectPriceOptionPageObject sp;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;
	//public WebDriverWait wait;
}
