package reusableComponents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {
public static List<String> forDropdownValues(WebElement s)
{
	
	  Select sc = new Select(s);
	  List<WebElement> list = sc.getOptions();
	 List <String> text = new ArrayList();
	 for(WebElement ele : list)
	 {
		 
		 text.add(ele.getText());
		 
	 }
	return text;
}

public static void SelectValueFromDropdown(WebElement s, String value) throws Exception
{
	Select so = new Select(s);	
	try {

so.selectByVisibleText(value);
	}catch(Exception e)
	{
		
		throw new Exception("Value not present in dropdown");
	}
}

public static void selectRadioButton(List<WebElement> element, String Value)
{
for(WebElement e: element)
{
if(e.getText().equalsIgnoreCase(Value))
{
e.click();
break;
}
}

}

public static void selectCheckBoxValue(List<WebElement> element, String Value)
{
	String[] array=Value.split(",");
	for(String s:array) {
	for(WebElement e: element)
	{
	if(e.getText().equalsIgnoreCase(s))
	{
	e.click();
	break;
	}	

}
}
}
public static void clickButton(WebElement ele)
{
ele.click();	
}
}
