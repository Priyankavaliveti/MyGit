package Com.SFDC.TestCases;

import java.io.IOException;
import org.testng.Reporter;
import org.testng.annotations.*;
import Com.SFDC.PageValidations.VerifyHomePage;
import Com.SFDC.PageValidations.VerifyLoginPage;
import Com.SFDC.Pages.AccountsPage;
import Com.SFDC.Pages.ContactsPage;
import Com.SFDC.Pages.HomePage;
import Com.SFDC.Pages.LoginPage;
import Common.Utility;

public class ValidateSFDCLogin extends Utility
{

@BeforeClass()
@Parameters({"browser","url"})	
public void startApplication(String browser,String url) throws IOException, InterruptedException
{
  Utility.SheetName="Accounts";	
  //Thread.sleep(3000);
  Utility.openUrl(browser, url);
  Reporter.log("Browser launched successfully");  
}

@Parameters({"username","password"})
@Test(priority=1,description="Login to SFDC")
public void logInTest(String uname,String pwd) throws Exception
{
	  VerifyLoginPage.VerifyLoginPagefields();	  
	  LoginPage.login(uname, pwd);
	  Utility.waits(HomePage.title);
}

@Test(priority=2,description="HomePage validation",dependsOnMethods="logInTest")
public void homePage() throws InterruptedException

{	
	
	VerifyHomePage.VerifyHomePagefields();
	HomePage.findloginname();
}

@Test(priority=3,description="Account Creation")
public void accounts() throws Exception

{	
	AccountsPage.gotoAccounts();
	AccountsPage.createAccount();
}

@Test(priority=4,description="Contact Creation")
public void contacts() throws Exception
{
 ContactsPage.createContact();	
}

/*@Test(priority=5,description="Opportunity Creation")
public void opportunities()throws Exception
{
 OpportunitiesPage.createopportunity();	
}*/

@AfterClass()
public void closeBrowser() throws IOException, InterruptedException
{
  HomePage.logout();
  Thread.sleep(7000);
  driver.close();  
}

}