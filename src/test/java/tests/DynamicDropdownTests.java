package tests;

import java.net.MalformedURLException;

import org.junit.Test;

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

	@Test
	public void dynamicdropdownTest() throws MalformedURLException {

		// Given User is on Practice Landing Page
		PracticePage page = new PracticePage(driver);
		page.goTo();
		System.out.println("On landing page");

		// When User enters <country> in the select countries text box

		page.enterCountryName("India");

		// Then User should be able to select <country>
		page.selectCountry("India");
		System.out.println("Test completed - Passed");

	}

}
