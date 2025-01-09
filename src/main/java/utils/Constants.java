package utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Constants {

	// Timeout for implicit waits in seconds
	public static final int IMPLICIT_WAIT = 10;

	// Root directory of the project
	public static final String ROOT_PATH = System.getProperty("user.dir");

	// Path to the web configuration properties file
	public static final Path WEBCONFIG_FILE_PATH = Paths.get(ROOT_PATH, "src", "test", "resources",
			"webconfig.properties");
	
	public static final Path HTMLREPORT_FILE_PATH = Paths.get(ROOT_PATH, "htmlreports");
}