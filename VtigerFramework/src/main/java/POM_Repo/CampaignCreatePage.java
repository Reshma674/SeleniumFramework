package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignCreatePage 
{
	public CampaignCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement PlusImg;
	
	@FindBy(name="campaignname")
	private WebElement CampName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement Select;
	
	//getter methods
	public WebElement getSelect() {
		return Select;
	}

	public WebElement getPlusImg() {
		return PlusImg;
	}

	public WebElement getCampName() {
		return CampName;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	//Business logic for +img
		public void clickCampaign()
		{
			PlusImg.click();	
		}
		
	//Business logic for campName
		public void CampaignName(String campName)
		{
			CampName.sendKeys(campName);;	
		}
	//Business logic for save
		public void saveButton() 
		{
			SaveButton.click();	
		}
	//Business logic for Select
		public void select()
		{
			Select.click();
		}
	
}
