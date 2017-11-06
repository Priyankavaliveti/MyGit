package Com.SFDC.PageValidations;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import Com.SFDC.Pages.LoginPage;

public class VerifyLoginPage extends Common.Utility
{
	public static void VerifyLoginPagefields() throws InterruptedException
	{
		Assert.assertTrue(driver.findElement(By.xpath(LoginPage.uname)).isDisplayed());
		Reporter.log("Username field is displayed");
		
		Assert.assertTrue(driver.findElement(By.xpath(LoginPage.pwd)).isDisplayed());
		Reporter.log("Password field is displayed");
		
		Assert.assertTrue(driver.findElement(By.xpath(LoginPage.login)).isDisplayed());
		Reporter.log("Login button is displayed");
	}
}