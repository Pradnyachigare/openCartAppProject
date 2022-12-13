package TestCases;


import org.apache.logging.log4j.EventLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.loginPage;
import PageObjects.myAccountPage;
//import Utilities.DataProviders;

public class TC_001LoginPage extends baseClass{
	
	@Test
	
	public void login()
	{
		//EveLogger.debug("...Application is going on......");
		try {
		logger.info("start login method ");//loginpage
		
		loginPage lp=new loginPage(driver);
		lp.autouse("Pradnya@gmail.com");
		lp.autopass("Pradnya@123");
		lp.autoLogin();
		logger.info("login is completed");

		myAccountPage mcc=new myAccountPage(driver);// myaccountPage 
		boolean targetPage=mcc.myPageExit();
		System.out.println(targetPage);
		Assert.assertEquals(targetPage,true);
		
		}
		catch(Exception e) {
			Assert.assertTrue(false);
		}
		
		logger.info("....Finish TC_002...........");
		
		
		
		
		
	
		
	}
	
}
