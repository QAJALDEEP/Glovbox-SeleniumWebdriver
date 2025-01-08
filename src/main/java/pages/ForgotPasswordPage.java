package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestUtils;

public class ForgotPasswordPage {

	private final WebDriver driver;
	private final TestUtils testUtils;

	private By forgotPasswordDialog = By.cssSelector("[role='dialog']");
	private By closeButton = By.xpath("//button[.='Close']");
	private By emailInputField = By.cssSelector("input[id=':re:-form-item'][name='email']");
	private By resetPasswordbutton = By.xpath("//button[.='Reset Password']");
	private By emailValidationMessage = By.xpath("//p[contains(@id,'orm-item-message')]");

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		testUtils = new TestUtils(driver);
	}

	public boolean isDialogAppear() {
		return testUtils.waitForElement(forgotPasswordDialog).isDisplayed();
	}

	public ForgotPasswordPage fillEmail(String value) {
		testUtils.fillInput(emailInputField, value);
		return this;
	}

	public ForgotPasswordPage clickResetPasswordButton() {
		testUtils.clickOn(resetPasswordbutton);
		return this;
	}

	public boolean isEmailValidationMessageDisplayed() {
		return testUtils.waitForElement(emailValidationMessage).isDisplayed();
	}

	public String getEmailValidationMessageText() {
		return testUtils.waitForElement(emailValidationMessage).getText();
	}

	public LoginPage doResetPassword(String value) {
		fillEmail(value).clickResetPasswordButton();
		return new LoginPage(driver);
	}

	public ForgotPasswordPage clickCloseButton() {
		testUtils.clickOn(closeButton);
		return this;
	}

}