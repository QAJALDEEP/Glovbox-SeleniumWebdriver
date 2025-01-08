package tests.logintest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

public class LoginTests extends BaseTest {
	
	SoftAssert softAssert;

    @BeforeMethod
    public void doBeforeMethod() {
        softAssert = new SoftAssert();
    }

    @Test
    public void test_EmailAndPasswordValidation() {
        loginPage.clickLoginButton();
        softAssert.assertTrue(loginPage.isEmailValidation(), "Email validation message is not displayed!");
        softAssert.assertTrue(loginPage.isPasswordValidation(), "Password validation message is not displayed!");
    }

    @Test
    public void test_EmailValidationMessageText() {
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getEmailValidationMessage();
        softAssert.assertEquals(actualMessage, "Please enter your email", "Email validation message is incorrect!");
    }

    @AfterMethod
    public void doAfterMethod() {
        softAssert.assertAll();
    }
}