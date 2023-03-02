package Campaign;

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
import POM_Repo.CampaignCreatePage;
import POM_Repo.Home_page;
import POM_Repo.Login_page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignTest extends BaseClass{
   
	@Test
	public void createCampaignTest() throws Throwable
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
			
	       //for maximize the window
			//driver.manage().window().maximize();
	       
	       
				//Fetching data from property_file
				/*String URL = plib.getKeyValue("url");
				String USERNAME = plib.getKeyValue("username");
				String PASSWORD = plib.getKeyValue("password");*/
				
		        
		        //Login to Vtiger application
		        /*driver.get(URL);
				Login_page login=new Login_page(driver);
				login.loginToApp(USERNAME, PASSWORD);*/
		       
				//click on organisation link
				Home_page home=new Home_page(driver);
				
		        //click on MoreLink
				home.clickMoreLink();
		        //driver.findElement(By.linkText("More")).click();
		        
		        //click on Campaign tab
		        home.clickCampaign();
		        //driver.findElement(By.name("Campaigns")).click();
		        
		        //To Create Campaign
		        CampaignCreatePage campPage=new CampaignCreatePage(driver);
		        campPage.clickCampaign();
		        //driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		        
		        //RandomClass
		        Java_Utility jlib=new Java_Utility();
		        int ranNum = jlib.getRandomNum();
		       // Random ran=new Random();
		       // int ranNum = ran.nextInt(1000);
		        
		        
		      //Fetching data from excel sheet
		        Excel_Utility elib=new Excel_Utility();
		        String campName = elib.getExcelData("Campaign", 1, 1)+ranNum;
		        
		        //add excel data
		        campPage.CampaignName(campName);
		      
		        //save
		        campPage.saveButton();
		        
		        //For Validation
		        Thread.sleep(2000);
		        String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			      if(actData.contains(campName))
			      {
			    	  System.out.println("PASS");
			      }
			      else
			      {
			    	  System.out.println("FAIL");  
			      }
			      
			      //logout
		          //home.logout(driver);
		

	}

}
