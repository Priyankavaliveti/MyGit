package Com.SFDC.Pages;

import org.openqa.selenium.By;
import Common.Utility;


public class LoginPage extends Utility
{
	
   public static String uname = "//input[@name='username']";
   public static String pwd = "//input[@id='password']";
   public static String login = "//input[@id='Login']";
	


	public static void login(String uname1, String pwd1)
	{
		driver.findElement(By.xpath(uname)).clear();
		driver.findElement(By.xpath(uname)).sendKeys(uname1);
		driver.findElement(By.xpath(pwd)).clear();
		driver.findElement(By.xpath(pwd)).sendKeys(pwd1);
		driver.findElement(By.xpath(login)).click();
	}

}
