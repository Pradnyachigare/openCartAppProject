package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
static WebDriver rdriver;
	
	public  BasePage(WebDriver ldriver)
	{
		ldriver=rdriver;
		
	PageFactory.initElements(ldriver,this);
	}
	

}
