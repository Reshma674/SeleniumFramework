package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationCreatePage 
{
	public OrganisationCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement PlusImg;
	
	@FindBy(name="accountname")
	private WebElement OrgName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;

	//getetr methods
	public WebElement getPlusImg() {
		return PlusImg;
	}

	public WebElement getOrgName() {
		return OrgName;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	//Business logic for +img
	public void clickOrganisation()
	{
		PlusImg.click();	
	}
	
	//Business logic for orgName
	public void OrganisationName(String orgName)
	{
		OrgName.sendKeys(orgName);
	}
	
	//Business logic for save
		public void saveButton()
		{
			SaveButton.click();	
		}

}
