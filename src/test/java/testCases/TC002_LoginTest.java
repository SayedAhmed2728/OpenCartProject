package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {
	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
	logger.info("Starting TC_002 login test");	
	try
	{
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	LoginPage lp=new LoginPage(driver);
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	lp.clickLogin();
	
	MyAccountPage macc=new MyAccountPage(driver);
	boolean targetPage=macc.isMyAccountPageExists();
	Assert.assertTrue(targetPage);
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	logger.info("Finished TC_002 login test");
	}

}
