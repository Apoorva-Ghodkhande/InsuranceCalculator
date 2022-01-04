package reusableComponents;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import testBase.ObjectRepo;

public class ExtentSetup extends ObjectRepo {

	
	public static ExtentReports setupExtentReport()
	{
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss" );
		Date date =new Date();
		String actualDate = format.format(date);
		extent = new ExtentReports();
		String FilePath = System.getProperty("user.dir")+"/target/ExecutionReport"+actualDate+".html";
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(FilePath);
		extent.attachReporter(sparkReport);
		return extent;
		
	}
}
