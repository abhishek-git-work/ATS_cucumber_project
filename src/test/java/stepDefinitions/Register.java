package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import factory.driverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utils.TimeStamp;

public class Register extends driverFactory{
	
	@Given("user navigates to registration page")
	public void user_navigates_to_registration_page() {
	   
		driver.findElement(By.xpath("//a[normalize-space()='Login or register']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
	}

	@When("user enters below details into respective fields")
	public void user_enters_below_details_into_respective_fields(DataTable dataTable) {
	    
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(dataMap.get("firstname"));
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(dataMap.get("lastname"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_email']")).sendKeys(TimeStamp.emailWithTimeStamp());
		driver.findElement(By.xpath("//input[@id='AccountFrm_telephone']")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_fax']")).sendKeys(dataMap.get("fax"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_company']")).sendKeys(dataMap.get("company"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_address_1']")).sendKeys(dataMap.get("address1"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_address_2']")).sendKeys(dataMap.get("address2"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_city']")).sendKeys(dataMap.get("city"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_postcode']")).sendKeys(dataMap.get("zipcode"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_loginname']")).sendKeys(TimeStamp.loginNameWithTimeStamp());
		driver.findElement(By.xpath("//input[@id='AccountFrm_password']")).sendKeys(dataMap.get("password"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_confirm']")).sendKeys(dataMap.get("password"));
		
	}

	@When("user enters below details into respective fields with duplicate login name")
	public void user_enters_below_details_into_respective_fields_with_duplicate_login_name(DataTable dataTable) {
	    
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(dataMap.get("firstname"));
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(dataMap.get("lastname"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_email']")).sendKeys(TimeStamp.emailWithTimeStamp());
		driver.findElement(By.xpath("//input[@id='AccountFrm_telephone']")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_fax']")).sendKeys(dataMap.get("fax"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_company']")).sendKeys(dataMap.get("company"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_address_1']")).sendKeys(dataMap.get("address1"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_address_2']")).sendKeys(dataMap.get("address2"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_city']")).sendKeys(dataMap.get("city"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_postcode']")).sendKeys(dataMap.get("zipcode"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_loginname']")).sendKeys(dataMap.get("loginName"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_password']")).sendKeys(dataMap.get("password"));
		driver.findElement(By.xpath("//input[@id='AccountFrm_confirm']")).sendKeys(dataMap.get("password"));
		
	}
	
	@And("clicks on respective country")
	public void clicks_on_respective_country() {
	    
		WebElement x = driver.findElement(By.xpath("//select[@id='AccountFrm_country_id']"));
		Select s = new Select(x);
		s.selectByVisibleText("India");
	}

	@And("clicks on respective state")
	public void clicks_on_respective_state() {
	  
		WebElement y = driver.findElement(By.xpath("//select[@id='AccountFrm_zone_id']"));
		Select s = new Select(y);
		s.selectByVisibleText("Maharashtra");	
	}

	@And("clicks on yes for subscribe")
	public void clicks_on_yes_for_subscribe() {
	   
		driver.findElement(By.xpath("//input[@id='AccountFrm_newsletter1']")).click();
	}

	@And("agrees to privacy policy")
	public void agrees_to_privacy_policy() {
	 
		driver.findElement(By.xpath("//input[@id='AccountFrm_agree']")).click();
	}
	
	@And("clicks on continue button")
	public void clicks_on_continue_button() {
	 
		driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
	}

	@Then("new user account should be created")
	public void new_user_account_should_be_created() {
	  
		Assert.assertEquals("Congratulations! Your new account has been successfully created!",driver.findElement(By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')]")).getText());
	}

	@Then("proper warning message gets displayed")
	public void proper_warning_message_gets_displayed() {
	    
		Assert.assertEquals("×\n"+"This login name is not available. Try different login name!",driver.findElement(By.xpath("//div[@class='alert alert-error alert-danger']")).getText());

	}
	
}
