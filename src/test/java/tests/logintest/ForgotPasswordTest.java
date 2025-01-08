package tests.logintest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class ForgotPasswordTest extends BaseTest {

	@BeforeTest
	public void doBeforeTest() {
		loginPage = new LoginPage(getDriver());
		logger.info("Clicking on the forgot password link...");
		forgotPasswordPage = loginPage.clickForgotPasswordLink();
		logger.info("ForgotPassword link clicked....");
	}

	@Test(priority = 1)
	public void test_ForgotPasswordDialogDisplayed() {
		softAssert.assertTrue(forgotPasswordPage.isDialogAppear());
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void test_emailValidationErrorDisplayed() {
		forgotPasswordPage.clickResetPasswordButton();
		softAssert.assertTrue(forgotPasswordPage.isEmailValidationMessageDisplayed());
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void test_DialogNotDisplayed() {
		forgotPasswordPage.clickCloseButton();
		softAssert.assertFalse(forgotPasswordPage.isDialogAppear());
	}

}
