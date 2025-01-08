package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

	/**
	 * Retrieves a property value from the default web configuration file.
	 *
	 * @param propertyKey the property key to look up
	 * @return the property value
	 * @throws IllegalArgumentException if the key is missing or invalid
	 */
	public static String getWebConfigPropertyValue(String propertyKey) {
		return getPropertyValue(Constants.WEBCONFIG_FILE_PATH.toString(), propertyKey);
	}

	/**
	 * Loads properties from a specified file.
	 *
	 * @param propertyFilePath the path to the properties file
	 * @return a Properties object loaded with the file's data
	 * @throws RuntimeException if the file cannot be loaded
	 */
	public static Properties loadProperty(String propertyFilePath) {
		Properties prop = new Properties();
		try (FileInputStream fi = new FileInputStream(propertyFilePath)) {
			prop.load(fi);
		} catch (IOException e) {
			throw new RuntimeException("Error loading property file: " + propertyFilePath, e);
		}
		return prop;
	}

	/**
	 * Retrieves a specific property value from the specified file.
	 *
	 * @param propertyFilePath the path to the properties file
	 * @param propertyKey      the key to retrieve
	 * @return the property value
	 * @throws IllegalArgumentException if the file path or key is null or invalid
	 */
	public static String getPropertyValue(String propertyFilePath, String propertyKey) {
		if (propertyFilePath == null || propertyKey == null) {
			throw new IllegalArgumentException("File path and property key must not be null!");
		}

		Properties prop = loadProperty(propertyFilePath);

		String propertyValue = prop.getProperty(propertyKey);
		if (propertyValue == null) {
			throw new IllegalArgumentException("Property key not found: " + propertyKey);
		}
		return propertyValue;
	}
}
