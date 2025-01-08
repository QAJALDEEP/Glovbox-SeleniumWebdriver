package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import pages.ForgotPasswordPage;
import pages.LoginPage;
import utils.PropertyUtils;
import utils.TestUtils;

public class BaseTest {

	private static ThreadLocal<WebDriver> threadLocalDriver;
	protected LoginPage loginPage;
	protected TestUtils testUtils;
	protected ForgotPasswordPage forgotPasswordPage;
	protected SoftAssert softAssert;
	protected Logger logger;

	public BaseTest() {
		logger = LogManager.getLogger(getClass());
		threadLocalDriver = new ThreadLocal<>();
		softAssert = new SoftAssert();
	}

	@BeforeSuite
	public void startUp() {
		String browserName = PropertyUtils.getWebConfigPropertyValue("browserName");
		if (browserName != null) {
			if (browserName.equalsIgnoreCase("chrome")) {
				setUpChromeBrowser();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				setUpFirefoxBrowser();
			} else {
				System.err.println("Provide a valid browser name!");
			}
		} else {
			System.err.println("Browser name must not be null!");
		}

		postBrowserLaunch();
		String baseUrl = PropertyUtils.getWebConfigPropertyValue("productionUrl");
		launchUrl(baseUrl);

		loginPage = new LoginPage(getDriver());
		testUtils = new TestUtils(getDriver());
	}

	@AfterSuite
	public void tearDown() {
		// getDriver().close();
		getDriver().quit();
		threadLocalDriver.remove();
	}

	private void setUpChromeBrowser() {
		threadLocalDriver.set(new ChromeDriver());
	}

	private void setUpFirefoxBrowser() {
		threadLocalDriver.set(new FirefoxDriver());
	}

	private void postBrowserLaunch() {
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
	}

	private void launchUrl(String url) {
		if (url != null) {
			getDriver().get(url);
		} else {
			System.err.println("URL not found!");
		}
	}

	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}

}
