package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
	public static Properties prop=null;
	public static FileInputStream fis=null;
	public static String configPath = System.getProperty("user.dir")+ "/src/main/resources/config.properties";
	public static File file=new File(configPath);
	
	public static String readProperties(String key){
		prop=new Properties();
		try {
			fis=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

}
