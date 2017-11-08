package site1;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frames_multi_windows
{
 public static void main(String[] args) throws Exception
 {
   //System.setProperty("webdriver.ie.driver", "D:\\Selenium JARs\\drivers\\IEDriverServer.exe");
   //WebDriver d = new InternetExplorerDriver();
	 
   WebDriver d = new FirefoxDriver();
   d.get("http://www.way2automation.com/");
   d.manage().window().maximize();
   WebDriverWait wait = new WebDriverWait(d,80);
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@href,'@way2automation.com')])[1]")));
   
   JavascriptExecutor js = (JavascriptExecutor)d; 
   
   Actions act = new Actions(d);
   WebElement menu = d.findElement(By.xpath("//a[text()='Resources']"));
   WebElement item = d.findElement(By.xpath("//a[text()='Resources']/following-sibling::ul/li[last()-1]/a"));
   
   js.executeScript("arguments[0].scrollIntoView(true);", menu);
   
   act.moveToElement(menu).moveToElement(item).build().perform();
   item.click();
         
   Thread.sleep(5000);
   
   String parent = d.getWindowHandle(); // Store your parent window
   
   for(String child : d.getWindowHandles()) // get all window handles
   {	   
    d.switchTo().window(child); // switch to popup window

     // Now you are in the popup window, perform necessary actions here
   
     d.findElement(By.xpath("//a[text()='Signin']")).click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='ajaxlogin']/h3")));
	 d.findElement(By.xpath("//form[@class='ajaxlogin']/fieldset/input[@name='username']")).sendKeys("rpgrandhi");
	 d.findElement(By.xpath("//form[@class='ajaxlogin']/fieldset/input[@name='password']")).sendKeys("Y9MC37032");
	 d.findElement(By.xpath("//form[@class='ajaxlogin']/div/div[2]")).click();
   }

	 d.switchTo().window(parent);  //switch back to parent window
	 d.navigate().refresh();
     
     WebElement ele = d.findElement(By.xpath("//a[@href='frames-and-windows.php']"));
     //WebElement ele= d.findElement(By.xpath("(//a[@href='alert.php'])[1]"));
     js.executeScript("arguments[0].scrollIntoView(true);", ele);
     ele.click();
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='iternal_h3']")));
     System.out.println(d.findElement(By.xpath("//h3[@class='iternal_h3']")).getText());
     
     d.findElement(By.xpath("//a[@href='#example-1-tab-4']")).click();
     WebElement f = d.findElement(By.xpath("//iframe[@src='frames-windows/defult4.html']"));
     
     d.switchTo().frame(f);
     d.findElement(By.xpath("//a[@href='#' and contains(text(),'multiple')]")).click();
     Thread.sleep(3000);
     
     for(String child : d.getWindowHandles()) // get all window handles
     {	
       System.out.println("No. of child windows are : "+(d.getWindowHandles().size()));	 
       if(!child.equals(parent))
       {
    	d.switchTo().window(child);
    	d.navigate().refresh(); 
    	System.out.println("child window : "+d.findElement(By.xpath("//a[@href='#' and contains(text(),'Open Window')]")).getText());
        System.out.println(d.getCurrentUrl());
        d.close();
       }      
     }
     d.switchTo().window(parent);  //switch back to parent window
	 d.navigate().refresh();
	 System.out.println(d.findElement(By.xpath("//h1[@class='heading']")).getText());
     d.quit(); 
 }
}