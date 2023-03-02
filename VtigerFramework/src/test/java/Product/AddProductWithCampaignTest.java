package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.Property_Utility;
import POM_Repo.CampaignCreatePage;
import POM_Repo.Home_page;
import POM_Repo.Login_page;
import POM_Repo.ProductCreatePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddProductWithCampaignTest 
{
    @Test
	public void addProductWithCampaignTest() throws Throwable 
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
	       
	       //To maxi mize the window
	       driver.manage().window().maximize();
	       
		//Fetching data from property_file
	    String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
     
		        
		        //Login to Vtiger application
		        driver.get(URL);
				Login_page login=new Login_page(driver);
				
				//Go to Home Page
				Home_page home=new Home_page(driver);
				
				//To Create Product
				ProductCreatePage prodPage=new ProductCreatePage(driver);
				prodPage.clickProduct();
		        
		        //RandomClass
		        Java_Utility jlib=new Java_Utility();
		        int ranNum = jlib.getRandomNum();
		        
		        //Fetching data from excel sheet
		        Excel_Utility elib=new Excel_Utility();
		        String prodName = elib.getExcelData("Product", 0, 0)+ranNum;
		        
		        //add excel data
		        prodPage.ProductName(prodName);
		       
		        
		        //save
		        prodPage.saveButton();
		        
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
		        driver.findElement(By.name("product_name")).click();
		        driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		        driver.findElement(By.name("search_text")).click();
		        driver.findElement(By.xpath("//input[@type='button']")).click();
		        
		      ///For Validation
		        Thread.sleep(2000);
		        String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 	      if(actData.contains(prodName))
		 	      {
		 	    	  System.out.println("PASS");
		 	      }
		 	      else
		 	      {
		 	    	  System.out.println("FAIL");  
		 	      }
		 	      
		 	    //logout
		 	      home.logout(driver);

	}

}
