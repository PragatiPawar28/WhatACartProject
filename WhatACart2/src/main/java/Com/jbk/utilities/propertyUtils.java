package Com.jbk.utilities;

import java.io.FileInputStream;

import java.util.Properties;

public class propertyUtils {
 public static Properties prop=null;

	public static String readproperty(String key) throws Exception {
		// TODO Auto-generated method stub
		
	 prop =new Properties();
		FileInputStream fis = new
				FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Config.properties");
		prop.load(fis)	;	
		return prop.getProperty(key);
	}

}
