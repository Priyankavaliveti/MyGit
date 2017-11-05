package site1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sections
{
 public static void main(String[] args)
 {
  WebDriver d = new FirefoxDriver();
  WebDriverWait wait = new WebDriverWait(d,80);
  d.get("http://way2automation.com/");
  d.manage().window().maximize();
  //added a comment after push operation
  Actions act = new Actions(d);
  try
  {
    if(d.findElement(By.xpath("//li[@class='mail_link']")).isDisplayed())
    {
	 WebElement ele = d.findElement(By.xpath("//a[text()='Resources']"));
	 WebElement ele1 = d.findElement(By.xpath("//a[text()='Practice site 1']"));
	 act.moveToElement(ele).moveToElement(ele1).build().perform();
	 ele1.click();
	 String parent = d.getWindowHandle();
	 String child = null;
	 
	 Set<String> handles = d.getWindowHandles();
	 Iterator<String> iterator = handles.iterator();

	 while(iterator.hasNext())
	 {
	  child=iterator.next();	 
	 }
	 d.switchTo().window(child);
	 
	 /*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='register']/h3")));
	 if(d.findElement(By.xpath("//input[@value='register']/h3")).isDisplayed())
	 {*/
	  d.findElement(By.xpath("//a[text()='Signin']")).click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Login']")));
	  d.findElement(By.xpath("//h3[text()='Login']/following::input[@name='username']")).sendKeys("rpgrandhi");
	  d.findElement(By.xpath("//h3[text()='Login']/following::input[@name='password']")).sendKeys("Y9MC37032");
	  d.findElement(By.xpath("//h3[text()='Login']/following::input[@class='button']")).click();
	 //}
	 
	 d.switchTo().window(parent);
	 d.getCurrentUrl();
	 if(d.getTitle().equalsIgnoreCase("Welcome to the test site"))
	 {
	  //h1[@class='heading' and text()='Frames and Windows']
	  System.out.println("Page is identified");	
	  d.findElement(By.xpath("//a[text()='Frames and Windows']")).click();
	  //a[text()='Open Seprate New Window']
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#example-1-tab-2']")));
	  d.findElement(By.xpath("//a[@href='#example-1-tab-2']")).click();
	  
	 }
	 else
	  System.out.println("Page is not identified");	 
    }
  }
  catch(Exception e)
  {
   e.printStackTrace();
   System.out.print(e);
  }
 }
}