package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import Generic_Utilities.WebDriver_Utility;
import POM_Repo.CampaignCreatePage;
import POM_Repo.Home_page;
import POM_Repo.Login_page;
import POM_Repo.ProductCreatePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CampaignWithProductTest extends BaseClass {
   
	@Test(groups = "RegressionTest")
	public void campaignWithProductTest() throws Throwable
	{
		//Launching the Browser
	       Property_Utility plib=new Property_Utility();
	       /*String BROWSER = plib.getKeyValue("Browser");
	       
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
	     
	     //to maximize the window
	     //driver.manage().window().maximize();
	       
		//Fetching data from property_file
	   /* String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");*/
        
        //Login to Vtiger application
       /* driver.get(URL);
        Login_page login=new Login_page(driver);
		login.loginToApp(USERNAME, PASSWORD);*/
        
		//Go to Home Page
		Home_page home=new Home_page(driver);
		
		//click the tab
		home.clickProduct();
        
		//To Create Product
		ProductCreatePage prodPage=new ProductCreatePage(driver);
		prodPage.clickProduct();
        
        
        //RandomClass
        Java_Utility jlib=new Java_Utility();
        int ranNum = jlib.getRandomNum();
        
        //Fetching data from excel sheet  
        Excel_Utility elib=new Excel_Utility();
        String prdName = elib.getExcelData("Product", 0, 0)+ranNum;
        
        //add excel data
        prodPage.ProductName(prdName);
        
        //save
        prodPage.saveButton();
        
        //click on MoreLink
		home.clickMoreLink();
        //driver.findElement(By.linkText("More")).click();
		
        home.clickCampaign();
       // driver.findElement(By.linkText("Campaigns")).click();
        
       //To Create Campaign
        CampaignCreatePage campPage=new CampaignCreatePage(driver);
        campPage.clickCampaign();
       // driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
        
      //Fetching data from excel sheet
        Excel_Utility elib1=new Excel_Utility();
        String campName = elib1.getExcelData("Campaign", 1, 1)+ranNum;
        /*FileInputStream fes1=new FileInputStream("./src/test/resources/ExcelFeb.xlsx");
        Workbook book1 = WorkbookFactory.create(fes1);
        Sheet sheetName1 = book1.getSheet("Campaign");
        Row rowNum1 = sheetName1.getRow(1);
        Cell cellNum1 = rowNum1.getCell(1);
        String data = cellNum1.getStringCellValue()+ranNum;*/
        
      //add excel data
        campPage.CampaignName(campName);
        //driver.findElement(By.name("campaignname")).sendKeys(campName);
      //click on Select
        campPage.select();
       // driver.findElement(By.xpath("//img[@alt='Select']")).click();
        
        //Switching Window
        WebDriver_Utility wlib=new WebDriver_Utility();
        wlib.switchToWindow(driver, "Products&action");
       /* Set<String> allid = driver.getWindowHandles();
        Iterator<String> it = allid.iterator();
        while(it.hasNext()) {
        	String wid = it.next();
        	driver.switchTo().window(wid);
        	String title = driver.getTitle();
        	if(title.contains("Products&action"))
        	{
        		break;
        	}
        }*/
        
        //search the required data
        prodPage.SearchText(prdName);
       // driver.findElement(By.name("search_text")).sendKeys(prdName);
        
       //for searching
        prodPage.search();
       // driver.findElement(By.xpath("//input[@name='search']")).click();
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='"+prdName+"']")).click();
        
        //Switching Window
        Thread.sleep(2000);
        wlib.switchToWindow(driver, "Campaigns&action");
        /*Set<String> allid1=driver.getWindowHandles();
        Iterator<String> it1 = allid1.iterator();
        while(it1.hasNext())
        {
        	String wid1 = it1.next();
        	driver.switchTo().window(wid1);
        	String title1=driver.getTitle();
        	if(title1.contains("Campaigns&action"))
        	{
        		break;
        	}
        }*/
        
        System.out.println(driver.getTitle());
      
        //save
        prodPage.saveButton();
       // driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
       
        ///For Validation
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
       //signout
       Thread.sleep(2000);
       //home.logout(driver);

	}

}
