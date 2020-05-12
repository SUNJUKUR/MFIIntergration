package com.mfi.qa.testUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public static Properties prop;

/*	public ReadConfig() {
		try {
			prop = new Properties();
			FileInputStream fi = new FileInputStream(
					"/C:/Users/rahul/Downloads/MyAutomation/myWorkSpace/MicroFocusIntegration/Configurations/config.properties");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
*/
	public static String getValue(String filepath, String key) {

		try {
			prop = new Properties();
			FileInputStream fil = new FileInputStream(filepath);
			prop.load(fil);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String Val = prop.getProperty(key);
		return Val;
	}
}
