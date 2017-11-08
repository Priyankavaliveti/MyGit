package Step_Definition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class google_Definition
{
	WebDriver driver;
	@Given("^Open firefox and navigate to Google$")
	public void openBrowser()
	{
	 System.out.println("openBrowser method");
	 driver = new FirefoxDriver();
	 driver.navigate().to("https://www.google.co.in");
	 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	 driver.manage().window().maximize();
	}
	
	@When("^Entered \"(.*)\"$")   //search string
	public void enterString(String search) throws Throwable 
	{
	 System.out.println("enterString method");
	 //driver.findElement(By.xpath("//input[@name='q' and @type='text']")).sendKeys("Cucumber Framework");
	 driver.findElement(By.xpath("//input[@name='q' and @type='text']")).sendKeys(search);
	}
	
	@Then("^Search google$")
	public void searchGoogle()
	{
	 System.out.println("searchGoogle method");	
	 driver.findElement(By.xpath("//input[@name='q' and @type='text']")).sendKeys(Keys.ENTER);
	 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);	 
	}
	
	@And("^Print results count$")
	public void printResults()
	{
	 System.out.println("printResults method");
	 
	 String count = driver.findElement(By.xpath("//div[@id='resultStats']")).getText();
	 String text = driver.findElement(By.xpath("//div[@class='_ojo']/h3")).getText();
	 
	 System.out.println(text+" are "+count);
	 driver.close();
	}
}