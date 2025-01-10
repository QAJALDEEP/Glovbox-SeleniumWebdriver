package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestUtils;

public class MyVehiclePage {

	private WebDriver driver;
	private TestUtils testUtils;

	private static final String PAGE_HEADING_LABEL = "My Vehicles";

	private By pageHeadingLabel = By.xpath("//span[.='My Vehicles']");
	private By myVehicleButton = By.cssSelector("button[id='radix-:r6c:-trigger-my-vehicle']");
	private By myFamilyButton = By.cssSelector("button[id='radix-:r6c:-trigger-my-family']");
	private By myHistoryButton = By.cssSelector("button[id='radix-:r6c:-trigger-my-history']");
	private By searchInput = By.cssSelector("input[placeholder='Search...']");
	private By addVehicleButton = By.xpath("//button[.='Add Vehicle']");

	public MyVehiclePage(WebDriver driver) {
		this.driver = driver;
		testUtils = new TestUtils(driver);
	}

	public boolean isPageHeadingLabelVisible() {
		return testUtils.waitForElement(pageHeadingLabel).isDisplayed();
	}

	public MyVehiclePage clickMyVehicleTab() {
		testUtils.clickOn(myVehicleButton);
		return this;
	}

	public MyVehiclePage clickMyFamilyTab() {
		testUtils.clickOn(myFamilyButton);
		return this;
	}

	public MyVehiclePage clickMyHistoryTab() {
		testUtils.clickOn(myHistoryButton);
		return this;
	}

	public MyVehiclePage fillSearchInputField(String value) {
		testUtils.fillInput(searchInput, value);
		return this;
	}
	
	//TODO Create Add Vechile Page in Pages
	public void clickAddVehicleButton() {
		testUtils.clickOn(addVehicleButton);
	}

}
