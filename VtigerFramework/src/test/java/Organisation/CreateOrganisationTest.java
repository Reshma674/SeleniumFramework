package Organisation;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.Property_Utility;
import POM_Repo.Home_page;
import POM_Repo.Login_page;
import POM_Repo.OrganisationCreatePage;
import POM_Repo.Validation;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationTest extends BaseClass
{
   @Test(retryAnalyzer= Generic_Utilities.RetryAnalyser.class)
	//@Test(groups = "SmokeTest")
	public void createOrganisationTest() throws Throwable
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
				//WebDriver driver=new ChromeDriver();
		      
		       //To maximize the window
				//driver.manage().window().maximize();
				
		        //Fetching data from property_file
				/*String URL = plib.getKeyValue("url");
				String USERNAME = plib.getKeyValue("username");
				String PASSWORD = plib.getKeyValue("password");*/
				/*FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties.txt");
		        Properties pro=new Properties();
		        pro.load(fis);
		        String URL = pro.getProperty("url");
		        String USERNAME = pro.getProperty("username");
		        String PASSWORD = pro.getProperty("password");
		        
		        //Login to Vtiger application
				driver.get(URL);
				Login_page login=new Login_page(driver);
				login.loginToApp(USERNAME, PASSWORD);
		        /*driver.findElement(By.name("user_name")).sendKeys("admin");
		        driver.findElement(By.name("user_password")).sendKeys("admin");
		        driver.findElement(By.id("submitButton")).click();  */
				
				//Go to Home Page
				Home_page home=new Home_page(driver);
				Assert.assertEquals(false, true);
				//click the tab
				home.clickOrganization();
		        //driver.findElement(By.linkText("Organizations")).click();
				
				//To Create Organisation
				OrganisationCreatePage orgPage=new OrganisationCreatePage(driver);
				orgPage.clickOrganisation();
		       // driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		     
		      //RandomClass for avoiding duplicates
		        Java_Utility jlib=new Java_Utility();
		        int ranNum = jlib.getRandomNum();
		       // Random ran=new Random();
		       // int ranNum = ran.nextInt(1000);
		        
		        //Fetching data from excel sheet
		        Excel_Utility elib=new Excel_Utility();
		        String orgName = elib.getExcelData("Organisation", 0, 0)+ranNum;
		        
		        /*FileInputStream fes=new FileInputStream("./src/test/resources/ExcelFeb.xlsx");
		        Workbook book = WorkbookFactory.create(fes);
		        Sheet sheetName = book.getSheet("Organisation");
		        Row rowNum = sheetName.getRow(0);
		        Cell cellNum = rowNum.getCell(0);
		        String orgName = cellNum.getStringCellValue()+ranNum;*/
		        
		        //add excel data
		        orgPage.OrganisationName(orgName);
		       // driver.findElement(By.name("accountname")).sendKeys(orgName);
		        
		        //save
		        orgPage.saveButton();
		       // driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		      
		       Thread.sleep(2000);
		      /* driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		       driver.findElement(By.linkText("Sign Out")).click();*/
		       
		       //For Validation
		      //String actData = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		     // String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		       Validation val=new Validation(driver);
		       String actData = val.orgValidate(driver, orgName);
		      //HardAssert
		      Assert.assertEquals(orgName, actData);
		     /* if(actData.contains(orgName))
		      {
		    	  System.out.println("PASS");
		      }
		      else
		      {
		    	  System.out.println("FAIL");  
		      }*/
		      Thread.sleep(2000);
		      //logout
		      //home.logout(driver);
		    	
			 }
	/*@Test
	public void m1()
	{
		System.out.println("m1 running");
	}*/


	}

