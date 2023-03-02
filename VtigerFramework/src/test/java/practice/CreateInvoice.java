package practice;

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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Property_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateInvoice {

	public static void main(String[] args) throws Throwable
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
	       driver.manage().window().maximize();
	       
		//Fetching data from property_file
	    String URL = plib.getKeyValue("url");
		String USERNAME = plib.getKeyValue("username");
		String PASSWORD = plib.getKeyValue("password");
        
        //Login to Vtiger application
		driver.get(URL);
        driver.findElement(By.name("user_name")).sendKeys("admin");
        driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();
        
        //RandomClass
        Random ran=new Random();
        int ranNum= ran.nextInt(1000);
        
        //Add Contact
        driver.findElement(By.linkText("Contacts")).click();
        driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
        
        //Fetching data from excel sheet
        FileInputStream fes=new FileInputStream("./src/test/resources/ExcelFeb.xlsx");
        Workbook book = WorkbookFactory.create(fes);
        Sheet sheetName = book.getSheet("Contact");
        Row rowNum = sheetName.getRow(0);
        Cell cellNum = rowNum.getCell(0);
        String conName = cellNum.getStringCellValue()+ranNum;
        driver.findElement(By.name("firstname")).sendKeys(conName);
        driver.findElement(By.name("lastname")).sendKeys(conName);
        
        //save
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        Thread.sleep(2000);
        
        //Go to More
        driver.findElement(By.linkText("More")).click();
        driver.findElement(By.linkText("Invoice")).click();
        driver.findElement(By.xpath("//img[@alt='Create Invoice...']")).click();
        
        driver.findElement(By.xpath("//img[@onclick='selectContact(\"false\",\"general\",document.EditView)']")).click();        
        //Switching Window
        Set<String> allid = driver.getWindowHandles();
        Iterator<String> it = allid.iterator();
        while(it.hasNext()) 
        {
        	String wid = it.next();
        	driver.switchTo().window(wid);
        	String title = driver.getTitle();
        	if(title.contains("Contacts&action"))
        	{
        		break;
        	}	
        }
        
        driver.findElement(By.name("search_text")).sendKeys(conName);
        driver.findElement(By.xpath("//input[@name='search']")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//a[text()='Rosa967 Rosa967']")).click();
        //Alert popup
        Alert a=driver.switchTo().alert();
		Thread.sleep(2000);
		a.accept();
        
        Thread.sleep(2000);
        Set<String> allid1=driver.getWindowHandles();
        Iterator<String> it1 = allid1.iterator();
         while(it1.hasNext())
        {
        	String wid1 = it1.next();
        	driver.switchTo().window(wid1);
        	String title1=driver.getTitle();
        	if(title1.contains("Invoice&action"))
        	{
        		break;
        	}
        }
         System.out.println(driver.getTitle());
         
         
       //Fetching data from excel sheet
         FileInputStream fess=new FileInputStream("./src/test/resources/ExcelFeb.xlsx");
         Workbook book1 = WorkbookFactory.create(fess);
         Sheet sheetName1 = book1.getSheet("Subject");
         Row rowNum1 = sheetName1.getRow(0);
         Cell cellNum1 = rowNum1.getCell(0);
         String sub = cellNum1.getStringCellValue()+ranNum;
        
         driver.findElement(By.name("subject")).sendKeys(sub);
         
         
         //save
           driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
           
          //signout
          Thread.sleep(2000);
          driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
          driver.findElement(By.linkText("Sign Out")).click();
       	
        
        

	}

}//driver.findElement(By.xpath("//img[@onclick='selectSalesOrder();']")).click();
