package InsuranceCalculation_Motorcycle;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import reusableComponents.ExcelOperations;
import testBase.TestBase;

public class EndToEndTests_Motorcycle extends TestBase {
	ExcelOperations excel = new ExcelOperations("InsurancePremium");
@Test(dataProvider="testdata")
	public void testCase_0001(Object obj1) throws Exception
	{

	HashMap<String, String> ha = (HashMap<String, String>) obj1;
		homepage.motorCycleLinkClick();
		evdata.enterVehicleData(ha);
		eidata.enterInsurantData(ha);
		epdata.enterProductData(ha);
		
		String actualValue=sp.selectPrice(ha);
		String expectedValue=ha.get("PriceValidation_Silver");
		Assert.assertEquals(actualValue, expectedValue);
		sp.xpathToSelectOptionFromTable(ha.get("SelectOption"));
		sp.clickNextButton();
		
	}
@DataProvider(name="testdata")
public Object[][] getDataFromExcel() throws EncryptedDocumentException, IOException
{
	Object[][] obj= new Object[excel.getRowCount()][1];
	for(int i=1;i<excel.getRowCount();i++)
	{
	HashMap<String,String>	h= excel.getDataFromExcel(i);
		obj[i-1][0]=h;
	}
	return obj;
}
	
}
