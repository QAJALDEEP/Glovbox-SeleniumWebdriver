package tests.logintest;

import org.testng.annotations.Test;

import utils.Constants;

public class PrintPath {
	
	@Test
	public void printPath() {
		System.out.println(Constants.HTMLREPORT_FILE_PATH);
	}

}
