package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.SignUpPage;
import utils.PropertyUtils;
import utils.TestUtils;

public class BaseTest {

    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    protected TestUtils testUtils;
    protected SoftAssert softAssert;
    protected Logger logger;
    protected ExtentTest test;
    
    protected LoginPage loginPage;
    protected ForgotPasswordPage forgotPasswordPage;
    protected SignUpPage signUpPage;
    
    

    public BaseTest() {
        logger = LogManager.getLogger(getClass());
        softAssert = new SoftAssert();
    }

    @BeforeSuite
    public void startUp() {
        logger.info("Starting test suite...");
        
        String browserName = PropertyUtils.getWebConfigPropertyValue("browserName");
        if (browserName != null) {
            logger.info("Detected browser: " + browserName);
            switch (browserName.toLowerCase()) {
            case "chrome":
                setUpChromeBrowser();
                logger.info("Chrome browser setup completed.");
                break;
            case "firefox":
                setUpFirefoxBrowser();
                logger.info("Firefox browser setup completed.");
                break;
            default:
                logger.error("Invalid browser name provided: " + browserName);
                return;
            }
        } else {
            logger.error("Browser name must not be null!");
            return;
        }

        postBrowserLaunch();
        String baseUrl = PropertyUtils.getWebConfigPropertyValue("productionUrl");
        if (baseUrl != null) {
            logger.info("Launching URL: " + baseUrl);
            launchUrl(baseUrl);
        } else {
            logger.error("Base URL not found in configuration!");
        }

        loginPage = new LoginPage(getDriver());
        testUtils = new TestUtils(getDriver());
        signUpPage = new SignUpPage(getDriver());
        logger.info("Test suite initialized successfully.");
    }

	/*
	 * @AfterSuite public void tearDown() {
	 * logger.info("Tearing down the test suite..."); if (getDriver() != null) {
	 * logger.info("Closing browser..."); getDriver().quit();
	 * threadLocalDriver.remove(); logger.info("Browser closed successfully."); }
	 * else { logger.warn("No driver found to close."); } }
	 */

    private void setUpChromeBrowser() {
        threadLocalDriver.set(new ChromeDriver());
        logger.info("Chrome browser initialized.");
    }

    private void setUpFirefoxBrowser() {
        threadLocalDriver.set(new FirefoxDriver());
        logger.info("Firefox browser initialized.");
    }

    private void postBrowserLaunch() {
        WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        logger.info("Browser window maximized and cookies deleted.");
    }

    private void launchUrl(String url) {
        if (url != null) {
            getDriver().get(url);
            logger.info("URL launched: " + url);
        } else {
            logger.error("URL is null. Cannot launch.");
        }
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }
}
