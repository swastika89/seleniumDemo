package wildcraft.web;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.readdata.ReadProperty;

import cucumber.api.java.en.Then;

public class accountPage {
	public static WebDriver driver;
	ReadProperty page = new ReadProperty();
	
	public accountPage() {
		driver = Hook.driver;
	}
	@Then ("^User should see my account screen$")
	public void verifyaccountPage() throws IOException{
		driver.findElement(By.xpath((page.readProperty("Hello_User"))));
		driver.findElement(By.xpath((page.readProperty("Dashboard_Text"))));
		driver.findElement(By.xpath((page.readProperty("Hey_User"))));

}
}
