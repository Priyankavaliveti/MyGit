package site1;

import java.util.ArrayList;
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

public class Frames_sep_new_window
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
   String child = null;

   Set<String> handles = d.getWindowHandles(); // get all window handles
   System.out.println("Handles size is : "+handles.size());
   Iterator<String> iterator = handles.iterator();
   while (iterator.hasNext())
   {
    child = iterator.next();
   }
   d.switchTo().window(child); // switch to popup window

     // Now you are in the popup window, perform necessary actions here
   
     d.findElement(By.xpath("//a[text()='Signin']")).click();
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='ajaxlogin']/h3")));
	 d.findElement(By.xpath("//form[@class='ajaxlogin']/fieldset/input[@name='username']")).sendKeys("rpgrandhi");
	 d.findElement(By.xpath("//form[@class='ajaxlogin']/fieldset/input[@name='password']")).sendKeys("Y9MC37032");
	 d.findElement(By.xpath("//form[@class='ajaxlogin']/div/div[2]")).click();

	 d.switchTo().window(parent);  //switch back to parent window
	 d.navigate().refresh();
     
     WebElement ele = d.findElement(By.xpath("//a[@href='frames-and-windows.php']"));
   
     js.executeScript("arguments[0].scrollIntoView(true);", ele);
     ele.click();
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='iternal_h3']")));
     System.out.println(d.findElement(By.xpath("//h3[@class='iternal_h3']")).getText());
     

      d.findElement(By.xpath("//a[@href='#example-1-tab-2']")).click();	 
      WebElement f = d.findElement(By.xpath("//iframe[@src='frames-windows/defult2.html']"));
     
      d.switchTo().frame(f);
      d.findElement(By.xpath("//a[@href='#' and contains(text(),'Seprate')]")).click();
      
      ArrayList<String> handle = new ArrayList(d.getWindowHandles()); // get all window handles
      System.out.println("No. of tabs are : "+handle.size());
      
      d.switchTo().window(handle.get(1)); // switch to popup window
      
      System.out.println("Child window opened");
      System.out.println("Text in child window : "+d.findElement(By.xpath("//a[@href='#' and contains(text(),'Seprate')]")).getText());
      Thread.sleep(3000);
      d.close();
      System.out.println("Child window closed");
      
      d.switchTo().window(handle.get(0));  //switch back to parent window 
      d.navigate().refresh();
      System.out.println("Parent window : "+d.findElement(By.xpath("//h1[@class='heading']")).getText());
      d.quit();  
 }
}