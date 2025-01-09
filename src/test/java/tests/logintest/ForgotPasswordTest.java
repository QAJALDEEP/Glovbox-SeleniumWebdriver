package tests.logintest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseTest;
import listneres.TestListeners;
import pages.LoginPage;

@Listeners(listneres.TestListeners.class)
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
		test = TestListeners.getTest();
		test.log(Status.INFO, "TestCase1");
		softAssert.assertTrue(forgotPasswordPage.isDialogAppear());
		softAssert.assertAll();
	}

	@Test(priority = 2)
	public void test_emailValidationErrorDisplayed() {
		test = TestListeners.getTest();
		test.log(Status.INFO, "TestCase2");
		forgotPasswordPage.clickResetPasswordButton();
		softAssert.assertTrue(forgotPasswordPage.isEmailValidationMessageDisplayed());
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void test_DialogNotDisplayed() {
		test = TestListeners.getTest();
		test.log(Status.INFO, "TestCase3");
		forgotPasswordPage.clickCloseButton();
		softAssert.assertFalse(forgotPasswordPage.isDialogAppear());
	}

}
