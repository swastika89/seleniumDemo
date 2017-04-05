package wildcraft.web;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ForgetPassword {
	public static WebDriver driver;
	
	public ForgetPassword() {
		driver = Hook.driver;
	}
	
	@And ("^User clicks on forgot password link$")
	public void clickForgetPassword(){
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='password-reset']/a")).click();
	}
	
	@Then ("^forgot password screen opens$")
	public void verifyForgetPasswordPage(){
		driver.findElement(By.xpath("//div[@class='login-from']/h2"));
		driver.findElement(By.xpath("//div[@class='username']/input"));
	}
	
	@When ("^User enter email and send forgot password request$")
	public void initiateForgetPassword() throws IOException{
		driver.findElement(By.xpath("//div[@class='username']/input")).clear();
		driver.findElement(By.xpath("//div[@class='username']/input")).sendKeys("swastika.barpanda@sftpl.com");
		driver.findElement(By.xpath("//div[@class='auth-btn']/button")).click();
	}
	
	@Then ("^Login screen with valid messsages displays$")
	public void ForgetPasswordmessageverify() throws IOException{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String msg = driver.findElement(By.xpath("//li[@class='success-msg']/ul/li")).getText();
		Assert.assertEquals(msg, "If there is an account associated with swastika.barpanda@sftpl.com you will receive an email with a link to reset your password.");
		
	}
}
