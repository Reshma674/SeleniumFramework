package contact;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.Property_Utility;
import POM_Repo.ContactCreatePage;
import POM_Repo.Home_page;
import POM_Repo.Login_page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest extends BaseClass {

	@Test
	public void createContactTest() throws Throwable
	{
		//Launching the Browser
	       Property_Utility plib=new Property_Utility();
	      /* String BROWSER = plib.getKeyValue("Browser");
	       
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
	       }*/
	       
	     //To maximize the window
	       //driver.manage().window().maximize();
	       
		//Fetching data from property_file
	      /* String URL = plib.getKeyValue("url");
		   String USERNAME = plib.getKeyValue("username");
		   String PASSWORD = plib.getKeyValue("password");*/
     
        
       //Login to Vtiger application
        /*driver.get(URL);
        Login_page login=new Login_page(driver);
		login.loginToApp(USERNAME, PASSWORD);*/
		
		//Go to Home Page
        Home_page home=new Home_page(driver);
        
        //click the tab
		home.clickContact();
        //driver.findElement(By.linkText("Contacts")).click();
		
		//To Create Organisation
		ContactCreatePage conPage=new ContactCreatePage(driver);
		conPage.clickContact();
        //driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
       
        //RandomClass
        Java_Utility jlib=new Java_Utility();
        int ranNum = jlib.getRandomNum();
        
      //Fetching data from excel sheet
        Excel_Utility elib=new Excel_Utility();
        String conName = elib.getExcelData("Contact", 1, 0)+ranNum;
        
        //enter first name
        conPage.ContactFirstName(conName);
        //driver.findElement(By.name("firstname")).sendKeys(conName);
        //enter last name
        conPage.ContactLastName(conName);
        //driver.findElement(By.name("lastname")).sendKeys(conName);
        //add mobile no
        conPage.mobileNo();
        //driver.findElement(By.name("mobile")).sendKeys(conName);
        
        //save
        conPage.saveButton();
        //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
        String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	      if(actData.contains(conName))
	      {
	    	  System.out.println("PASS");
	      }
	      else
	      {
	    	  System.out.println("FAIL");  
	      }
        //signout
	       Thread.sleep(2000);
	      // home.logout(driver);
	    	

	}

}
