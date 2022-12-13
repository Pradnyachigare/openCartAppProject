package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class myAccountPage extends BasePage{

	public myAccountPage(WebDriver rdriver) {
		super(rdriver);
		
	}
	
	@FindBy(xpath="//*[@id=\"page-36\"]/div/div[1]/div/p[1]")
	WebElement msgHeading;
	
	@FindBy(linkText="Sign out")
	@CacheLookup
	WebElement btnlogout;
	
	public boolean myPageExit()
	{
	try
	{
		return(msgHeading.isDisplayed());
	}catch(Exception e){
		return(false);
	}
	
	}
	
	public void autoLogout()
	{
		btnlogout.click();
	}

}
