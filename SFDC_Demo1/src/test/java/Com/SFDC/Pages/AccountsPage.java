package Com.SFDC.Pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Reporter;

import Common.Utility;
import jxl.read.biff.BiffException;

public class AccountsPage extends Utility
{
	static String accName;
	
	public static String accounts = "//a[@href='#/sObject/Account/home']/span";
	static String newbtn = "//a[@class='forceActionLink']/div[text()='New']";
	static String container = "//div[@class='modal-container slds-modal__container']";
	static String heading = "//div[@class='modal-header slds-modal__header']/h2";
	static String aname = "(//label/span[text()='Account Name']/following::input)[1]";
	static String type = "(//span/span[text()='Type']/following::a)[1]";
	static String paccnt = "(//label/span[text()='Parent Account']/following::input)[1]";
	static String website = ".//*[@class=' input' and @type='url']";
	static String phone = ".//*[@class=' input' and @type='tel']";
	static String description = ".//textarea[@class=' textarea']";
	static String industry = "(//span/span[text()='Industry']/following::a)[1]";
	static String employees = ".//input[@class=' input' and @type='text']";
    static String save = "//button[@title='Save']";
    static String cancel = "//button[@title='Cancel']/span";
    static String text = "//p[text()='Account']";
    static String message = "//h1/span[@class='uiOutputText']";      
    
    
    public static void gotoAccounts()
	{
    
     Utility.waits(accounts);
    	
     if(driver.findElement(By.xpath(accounts)).isDisplayed())
	 {
      driver.findElement(By.xpath(accounts)).click();
      Utility.waits(newbtn);
      driver.findElement(By.xpath(newbtn)).click();
	 }
	} 
    
    public static void createAccount() throws InterruptedException, BiffException, IOException
    {     
      Utility.getRowCount();	
      Utility.waits(heading);
      if(driver.findElement(By.xpath(heading)).isDisplayed())
      { 
       System.out.println(driver.findElement(By.xpath(heading)).getText());
       
       for(int i=1;i<=Utility.totalNoOfRows-1;i++)
       {
    	   
       accName = Utility.readFromExcel(2, i);
       String saccnt = "//div[@title='"+accName+"']";
       driver.findElement(By.xpath(aname)).sendKeys(Utility.readFromExcel(0, i));
      
       driver.findElement(By.xpath(type)).sendKeys(Utility.readFromExcel(1, i),Keys.ENTER);
       
       driver.findElement(By.xpath(paccnt)).click();
       driver.findElement(By.xpath(paccnt)).sendKeys(accName);
       Thread.sleep(7000);
       driver.findElement(By.xpath(saccnt)).click();
       
       driver.findElement(By.xpath(website)).sendKeys(Utility.readFromExcel(3, i));
       driver.findElement(By.xpath(phone)).sendKeys(Utility.readFromExcel(4, i));
       driver.findElement(By.xpath(description)).sendKeys(Utility.readFromExcel(5, i));
       driver.findElement(By.xpath(industry)).sendKeys(Utility.readFromExcel(6, i),Keys.ENTER);
       driver.findElement(By.xpath(employees)).sendKeys(Utility.readFromExcel(7, i));
       
       Thread.sleep(3000);
       
       driver.findElement(By.xpath(save)).click();
       }
       
       
       
       /*Boolean accountcheck=driver.findElement(By.xpath(heading)).isDisplayed();
       
       System.out.println(accountcheck);*/
       
       Thread.sleep(10000);
      // Utility.waits(text);
       
       if(driver.findElement(By.xpath(text)).isDisplayed())
       {
    	   String name = driver.findElement(By.xpath(message)).getText();          
           //System.out.println("Account "+name+" is created");
           Reporter.log("Account "+name+" is created");
       }
       else	   
       {
    	  AccountsPage.createAccount();    	   
       }       
           
	 }
	 else
	 {
	  //System.out.println("Account Creation form is not launched, try again");
		 Reporter.log("Account Creation form is not launched, try again");	 
	  //driver.close();
	  gotoAccounts();
	 }
   }    
}