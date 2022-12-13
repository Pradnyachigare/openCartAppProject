package TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {
	public static WebDriver driver;
	
	public Logger logger;
	//public ResourceBundle rb;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
		//rb=ResourceBundle.getBundle("config");
		
		logger=LogManager.getLogger(this.getClass());
		
		//WebDriverManager.chromedriver().setup();
		
		if(br.equals("chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(br.equals("firfox"))
		{
			driver=new FirefoxDriver();
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		
		//driver.manage().timeouts().implicitlyWait(ofSeconds(10));
		
		//driver.get(rb.getString("baseURL"));
		driver.get("https://practice.automationtesting.in/my-account/");
		//driver.manage().window().maximize();
		
		
	}
	

	@AfterClass (groups= {"master"})
	public void tearDown()
	{
		
		driver.quit();
	}
	
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(10);
		return(generatedString);
	}

	public String randomeNumeric()
	{
		String generatedString2=RandomStringUtils.randomNumeric(10);
		return(generatedString2);
	}
	
	public String randomeAlphanumeric()
	{
		String st=RandomStringUtils.randomAlphabetic(10);
		String nm=RandomStringUtils.randomNumeric(10);
		return(st+nm);
	}


	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;


}
}
