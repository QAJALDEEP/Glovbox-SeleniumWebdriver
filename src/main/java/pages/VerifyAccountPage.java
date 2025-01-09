package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestUtils;

public class VerifyAccountPage {
	
	private WebDriver driver;
	private TestUtils testUtils;
	private By userEmail = By.xpath("(//p//span)[1]");
	
	public String getRegistredEmail() {
		return testUtils.waitForElement(userEmail).getText();
	}
	

}
