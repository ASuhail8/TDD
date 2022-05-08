package base;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class Base {

	public WebDriver driver;

	@Before
	public void loginToApplication() throws MalformedURLException {

		MutableCapabilities mc = new MutableCapabilities();

		if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("edge")) {
			mc = new EdgeOptions();
		} else if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
			mc = new FirefoxOptions();
		} else {
			mc = new ChromeOptions();
		}
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), mc);

		// WebDriverManager.chromedriver().setup();
		// driver = new ChromeDriver();
	}

	public static Select selectDropdown(WebElement element) {
		Select select = new Select(element);
		return select;
	}

	@After
	public void quitBrowser() {
		driver.quit();
	}

}
