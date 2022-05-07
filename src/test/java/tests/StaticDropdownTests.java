package tests;

import java.net.MalformedURLException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;


import base.Base;
import pages.PracticePage;

/**
 * Scenario: Handling static dropdowns Given User is on Practice Landing Page
 * When User selects "Option2"
 * 
 * @author Mohammed.Suhail
 *
 */
public class StaticDropdownTests extends Base {

	public WebDriver driver;

	@Test
	public void staticDropdownTest() throws MalformedURLException {

		// Given User is on Practice
		driver = Base.loginToApplication();

		// When User selects "Option2"
		PracticePage page = new PracticePage(driver);
		page.selectDropdown("Option2");

	}

}
