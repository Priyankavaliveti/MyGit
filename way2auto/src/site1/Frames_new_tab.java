package site1;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frames_new_tab
{
 public static void main(String args[]) throws Exception
 {
  //System.setProperty("org.apache.commons.logging.Log", "org.apache.commoms.logging.impl.Jdk14Logger");
  
  /*ProfilesIni profiles = new ProfilesIni();
  FirefoxProfile profile = profiles.getProfile("QA Selenium");
  
  WebDriver d = new FirefoxDriver(profile);*/
  
  WebDriver d = new FirefoxDriver();
  d.navigate().to("http://www.way2automation.com/");
  d.manage().window().maximize();
  
  WebDriverWait wait = new WebDriverWait(d, 80);
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='mailto:trainer@way2automation.com'])[1]")));
  
  WebElement menu = d.findElement(By.xpath("//a[text()='Resources']"));
  WebElement item = d.findElement(By.xpath("//a[text()='Practice site 1']"));
  
  Actions act = new Actions(d);
  act.moveToElement(menu).moveToElement(item).build().perform();
  item.click();
  
  Thread.sleep(5000);
  
  String parent = d.getWindowHandle();
  Set<String> handles = d.getWindowHandles();
  
  for(String child:handles)
  {
   d.switchTo().window(child);  
   d.findElement(By.xpath("//a[text()='Signin']")).click();
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='ajaxlogin']/h3")));
   d.findElement(By.xpath("//form[@class='ajaxlogin']/fieldset/input[@name='username']")).sendKeys("rpgrandhi");
   d.findElement(By.xpath("//form[@class='ajaxlogin']/fieldset/input[@name='password']")).sendKeys("Y9MC37032");
   d.findElement(By.xpath("//form[@class='ajaxlogin']/div/div[2]")).click();	  
  }
  d.switchTo().window(parent);
  d.navigate().refresh();
  
  d.findElement(By.xpath("//a[@href='frames-and-windows.php']")).click();
  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='heading']")));
  
  //d.findElement(By.xpath("//a[@href='#example-1-tab-1']")).click();
  
  WebElement f = d.findElement(By.xpath("//iframe[@src='frames-windows/defult1.html']"));
  
  d.switchTo().frame(f);
  
  d.findElement(By.xpath("//a[contains(text(),'Browser')]")).click();
  
  ArrayList<String> tabs =new ArrayList(d.getWindowHandles());
  
  System.out.println("No. of tabs are : "+tabs.size());
  
  d.switchTo().window(tabs.get(1));
  
  System.out.println("Text in new tab is : "+d.findElement(By.xpath("//a[contains(text(),'Browser')]")).getText());
  d.close();
  
  
  /*for(String child1 : handles)
  {
   if(!child1.equals(parent))
   {
	d.switchTo().window(child1);
	d.navigate().refresh();
	System.out.println("Text in new tab is : "+d.findElement(By.xpath("//a[contains(text(),'Browser')]")).getText());
	d.close();
   }
  }*/
  d.switchTo().window(tabs.get(0));  //switch back to parent window
  d.navigate().refresh();
  System.out.println("Main window text is : "+d.findElement(By.xpath("//h1[@class='heading']")).getText());
  d.quit();
 }
}