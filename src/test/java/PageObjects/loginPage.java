package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends BasePage{ 
	

	
	public loginPage (WebDriver rdriver)
	{
		super(rdriver);
	}
	
	@FindBy(id="username")
	@CacheLookup
	WebElement txtusername;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPass;
	
	@FindBy(name="login")
	@CacheLookup
	WebElement btnlogin;
	
	
	
	
	public void autouse(String usename)
	{
		txtusername.sendKeys(usename);
	}
	
	public void autopass(String passw)
	{
		txtPass.sendKeys(passw);
	}
	
	public void autoLogin()
	{
		btnlogin.click();
	}
	

	

}
