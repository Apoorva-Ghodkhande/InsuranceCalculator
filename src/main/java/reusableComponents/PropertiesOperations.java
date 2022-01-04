package reusableComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class PropertiesOperations {

	static Properties prop= new Properties();
	
	public static String getPropertiesValue(String key) throws Exception
	{
		String PropFilePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";

		FileInputStream file =new FileInputStream(PropFilePath);
		prop.load(file);
		
		String value = prop.get(key).toString();
		if(StringUtils.isEmpty(value)) {
			
			throw new Exception("Value is not specified for Key "+ key);
			
		}
		
		return value;
	}
}

