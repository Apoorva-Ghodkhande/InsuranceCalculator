package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testBase.TestBase;

public class SelectPriceOptionPageObject extends TestBase{
	@FindBy(xpath = "//button[@id='nextsendquote']")
	WebElement nextButton;
	
public SelectPriceOptionPageObject() 
{
PageFactory.initElements(driver, this);
}
	
	public WebElement xpathToSelectPriceFromTable(String plan)
	{
		String xpathPlan="//table[@id='priceTable']//tr[1]//td[@data-label='"+plan+"']/span";
		
		return driver.findElement(By.xpath(xpathPlan));
	}
	
	public void xpathToSelectOptionFromTable(String plan)
	{
		
		String xpathPlan="//input[@value='"+plan+"']/parent::label[@class='choosePrice ideal-radiocheck-label']";
		
		driver.findElement(By.xpath(xpathPlan)).click();
	}	
	
	public void clickNextButton()
	{
		nextButton.click();
		
	}
	
	public String selectPrice(HashMap<String, String> hm)
	{
		 return xpathToSelectPriceFromTable(hm.get("SelectOption")).getText();
		
	}
}
