package Com.SFDC.PageValidations;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import Com.SFDC.Pages.AccountsPage;
import Com.SFDC.Pages.ContactsPage;
import Com.SFDC.Pages.HomePage;
import Com.SFDC.Pages.OpportunitiesPage;

public class VerifyHomePage extends Common.Utility
{
	public static void VerifyHomePagefields() throws InterruptedException
	{
		Assert.assertTrue(driver.findElement(By.xpath(HomePage.title)).isDisplayed());
		Reporter.log("Title in Home tab is displayed");
		
		Assert.assertTrue(driver.findElement(By.xpath(AccountsPage.accounts)).isDisplayed());
		Reporter.log("Accounts tab is displayed");
		
		Assert.assertTrue(driver.findElement(By.xpath(ContactsPage.contacts)).isDisplayed());
		Reporter.log("Contacts tab is displayed");
		
		Assert.assertTrue(driver.findElement(By.xpath(OpportunitiesPage.opportunities)).isDisplayed());
		Reporter.log("Opportunities tab is displayed");
	}
}