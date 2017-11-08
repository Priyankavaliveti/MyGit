package Com.SFDC.Pages;

import org.openqa.selenium.By;
import org.testng.Reporter;

import Common.Utility;


public class HomePage extends Utility
{
  public static String title = "//div/h2[@class='title']";
  static String profile = "//img[@class='profileTrigger']";
  static String username = "//h1[@class='profile-card-name']/a";
  static String logout = "//a[@href='/secur/logout.jsp']";
 
  public static void findloginname()
	{
     Utility.waits(title);
     if(driver.findElement(By.xpath(title)).isDisplayed())
	 {
      driver.findElement(By.xpath(profile)).click();
      String name = driver.findElement(By.xpath(username)).getText();
	  //System.out.println("User "+name+" is logged in");
	  Reporter.log("User "+name+" is logged in");
	 }
	 else
	 {
	  //System.out.println("User is not logged in, Please check after logging in ");
	  Reporter.log("User is not logged in, Please check after logging in ");
	  driver.close();
	 }
  }
  
  public static void logout()
  {
	driver.findElement(By.xpath(profile)).click();
	driver.findElement(By.xpath(logout)).click();
  }
}