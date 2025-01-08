package utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {

	WebDriver driver;
	private WebDriverWait wait;

	public TestUtils(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.IMPLICIT_WAIT));
	}

	public WebElement waitForElementToBeClickable(By elementLocator) {
		if (elementLocator != null) {
			return wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
		} else {
			System.err.println("Element locator cannot be null");
			return null;
		}
	}

	public WebElement waitForElement(By elementLocaor) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(elementLocaor));
	}

	public void clickOn(By elementLocator) {
		try {
			waitForElement(elementLocator);
			waitForElementToBeClickable(elementLocator).click();
		} catch (Exception e) {
			System.err.println("Error clicking on element: " + e.getMessage());
		}
	}

	public void fillInput(By elementLocator, String value) {
		try {
			waitForElement(elementLocator).clear();
			waitForElement(elementLocator).sendKeys(value);
		} catch (Exception e) {
			System.err.println("Error filling input field: " + e.getMessage());
		}
	}

	public static String getCurrentDateAndTime() {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return dateTimeFormatter.format(dateTime);
	}
}
