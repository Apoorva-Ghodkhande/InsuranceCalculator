package InsuranceCalculation_Motorcycle;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import testBase.TestBase;

public class ErrorTests_motorcycle extends TestBase {
	@Test
	public void checkErrorMessageOfCylinderCapacity()
	{
	
		homepage.motorCycleLinkClick();
		evdata.enterDataToCylinderCapacityTextBox("3333");
		String actualMessage= evdata.getTextCylCapacityError();
		String expectedMessage="Must be a number between 1 and 2000";
		assertEquals(actualMessage, expectedMessage,"Both are not matching");
		test.log(Status.PASS, "Correct Error Message");
	}
	@Test
	public void checkErrorMessageOfCylinderCapacity1()
	{
	
		homepage.motorCycleLinkClick();
		evdata.enterDataToCylinderCapacityTextBox("3333");
		String actualMessage= evdata.getTextCylCapacityError();
		String expectedMessage="Must be a number between 1 and 3000";
		assertEquals(actualMessage, expectedMessage,"Both are not matching");
		test.log(Status.FAIL, "Correct Error Message");
	}
}
