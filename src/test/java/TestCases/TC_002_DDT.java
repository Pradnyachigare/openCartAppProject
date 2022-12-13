package TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import TestCases.baseClass;
import PageObjects.loginPage;
import PageObjects.myAccountPage;
import Utilities.DataProviders;

public class TC_002_DDT extends baseClass{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups= {"sanity"})
	public void test_DDT(String email, String Password,String exp)
	{
		try {
		
		loginPage lp=new loginPage(driver);
		lp.autouse(email);
		lp.autopass(Password);
		lp.autoLogin();
		
		myAccountPage mcc=new myAccountPage(driver);
		boolean targetPage=mcc.myPageExit();
		
		if(exp.equals("Valid"))
		{
			if(targetPage==true) {
				mcc.autoLogout();
				Assert.assertTrue(true);
				
			}
		}
		
		else
		{
			Assert.assertTrue(false);
		}
		
		if(exp.equals("Invalid"))
		{
			if(targetPage==true) {
				mcc.autoLogout();
				Assert.assertTrue(false);
				
			}
		}
		
		else
		{
			Assert.assertTrue(true);
		}
		}catch(Exception e){
			
			Assert.fail();
		}
	}

}
