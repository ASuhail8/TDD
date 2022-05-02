package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;


import base.Base;
import pages.PracticePage;

/**
 * Scenario Outline: Handling Dynamic dropdowns Given User is on Practice
 * Landing Page When User enters <country> in the select countries text box Then
 * User should be able to select <country>
 * 
 * @author Mohammed.Suhail
 *
 */
public class DynamicDropdownTests extends Base {

	public WebDriver driver;

	@Test
	public void dynamicdropdownTest() {

		// Given User is on Practice Landing Page
		driver = Base.loginToApplication();

		// When User enters <country> in the select countries text box
		PracticePage page = new PracticePage(driver);
		page.enterCountryName("India");

		// Then User should be able to select <country>
		page.selectCountry("India");

	}

}
