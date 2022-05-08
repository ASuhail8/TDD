package tests;

import java.net.MalformedURLException;

import org.junit.Test;

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

	@Test
	public void staticDropdownTest() throws MalformedURLException {

		// Given User is on Practice
		PracticePage page = new PracticePage(driver);
		page.goTo();

		// When User selects "Option2"
		page.selectDropdown("Option2");
		System.out.println("Test completed - Passed");
	}

}
