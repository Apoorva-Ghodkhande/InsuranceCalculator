package pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import reusableComponents.CommonMethods;
import testBase.TestBase;

public class EnterVehicleDataPageObjects extends TestBase {

	@FindBy(xpath = "//select[@id='make']")
	WebElement dd_Make;

	@FindBy(xpath = "//select[@id='model']")
	WebElement dd_Model;

	@FindBy(xpath = "//input[@id='cylindercapacity']")
	WebElement tb_CylinderCapacity;
	
	@FindBy(xpath="//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
	WebElement error_CylinderCapacity;

	@FindBy(xpath = "//input[@id='engineperformance']")
	WebElement tb_Engine_Performance;

	@FindBy(xpath = "//input[@id='dateofmanufacture']")
	WebElement table_tb_Date_of_Manufacture;

	@FindBy(xpath = "//select[@id='numberofseatsmotorcycle']")
	WebElement dd_NumberOfSeats;

	@FindBy(xpath = "//input[@id='listprice']")
	WebElement tb_ListPrice;
	
	@FindBy(xpath = "//input[@id='annualmileage']")
	WebElement tb_AnnualMileage;	

	@FindBy(xpath = "//button[@id='nextenterinsurantdata']")
	WebElement button_text;

	public EnterVehicleDataPageObjects() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);

	}

  public void enterDataToCylinderCapacityTextBox(String CapacityValue)
  {
	  tb_CylinderCapacity.sendKeys(CapacityValue);
	  
  }
  
  public String getTextCylCapacityError()
  {
	  String error = error_CylinderCapacity.getText();
	  return error;
	  
  }
  
  public List<String> verifyDDValues_Model()
  {
	 List<String> list= CommonMethods.forDropdownValues(dd_Model);
     return list;
  }
  
  public void enterVehicleData(HashMap<String, String> hm) throws Exception
  {
	  CommonMethods.SelectValueFromDropdown(dd_Make,hm.get("Vehicle_Make"));
	  CommonMethods.SelectValueFromDropdown(dd_Model,hm.get("Vehicle_Model"));
	  tb_CylinderCapacity.sendKeys(hm.get("Vehicle_CylinderCapacity"));
	  tb_Engine_Performance.sendKeys(hm.get("Vehicle_Engine Performance"));
	  table_tb_Date_of_Manufacture.sendKeys("10/11/2021");
	  CommonMethods.SelectValueFromDropdown(dd_NumberOfSeats, hm.get("Vehicle_No of Seats_motorcycle"));
	  tb_ListPrice.sendKeys(hm.get("Vehicle_ListPrice"));
	  tb_AnnualMileage.sendKeys(hm.get("Vehicle_Annual Mileage"));
	  button_text.click();
	  
  }
  
}
