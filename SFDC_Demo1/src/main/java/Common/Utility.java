package Common;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class Utility 
{
	public static WebDriver driver;
	public static String  Imageupload = System.getProperty("user.dir") + "\\src\\test\\resources\\images\\Hydrangeas.jpg";

	public static String SheetName;

	public static int totalNoOfRows;


	public static File dataFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx");
		    
	public static void openUrl(String browser, String url)
	{
		switch (browser) 
		{
		case "ie":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//src//test//resources//drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//test//resources//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	
	public static void scrollby(String s) throws Exception	
	{
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(s)));	
	}
	
	public static void waits(String s) 
	{
	 WebDriverWait wait = new WebDriverWait(driver, 80);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(s)));
	}
	
	public static  void safeJavaScriptClick(WebElement element) throws Exception
	
	
	{
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} 
		
		
		catch (StaleElementReferenceException e)
		
		
		{
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} 
		
		
		catch (NoSuchElementException e)
		
		{
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}
	
	
	
	public static void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
	
	
	public static  void getRowCount() throws BiffException, IOException
	
	{
		String SheetName = Utility.SheetName;
    	FileInputStream fs = new FileInputStream(dataFile);
    	Workbook wb = Workbook.getWorkbook(fs);
    	
    	Sheet sh = null;
    	//String data;

    	
    	switch (SheetName) 
    	{
	    	case "nordicare":
	    		sh = wb.getSheet("nordicare");
				break;
			case "fedia":
				sh = wb.getSheet("fidia");
				break;
			case "cimplicity":
				sh = wb.getSheet("cimplicity");
				break;
			case "snf":
				sh = wb.getSheet("snf");
				break;
			
			case "Mrmg":
				sh = wb.getSheet("econsent");
				break;	
				
			case "ModelOwner":
				sh = wb.getSheet("ModelOwner");
				break;
			default:
				break;
		}	    	
    	
    	totalNoOfRows = sh.getRows();
    	//return data; 
		
	}
	
	 public static String readFromExcel(int col,int row) throws BiffException, IOException
	    {
	    	String SheetName = Utility.SheetName;
	    	FileInputStream fs = new FileInputStream(dataFile);
	    	Workbook wb = Workbook.getWorkbook(fs);
	    	Sheet sh = null;
	    	String data;

	    	switch (SheetName) 
	    	{
		    	case "nordicare":
		    		sh = wb.getSheet("nordicare");
					break;
				case "fedia":
					sh = wb.getSheet("fidia");
					break;
				case "cimplicity":
					sh = wb.getSheet("cimplicity");
					break;
				case "snf":
					sh = wb.getSheet("snf");
					break;
				
				case "econsent":
					sh = wb.getSheet("econsent");
					break;	
					
				case "ModelOwner":
					sh = wb.getSheet("ModelOwner");
					break;
				default:
					break;
			}	    	
	    	
	    	totalNoOfRows = sh.getRows();
	    	data = sh.getCell(col, row).getContents().trim();
	    	return data; 	    	
	    	
	    }
	

}