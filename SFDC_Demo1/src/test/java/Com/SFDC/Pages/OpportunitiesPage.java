package Com.SFDC.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import Common.Utility;


public class OpportunitiesPage extends Utility
{
	public static String opportunities = "(.//a/span[text()='Opportunities'])[1]";
	static String newbtn = ".//a/div[text()='New']";
	static String container = ".//*[@class='modal-container slds-modal__container']";
	static String heading = ".//*[contains(@id,'title_') and contains(@class,'slds-text-heading--medium')]";
	static String oppname = "(.//label/span[text()='Opportunity Name']/following::input)[1]";
	static String aname = ".//label/span[text()='Account Name']/following::input[1]";
	static String saccnt = ".//div[@title='Test Account1']";
	static String closedate = "(.//label/span[text()='Close Date']/following::input)[1]";
	static String calendar = ".//div[@class='scroller slds-datepicker']";
	static String date = ".//td/span[text()='Today']";
	static String type = ".//span/span[text()='Type']/following::a[1]";
	static String stage = ".//label/span[text()='Stage']/following::a[1]";
	static String budget = ".//label/span[text()='Budget Confirmed']/following::input[1]";
	static String discovery = ".//label/span[text()='Discovery Completed']/following::input[1]";
	static String roi= ".//label/span[text()='ROI Analysis Completed']/following::input[1]";
	static String amount = ".//label/span[text()='Amount']/following::input[1]";
	static String reason = ".//span/span[text()='Loss Reason']/following::a[1]";
	static String save = "(//button/span[text()='Save'])[2]";
	static String text = ".//div/p[text()='Opportunity']";
	static String msg = ".//div/p[text()='Opportunity']/following::span[1]";
	
    public static void gotoOpportunities()
	{
    	Utility.waits(opportunities);
      if(driver.findElement(By.xpath(opportunities)).isDisplayed())
   	  {
    	 driver.findElement(By.xpath(opportunities)).click();
    	 Utility.waits(newbtn);
    	 driver.findElement(By.xpath(newbtn)).click();
   	  }
	}
    
    public static void createOpportunity() throws Exception
    {
        Utility.waits(container);
    	if(driver.findElement(By.xpath(container)).isDisplayed())
        {
         System.out.println(driver.findElement(By.xpath(heading)).getText());
         
         driver.findElement(By.xpath(oppname)).sendKeys("Test Opportunity 1");
         driver.findElement(By.xpath(aname)).click();
         driver.findElement(By.xpath(saccnt)).click();
         
         driver.findElement(By.xpath(closedate)).click();
         Utility.waits(calendar);
         
         driver.findElement(By.xpath(date)).click();
         driver.findElement(By.xpath(type)).sendKeys("New Business",Keys.ENTER);
         driver.findElement(By.xpath(stage)).sendKeys("Proposal",Keys.ENTER);
         driver.findElement(By.xpath(budget)).click();
         driver.findElement(By.xpath(discovery)).click();
         driver.findElement(By.xpath(roi)).click();
         driver.findElement(By.xpath(amount)).sendKeys("29384");
         driver.findElement(By.xpath(reason)).sendKeys("Other",Keys.ENTER);
         
         driver.findElement(By.xpath(save)).click();
         
         Utility.waits(text);
	     String opp = driver.findElement(By.xpath(msg)).getText();
	     System.out.println(opp+" opportunity is created");
   	  }
      else
 	  {
 	   System.out.println("Contact Creation form is not launched, try again");
 	   gotoOpportunities();
 	   //driver.close();
 	  }
	}
}