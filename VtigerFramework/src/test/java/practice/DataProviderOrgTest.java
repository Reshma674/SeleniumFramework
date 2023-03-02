package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Utilities.Java_Utility;
import Generic_Utilities.Property_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderOrgTest 
{
	@Test(dataProvider="dataProvider_test")
	public void companyDetails(String name,String phnum,String email) throws Throwable
	{
		//Launching the Browser
	       Property_Utility plib=new Property_Utility();
	       String BROWSER = plib.getKeyValue("Browser");
	       
	       WebDriver driver;
	       if(BROWSER.equalsIgnoreCase("Chrome"))
	       {
	    	   WebDriverManager.chromedriver().setup();
	    	   driver=new ChromeDriver();
	       }
	       else if(BROWSER.equalsIgnoreCase("firefox"))
	       {
	    	   WebDriverManager.firefoxdriver().setup();
	    	   driver=new FirefoxDriver();
	       }
	       else if(BROWSER.equalsIgnoreCase("edge"))
	       {
	    	   WebDriverManager.edgedriver().setup();
	    	   driver=new EdgeDriver();
	       }
	       else
	       {
	    	   driver=new ChromeDriver();
	       }
	    //Maximize thw Window
	       driver.manage().window().maximize();
	    //Passing the Credentials   
	       driver.get("http://localhost:8888/");
	       driver.findElement(By.name("user_name")).sendKeys("admin");
	       driver.findElement(By.name("user_password")).sendKeys("admin");
	       driver.findElement(By.id("submitButton")).click(); 
	    //Create Organization
	       driver.findElement(By.linkText("Organizations")).click();
	       driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    //Fill the Details 
	       driver.findElement(By.name("accountname")).sendKeys(name);
	       driver.findElement(By.id("phone")).sendKeys(phnum);
	       driver.findElement(By.id("email1")).sendKeys(email);
	    //Save   
	       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	       driver.quit();
	       Thread.sleep(2000);
	}
	
	@DataProvider
	public Object[][] dataProvider_test() throws Throwable 
	{
		Java_Utility jlib=new Java_Utility();
        int ranNum = jlib.getRandomNum();
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="ABC"+ranNum;
		objArr[0][1]="123";
		objArr[0][2]="ABC@gmail.com";
		
		Thread.sleep(2000);
		objArr[1][0]="DEF"+ranNum;
		objArr[1][1]="456";
		objArr[1][2]="DEF@gmail.com";
		
		Thread.sleep(2000);
		objArr[2][0]="GHI"+ranNum;
		objArr[2][1]="789";
		objArr[2][2]="GHI@gmail.com";
		
		return objArr;
		
	}

}
