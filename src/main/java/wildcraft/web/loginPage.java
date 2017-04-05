package wildcraft.web;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.readdata.ReadProperty;
import com.readdata.userList;

import wildcraft.model.User;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class loginPage{
	public static WebDriver driver;
	ReadProperty page = new ReadProperty();

	public loginPage() {
		driver = Hook.driver;
	}

	
	@When ("^User clicks on the login link$")
	public void clickonLogin() throws IOException
	{
		driver.findElement(By.xpath((page.readProperty("Login_Link")))).click();
	}
	
	@Then ("^User should see login screen$")
	public void verifyloginPage() throws IOException
	{
		driver.findElement(By.xpath((page.readProperty("Login_Title"))));
		driver.findElement(By.xpath((page.readProperty("Login_Button"))));
	}
	
	@When ("^User perform login with valid credentials$")
	public void validLogin() throws IOException{
		User user=userList.getUser();
		performLogin(user.getUsername(), user.getPassword());
		
	}
	
	@When ("^User perform login with invalid username$")
	public void invalidUsername() throws IOException{
		performLogin("swastika", "Abc@123");
		
	}
	
	@When ("^User perform login with invalid password$")
	public void invalidPassword() throws IOException{
		performLogin("swastika.barpanda@sftpl.com", "abcdef");
	}
	
	@When ("^User perform login with blank username and password$")
	public void blankidLogin() throws IOException{
		performLogin(" ", " ");	
	}
	
	public void performLogin(String username, String password) throws IOException{
		
		driver.findElement(By.xpath((page.readProperty("Username_Field")))).clear();
		driver.findElement(By.xpath((page.readProperty("Username_Field")))).sendKeys(username);
		driver.findElement(By.xpath((page.readProperty("Password_Field")))).clear();
		driver.findElement(By.xpath((page.readProperty("Password_Field")))).sendKeys(password);
		driver.findElement(By.xpath((page.readProperty("Login_Button")))).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then ("^error message for invalid username should display$")
	public void verifyinvalidUsername() throws InterruptedException
	{
		try {
		    WebDriverWait wait = new WebDriverWait(driver, 2);
		    wait.until(ExpectedConditions.alertIsPresent());
		    Alert alert = driver.switchTo().alert();
		    alert.accept();
		    //Assert.assertTrue(alert.getText().contains("email address"));
		    Assert.assertEquals(alert.getText(), "Please include an '@' in the email address. 'swastika' is missing an '@'.");
		} catch (Exception e) {
		    //exception handling
		}
	}
	
	@Then ("^error message for invalid password should display$")
	public void verifyinvalidPassword() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String ermsg = driver.findElement(By.xpath((page.readProperty("InvalidPassword_Popup")))).getText();
		Assert.assertEquals(ermsg, "Invalid login or password.");
	}
	
	@Then ("^error message for blank username and password should display$")
	public void verifyblankCredentials() throws IOException
	{
		String msg1 = driver.findElement(By.xpath((page.readProperty("BlankUsername_Error")))).getText();
		Assert.assertEquals(msg1, "This is a required field.");
		String msg2 = driver.findElement(By.xpath((page.readProperty("BlankPassword_Error")))).getText();
		Assert.assertEquals(msg2, "This is a required field.");
	}
}
