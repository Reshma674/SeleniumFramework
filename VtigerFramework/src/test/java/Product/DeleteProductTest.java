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
import org.openqa.selenium.Alert;
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
import POM_Repo.Home_page;
import POM_Repo.Login_page;
import POM_Repo.ProductCreatePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteProductTest extends BaseClass
{
    @Test
	public void deleteProductTest() throws Throwable 
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
	       
	     //To minimize the window
	     // driver.manage().window().maximize();
	       
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
		       // driver.findElement(By.linkText("Products")).click();
				
				//To Create Product
				ProductCreatePage prodPage=new ProductCreatePage(driver);
				prodPage.clickProduct();
		        //driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		        
		        //RandomClass
		        Java_Utility jlib=new Java_Utility();
		        int ranNum = jlib.getRandomNum();
		        
		        //Fetching data from excel sheet
		        Excel_Utility elib=new Excel_Utility();
		        String prodName = elib.getExcelData("Product", 0, 0)+ranNum;
		       /* FileInputStream fes=new FileInputStream("./src/test/resources/ExcelFeb.xlsx");
		        Workbook book = WorkbookFactory.create(fes);
		        Sheet sheetName = book.getSheet("Product");
		        Row rowNum = sheetName.getRow(0);
		        Cell cellNum = rowNum.getCell(0);
		        String prdName = cellNum.getStringCellValue()+ranNum;*/
		      
		        //add excel data
		        prodPage.ProductName(prodName);
		        //driver.findElement(By.name("productname")).sendKeys(prdName);
		        
		        //save
		        prodPage.saveButton();
		        //driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		        
		        //Delete the data
		        prodPage.delete();
		        //driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		        
		        //Alert popup
		        Alert a=driver.switchTo().alert();
				Thread.sleep(2000);
				a.accept();
		      
				 
				 //logout
				 // home.logout(driver);
			      // driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			      // driver.findElement(By.linkText("Sign Out")).click();
			    	
	}

}
