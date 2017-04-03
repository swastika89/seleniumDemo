package wildcraft.web;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.readdata.ReadProperty;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
	public static WebDriver driver;
	ReadProperty page = new ReadProperty();

	@Before
	public void openBrowser() throws IOException {
		String exePath = (page.readProperty("Chrome_Path"));
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@After
	public void captureScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			scenario.embed(((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.BYTES), "image/png");
		}
		driver.close();
		driver.quit();

	}
}


