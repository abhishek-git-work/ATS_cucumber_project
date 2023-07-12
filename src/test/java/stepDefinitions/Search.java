package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.driverFactory;
import io.cucumber.java.en.*;

public class Search extends driverFactory{
	
	@Given("user opens the application")
	public void user_opens_the_application() {
//	    blank
	}

	@When("user enters valid product {string} into Seach box field")
	public void user_enters_valid_product_into_seach_box_field(String validProduct) {
		
		driver.findElement(By.xpath("//input[@id='filter_keyword']")).sendKeys(validProduct);    
	}

	@Then("user should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
	    
		Assert.assertEquals("Womens high heel point toe stiletto sandals ankle strap court shoes", driver.findElement(By.xpath("//span[@class='bgnone']")).getText());
	}

	@When("user enters invalid product {string} into Seach box field")
	public void user_enters_invalid_product_into_seach_box_field(String invalidProduct) {
	    
		driver.findElement(By.xpath("//input[@id='filter_keyword']")).sendKeys(invalidProduct);  
	}

	@Then("user should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
	    
		Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//div[contains(text(),'There is no product that matches the search criter')]")).getText());
	}

	@And("user clicks on Search button")
	public void user_clicks_on_search_button() {
	   
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
	}
	
}
