package utils;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

public class ConfigReader {
	 private static Properties properties;

	    public static Properties getProperties() {
	        if (properties == null) {
	            properties = new Properties();
	            try (FileInputStream fis = new FileInputStream(
	                    System.getProperty("user.dir") + "\\src\\test\\resources\\configfile\\Config.properties")) {
	                properties.load(fis);
	            } catch (IOException e) {
	                throw new RuntimeException("Failed to load Config.properties file", e);
	            }
	        }
	        return properties;
	    }

	    public static String getProperty(String key) {
	        return getProperties().getProperty(key);
	    }
}
