package site1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login
{
 public static void main(String[] args) throws Exception
 {
  // http://way2automation.com/way2auto_jquery/index.php
	 System.setProperty("webdriver.ie.driver", "D:\\Selenium JARs\\drivers\\IEDriverServer.exe");
	   WebDriver d = new InternetExplorerDriver();
	   d.get("http://way2automation.com/way2auto_jquery/index.php");
	   WebDriverWait wait = new WebDriverWait(d,80);
	   JavascriptExecutor js= (JavascriptExecutor)d;
	            
	   Thread.sleep(5000);
	   
	   WebElement form = (WebElement)(js.executeScript("return document.forms[1].elements[15]"));
	   form.click();
	   System.out.println("Element clicked");
//	   WebElement form = d.findElement(By.xpath("//form[@class='ajaxsubmit']/h3"));
//	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='ajaxsubmit']/h3")));
//	   if(form.isDisplayed())
//	   {
//		 d.findElement(By.xpath("//a[text()='Signin']")).click();
//		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='ajaxlogin']/h3")));
//		 d.findElement(By.xpath("//input[@name='username']")).sendKeys("rpgrandhi");
//		 d.findElement(By.xpath("//input[@name='password']")).sendKeys("Y9MC37032");
//		 d.findElement(By.xpath("//input[@class='button']")).click();
//	   }  
 }
}