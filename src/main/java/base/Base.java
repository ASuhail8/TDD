package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.junit.After;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class Base {

	public static WebDriver driver;

	public static WebDriver loginToApplication() throws MalformedURLException {
		MutableCapabilities mc = new MutableCapabilities();

		if (System.getProperty("BROWSER").equalsIgnoreCase("CHROME")) {
			mc = new ChromeOptions();
		} else {
			mc = new EdgeOptions();
		}

		driver = new RemoteWebDriver(new URL("http://localhost:4444"), mc);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
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
