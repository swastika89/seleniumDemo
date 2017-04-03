package wildcraft.web;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import com.readdata.ReadProperty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class browser {
	public static WebDriver driver;
    ReadProperty page = new ReadProperty();

	public browser() {
		driver = Hook.driver;
	}

	@Given("^User open browser$")
	public void openBrowser() {
	}

	@When("^User open the application url$")
	public void openApp() throws IOException {

		driver.get(page.readProperty("Base_Url"));
	}
}