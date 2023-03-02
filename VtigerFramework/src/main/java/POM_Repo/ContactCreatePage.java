package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactCreatePage 
{
	public ContactCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement PlusImg;
	
	@FindBy(name="lastname")
	private WebElement conLastName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	@FindBy(name="mobile")
	private WebElement MobileNo;
	
	@FindBy(name="firstname")
	private WebElement conFirstName;

	//getter methods
	public WebElement getPlusImg() {
		return PlusImg;
	}

	public WebElement getConLastName() {
		return conLastName;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public WebElement getMobileNo() {
		return MobileNo;
	}


	public WebElement getConFirstName() {
		return conFirstName;
	}

	//Business logic for +img
		public void clickContact()
		{
			PlusImg.click();	
		}
		
	//Business logic for ContactLastName
		public void ContactLastName(String contactLastName)
		{
			conLastName.sendKeys(contactLastName);
		}
		
	//Business logic for save
			public void saveButton()
			{
				SaveButton.click();	
			}
	//Business logic for save
			public void mobileNo()
			{
				MobileNo.click();	
			}

     //Business logic for  ContactFirstName 
			public void ContactFirstName(String contactFirstName)
			{
				conFirstName.sendKeys(contactFirstName);
			}
			

}
