package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import base.Base;

public class PracticePage {

	public WebDriver driver;

	@FindBy(css = "#autocomplete")
	private WebElement countryTxtField;

	@FindBy(css = ".ui-menu-item div")
	List<WebElement> countries;

	@FindBy(id = "dropdown-class-example")
	private WebElement dropdownId;

	public PracticePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnRadioBtn(String radioBtnName) {
		driver.findElement(By.xpath("//input[@value='" + radioBtnName + "']")).click();
	}

	public void verifySelectedRadioBtn(String radioBtnName) {
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='" + radioBtnName + "']")).isSelected());
	}

	public void enterCountryName(String countryName) {
		countryTxtField.sendKeys(countryName);
	}

	public void selectCountry(String countryName) {
		for (int i = 0; i < countries.size(); i++) {
			if (countries.get(i).getText().equals(countryName)) {
				countries.get(i).click();
				break;
			}
		}
	}

	public void selectDropdown(String dropdown) {
		Select dropdwn = Base.selectDropdown(dropdownId);
		dropdwn.selectByVisibleText(dropdown);
	}

}
