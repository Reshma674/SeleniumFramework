package Generic_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Property_Utility
{
	public String getKeyValue(String Key) throws Throwable 
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties.txt");
        Properties pro=new Properties();
        pro.load(fis);
        String Value = pro.getProperty(Key);
		return Value;
		
	}

}
