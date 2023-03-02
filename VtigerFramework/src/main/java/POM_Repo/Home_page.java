package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page
{

	public Home_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement singoutImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	

	//Getter Methods
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}
	

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getSingoutImg() {
		return singoutImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	//Business logic for organization
	public void clickOrganization()
	{
		organizationLink.click();
	}
	
	//Business logic for product
		public void clickProduct()
		{
			productLink.click();
		}
	//Business logic for contact
		public void clickContact()
		{
			contactLink.click();
		}
	
	// Business logic for more
		public void clickMoreLink()
		{
			moreLink.click();
		}
		
	 //Business logic for campaign
		public void clickCampaign()
		{
			campaignLink.click();
		}
		
	 //Business logic for signoutImg
		public void clickSignoutImg()
		{
			singoutImg.click();
		}
	
	
	//Business logic for Signout
	public void logout(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.moveToElement(singoutImg).perform();
		signoutLink.click();
	}
}

