package wildcraft.web;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.readdata.ReadProperty;

import cucumber.api.java.en.Then;

public class homePage {
	public static WebDriver driver; 
	ReadProperty page = new ReadProperty();
	
	 public homePage() {
	driver = Hook.driver;
	}
	 
	@Then ("^User should see the home screen$")
	public void verifyHomePage() throws IOException{
		driver.findElement(By.xpath((page.readProperty("Search_Field"))));
		driver.findElement(By.xpath((page.readProperty("Cart_Icon"))));
		driver.findElement(By.xpath((page.readProperty("Wildcraft_Logo"))));
		
}
}
