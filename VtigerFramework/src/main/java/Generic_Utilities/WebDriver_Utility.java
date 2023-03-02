package Generic_Utilities;

import java.awt.Desktop.Action;
import java.sql.Date;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility 
{
	/**
	 * wait for page to load before identifying any synchronised element in DOM 
	 * @param driver
	 * @author Reshma
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**
	 * after every action it will for next action to perform
	 * @param driver
	 * @author Reshma
	 */
	public void scriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
	}
	/**
	 * used to wait for element  to be clickable in GUI and check for specific element for every 500 milliseconds
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @author Reshma
	 */
	/*public void waitForElementWithCustomTimeout(WebDriver driver,WebElement element,int pollingTime)
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}*/
	
	/**
	 * used to switch any window based on window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	
	public void switchToWindow(WebDriver driver,String partialWindowTitle)
	{
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			String title=driver.getTitle();
			if(title.contains(partialWindowTitle))
			{
				break;
			}
		}
	}
	/**
	 * used to switch to Alertwindow and Accept(click on ok button)
	 * @param driver
	 * @author Reshma
	 */
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * used to switch to Alertwindow And dismiss(click on cancle button) 
	 * @param driver
	 * @author Reshma
	 */
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();;
	}
	/**
	 * used to switch to frame window based on id and name attribute
	 * @param driver
	 * @param id_name_Attribute
	 * @author Reshma
	 */
	public void switchToFrame(WebDriver driver,String id_name_Attribute)
	{
		driver.switchTo().frame(id_name_Attribute);
	}
	/**
	 * used to select the value from the dropdown based on index
	 * @param element
	 * @param index
	 * @author Reshma
	 */
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * used to select the value from the dropdown based on index
	 * @param element
	 * @param index
	 * @author Reshma
	 */
	public void select(WebElement element,String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 *  used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 * @author Reshma
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	/**
	 * used to right click on specified element
	 * @param driver
	 * @param element
	 * @author Reshma
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void moveByOffSet(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}
	
	public String takeScreenShot(WebDriver driver,String methodName)
	{
		Date date=new Date(0);
		date.toString().replace(" ", " ").replace(":", "-");
		return null;
		
	}
	public void moveToElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}

}
