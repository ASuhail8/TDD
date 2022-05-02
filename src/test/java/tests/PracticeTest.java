package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;



import base.Base;
import pages.PracticePage;

public class PracticeTest extends Base {

	public WebDriver driver;

	@Test
	public void handleRadioButtonTest() {

		// launch Application
		driver = Base.loginToApplication();

		// Check for landing page
		Assert.assertEquals(driver.getTitle(), "Practice Page");

		// I click on Radio2
		PracticePage practicePage = new PracticePage(driver);
		practicePage.clickOnRadioBtn("radio2");

		// i validate that "radio2" is clicked and selected
		practicePage.verifySelectedRadioBtn("radio2");

	}

}
