package InsuranceCalculation_Motorcycle;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.TestBase;

public class VerifyAllDropDownElementsEVData extends TestBase {
	@Test
	public void verifyEVModelDropDown()
	{
		homepage.motorCycleLinkClick();
		List<String> actualValues=evdata.verifyDDValues_Model();
		List<String> expectedValues= Arrays.asList("– please select –","Scooter","Three-Wheeler","Moped","Motorcycle");
		
		Assert.assertEquals(actualValues, expectedValues,"All values are matching");
	}
}
