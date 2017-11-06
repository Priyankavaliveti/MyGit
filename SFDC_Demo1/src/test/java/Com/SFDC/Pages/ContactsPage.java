package Com.SFDC.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import Common.Utility;

public class ContactsPage extends Utility
{
	static String accName = "Account 2";
	static String Con= "Contact 1 Test";
	
	public static String contacts = "//a[@href='#/sObject/Contact/home']/span"; //@class='pillText' and
	static String newbtn = ".//a/div[text()='New']";
	static String container = ".//*[@class='modal-container slds-modal__container']";
	static String heading = ".//*[contains(@id,'title_') and contains(@class,'slds-text-heading--medium')]";
    static String salutation = ".//span[text()='Salutation']/following::div[4]/a";
    static String fname = ".//label/span[text()='First Name']/following::input[1]";
    static String mname = ".//label/span[text()='Middle Name']/following::input[1]";
    static String lname = ".//label/span[text()='Last Name']/following::input[1]";
    static String suffix = ".//label/span[text()='Suffix']/following::input[1]";
    static String aname = ".//label/span[text()='Account Name']/following::input[1]";
    static String saccnt = ".//div[@title='"+accName+"']";
    static String acclist = ".//label/span[text()='Account Name']/following::input[1]/following-sibling::div";
    static String cname = ".//label/span[text()='Reports To']/following::input[1]";
    static String scntct = ".//a/following::div[@title='"+Con+"']";
    static String conlist = ".//label/span[text()='Reports To']/following::input[1]/following-sibling::div/div[@class='listContent']/ul/li/a/div[2]/div[1]";
    static String title = "(//label/span[text()='Title']/following::input)[1]";
    static String save = "(.//button/span[text()='Save'])[2]";
    static String text = ".//div/p[text()='Contact']";
    static String msg = "(.//h1/span[@class='uiOutputText'])";
    static String newacc = "(.//label/span[text()='Account Name']/following::input[1]/following-sibling::div/div[@class='']/div/span[2])[2]";
        
    public static void gotoContacts()
	{
      Utility.waits(contacts);
      if(driver.findElement(By.xpath(contacts)).isDisplayed())
   	  {
    	 driver.findElement(By.xpath(contacts)).click();
    	 Utility.waits(newbtn);
    	 driver.findElement(By.xpath(newbtn)).click();
   	  }
	}
    
    public static void createContact() throws Exception
    {
    	Utility.getRowCount();
    	Utility.waits(heading);
    	if(driver.findElement(By.xpath(heading)).isDisplayed())
        {     	
         System.out.println(driver.findElement(By.xpath(heading)).getText());
         
         driver.findElement(By.xpath(salutation)).sendKeys("Ms.",Keys.ENTER);
	     driver.findElement(By.xpath(fname)).sendKeys("Contact");
	     driver.findElement(By.xpath(mname)).sendKeys("3");
	     driver.findElement(By.xpath(lname)).sendKeys("Test");
	     driver.findElement(By.xpath(suffix)).sendKeys("Suffix");
	     
	     Utility.scrollby(aname);
	     driver.findElement(By.xpath(aname)).click();
	     driver.findElement(By.xpath(aname)).sendKeys(accName);
	     
	     List<WebElement> l1 = driver.findElements(By.xpath(acclist));
	      for(WebElement val:l1)
	      {	  
	    	System.out.println(val.getText());
	    	
	    	if(val.getText().contains(accName))
	    	{
	    	  System.out.println(accName);	
	    	  driver.findElement(By.xpath(saccnt)).click();
	    	  System.out.println(accName+" is selected");
	    	  break;
	    	}
	    	else
	    	{
	    	  driver.findElement(By.xpath(newacc)).click();	
	    	  AccountsPage.createAccount();
	    	  break;
	    	}
	      }
	     
	     driver.findElement(By.xpath(cname)).click();
	     driver.findElement(By.xpath(cname)).sendKeys(Con);
	     
	     List<WebElement> l2 = driver.findElements(By.xpath(conlist));
	      	      
	      for(WebElement val:l2)
	      {	  
	    	//System.out.println(val.getText()); 
	    	
	    	if(val.getText().contains(Con))
	    	{
	    	  System.out.println(Con);	
	    	  driver.findElement(By.xpath(scntct)).click();
	    	  System.out.println(Con+" is selected");
	    	  break;
	    	}
	     }
	         
	     driver.findElement(By.xpath(title)).sendKeys("Creating contact");
	     Utility.scrollby(title);
	      
	     driver.findElement(By.xpath(save)).click();
	     Utility.waits(text);
	     String con = driver.findElement(By.xpath(msg)).getText();
	     System.out.println(con+" Contact is created");
   	  }
      else
 	  {
 	   System.out.println("Contact Creation form is not launched, try again");
 	   gotoContacts();
 	   //driver.close();
 	  }
	}
}