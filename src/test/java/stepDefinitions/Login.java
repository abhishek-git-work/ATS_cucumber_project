package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.java.en.*;


public class Login extends driverFactory{

	
	@Given("user navigates to login page")
	public void user_navigates_to_login_page() {
	    
		driver.findElement(By.linkText("Login or register")).click();
	}

	@When("user enters valid login name {} into login name field")
	public void user_enters_valid_login_name_into_login_name_field(String validLoginNameText) {
	   
		driver.findElement(By.xpath("//input[@name='loginname']")).sendKeys(validLoginNameText);
	}

	@And("user enters valid password {} into password field")
	public void user_enters_valid_password_into_password_field(String validPasswordText) {
	   
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(validPasswordText);
	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
	   
		driver.findElement(By.xpath("//button[@title='Login']")).click();
	}

	@Then("user gets login successfully")
	public void user_gets_login_successfully() {
	   
		String loginsuccessText = driver.findElement(By.xpath("//body//div//div//div//div//div//h1//span[contains(text(),'My Account')]")).getText();
		Assert.assertEquals("MY ACCOUNT", loginsuccessText);
	}

	@When("user enters invalid login name {string} into login name field")
	public void user_enters_invalid_login_name_into_login_name_field(String invalidLoginNameText) {
	  
		driver.findElement(By.xpath("//input[@name='loginname']")).sendKeys(invalidLoginNameText);
	}

	@And("user enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {
	    
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(invalidPasswordText);
	}

	@Then("user should get proper warning message")
	public void user_should_get_proper_warning_message() {
	    
		String loginFailedText = driver.findElement(By.xpath("//body/div/div[2]/div[1]/div[1]/div[1]/div[1]")).getText();
		Assert.assertEquals("×\n"+"Error: Incorrect login or password provided.", loginFailedText);
	}
	
}
