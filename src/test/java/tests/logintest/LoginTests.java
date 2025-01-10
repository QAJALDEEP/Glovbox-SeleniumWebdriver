package tests.logintest;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.BaseTest;

@Listeners(listneres.TestListeners.class)
public class LoginTests extends BaseTest {

	SoftAssert softAssert;

	@BeforeMethod
	public void doBeforeMethod() {
		softAssert = new SoftAssert();
	}

	@Test
	public void test_LoginUsingValidLoginDetails() {
		myVehiclePage = loginPage.doLogin("zachary.rutledge@yopmail.com", "Techno@123");
		assertTrue(myVehiclePage.isPageHeadingLabelVisible(), "My Vehicle page not found.");
		softAssert.assertAll();
	}

}