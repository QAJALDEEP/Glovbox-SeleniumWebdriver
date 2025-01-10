package utils;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {

	private static WebDriver driver; // Keep static if required
	private WebDriverWait wait;

	public TestUtils(WebDriver driverInstance) {
	    driver = driverInstance; 
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
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");

		return dateTimeFormatter.format(dateTime);
	}

	public void selectValueFromHiddenDropdown(By locator, String value) throws InterruptedException {
		List<WebElement> options = driver.findElements(locator);
		for (WebElement option : options) {
			String optionValue = option.getText();
			if (optionValue.equalsIgnoreCase(value)) {
				driver.findElement(By.xpath("//div[.='" + optionValue + "']")).click();
				break; // Exit the loop once the "Xero" option is selected
			}
		}

	}
	
	public static String captureFullPageScreenshot() {
		File ts = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String imgFile = Paths.get(Constants.ROOT_PATH,"screenshots",getCurrentDateAndTime()+".png").toString();
		File srcFile = new File(imgFile);
		ts.renameTo(srcFile);
		return imgFile;
	}

}
