package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusableComponents.CommonMethods;
import testBase.TestBase;

public class EnterInsurantDataPageObject extends TestBase {

	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement tb_FirstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement tb_LastName;
	
	@FindBy(xpath="//input[@id='birthdate']")
	WebElement table_DateOfBirth;
	
	@FindBy(xpath="//input[@name=\"Gender\"]/parent::label")
	List<WebElement> rdo_Gender;
	
	@FindBy(xpath="//input[@id='streetaddress']")
	WebElement tb_StreetAddress;
	
	@FindBy(xpath="//select[@id='country']")
	WebElement dd_Country;
	
	@FindBy(xpath="//input[@id='zipcode']")
	WebElement tb_ZipCode;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement tb_City;
	
	@FindBy(xpath="//input[@name=\"Hobbies\"]/parent::label")
	List<WebElement> checkbox_Hobbies;
	
	@FindBy(xpath="//select[@id='occupation']")
	WebElement dd_Occupation;
	
	@FindBy(xpath="//input[@id='website']")
	WebElement tb_Website;
	
	@FindBy(xpath="//button[@id='open']")
	WebElement button_Open;
	
	@FindBy(xpath="//button[@id='preventervehicledata']")
	WebElement button_Prev;
	
	@FindBy(xpath="//button[@id='nextenterproductdata']")
	WebElement button_Next;
	
	public EnterInsurantDataPageObject() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);;
	}
	
	public void enterInsurantData(HashMap<String, String> hm) throws Exception
	{
		tb_FirstName.sendKeys(hm.get("Insurant_FirstName"));
		tb_LastName.sendKeys(hm.get("Insurant_LastName"));
		table_DateOfBirth.sendKeys("10/03/1969");
		CommonMethods.selectRadioButton(rdo_Gender, hm.get("Insurant_gender"));
		tb_StreetAddress.sendKeys("Mumbai");
		CommonMethods.SelectValueFromDropdown(dd_Country, hm.get("Insurant_country"));
		tb_ZipCode.sendKeys(hm.get("Insurant_zipcode"));
		tb_City.sendKeys("Mumbai");
		CommonMethods.SelectValueFromDropdown(dd_Occupation, hm.get("Insurant_occupation"));
		CommonMethods.selectCheckBoxValue(checkbox_Hobbies, hm.get("Insurant_Hobby"));
		tb_Website.sendKeys("http://sampleapp.tricentis.com/101/app.php");
		button_Open.sendKeys("Libraries/Pictures/cat.png");
		CommonMethods.clickButton(button_Next);
		
	}
	
	
}
