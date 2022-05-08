package tests;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Test;

import base.Base;
import pages.PracticePage;

public class PracticeTest extends Base {

	@Test
	public void handleRadioButtonTest() throws MalformedURLException {

		// launch Application
		PracticePage page = new PracticePage(driver);
		page.goTo();

		// Check for landing page
		Assert.assertEquals(driver.getTitle(), "Practice Page");

		// I click on Radio2
		page.clickOnRadioBtn("radio2");

		// i validate that "radio2" is clicked and selected
		page.verifySelectedRadioBtn("radio2");
		System.out.println("Test completed - Passed");

	}

}
