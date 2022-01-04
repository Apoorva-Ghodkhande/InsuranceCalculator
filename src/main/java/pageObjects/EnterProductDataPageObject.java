package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.CommonMethods;
import testBase.TestBase;

public class EnterProductDataPageObject extends TestBase {

	@FindBy(xpath="//input[@id='startdate']")
	WebElement table_StartDate;
	
	@FindBy(xpath="//select[@id='insurancesum']")
	WebElement dd_InsuranceSum;
	
	@FindBy(xpath="//select[@id='damageinsurance']")
	WebElement dd_DamageInsurance;
	
	@FindBy(xpath = "//button[@id='preventerinsurancedata']")
	WebElement button_Prev;
	
	@FindBy(xpath = "//button[@id='nextselectpriceoption']")
	WebElement button_Next;
	
	@FindBy(xpath="//input[@name=\"Optional Products[]\"]/parent::label")
	List<WebElement> checkbox_OptionalProd;
	
	public EnterProductDataPageObject() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public void enterProductData(HashMap<String, String> hm) throws Exception
	{
		table_StartDate.sendKeys("05/20/2022");
		CommonMethods.SelectValueFromDropdown(dd_InsuranceSum, hm.get("Product_insurancesum"));
		CommonMethods.SelectValueFromDropdown(dd_DamageInsurance, hm.get("Product_damageinsurance"));
		CommonMethods.selectCheckBoxValue(checkbox_OptionalProd, hm.get("ProductOptional_Products"));
		CommonMethods.clickButton(button_Next);
	}
}
