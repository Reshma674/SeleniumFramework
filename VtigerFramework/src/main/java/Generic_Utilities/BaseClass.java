package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM_Repo.Home_page;
import POM_Repo.Login_page;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public  WebDriver driver;
	public static WebDriver sdriver;
	public Property_Utility plib=new Property_Utility();
	@BeforeSuite(groups= {"SmokeTest","RegressionTest"})
	public void BS()
	{
		System.out.println("Database Connection");
	}
	
	@BeforeTest(groups= {"SmokeTest","RegressionTest"})
	public void BT()
	{
		System.out.println("Parallel Execution");
	}
	//@Parameters("BROWSER")
    @BeforeClass(groups= {"SmokeTest","RegressionTest"})
	public void BC() throws Throwable
	{
	//public void BC(String BROWSER ) throws Throwable
	//{
		
		  // Property_Utility plib=new Property_Utility();
	       String BROWSER = plib.getKeyValue("Browser");
	       
	      // WebDriver driver;
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
		System.out.println("Launching Browser");
		sdriver=driver;
	}
	
	@BeforeMethod(groups= {"SmokeTest","RegressionTest"})
	public void BM() throws Throwable
	{
		//Fetching data from property_file
		Property_Utility plib=new Property_Utility();
	    String URL = plib.getKeyValue("url");
	    String USERNAME = plib.getKeyValue("username");
        String PASSWORD = plib.getKeyValue("password");
        /*FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties.txt");
        Properties pro=new Properties();
        pro.load(fis);
        String URL = pro.getProperty("url");
        String USERNAME = pro.getProperty("username");
        String PASSWORD = pro.getProperty("password");*/
        
        //Login to Vtiger application
        driver.get(URL);
		Login_page login=new Login_page(driver);
		login.loginToApp(USERNAME, PASSWORD);
		
	}
	
	@AfterMethod(groups= {"SmokeTest","RegressionTest"})
	public void AF() throws Throwable
	{
		Home_page home=new Home_page(driver);
		Thread.sleep(2000);
		home.logout(driver);
		System.out.println("Logout Application");
	}
	
	@AfterClass(groups= {"SmokeTest","RegressionTest"})
	public void AC()
	{
		driver.quit();
		System.out.println("Close the Browser");
	}
	
	@AfterTest(groups= {"SmokeTest","RegressionTest"})
	public void AT()
	{
		System.out.println("Parallel Execution Done");
	}
	
	@AfterSuite(groups= {"SmokeTest","RegressionTest"})
	public void AS()
	{
		System.out.println("Database Closed");
	}

}
