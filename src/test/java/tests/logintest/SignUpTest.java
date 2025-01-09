package tests.logintest;

import org.testng.annotations.Test;

import base.BaseTest;

public class SignUpTest extends BaseTest {

	@Test
	public void clickOPtion() throws InterruptedException {
		loginPage.switchWorkshop();
		loginPage.clickSignUpLink();
		signUpPage.clickInvoiceOption();
		Thread.sleep(3000);
		signUpPage.selectInvoiceOption("Autocare");
	}

}
