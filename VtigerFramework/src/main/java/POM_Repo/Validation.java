package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validation
{
	public Validation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement validate;
	
	public WebElement getValidate()
	{
		return validate;
	  	
	}
	
	public String orgValidate(WebDriver driver,String actData)
	{
		String data=validate.getText();
		return data;
	}

}
