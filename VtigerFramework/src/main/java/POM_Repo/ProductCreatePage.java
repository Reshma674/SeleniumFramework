package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreatePage 
{
	public ProductCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement PlusImg;
	
	@FindBy(name="productname")
	private WebElement ProdName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveButton;
	
	@FindBy(name="search_text")
	private WebElement SearchText;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement Search;
	
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement Delete;
    
	
	//getter methods
	public WebElement getPlusImg() {
		return PlusImg;
	}

	public WebElement getProdName() {
		return ProdName;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	public WebElement getSearchText() {
		return SearchText;
	}
	
	public WebElement getSearch() {
		return Search;
	}

	public WebElement getDelete() {
		return Delete;
	}

	//Business logic for +img
		public void clickProduct()
		{
			PlusImg.click();	
		}
		
		//Business logic for ProdName
		public void ProductName(String prodName)
		{
			ProdName.sendKeys(prodName);
		}
		
		//Business logic for save
			public void saveButton()
			{
				SaveButton.click();	
			}
		//Business logic for SearchText
			public void SearchText(String prdName)
			{
				SearchText.sendKeys(prdName);;
			}
        //Business logic for Search
			public void search()
			{
				Search.click();
			}
		 //Business logic for Search
			public void delete()
			{
				Delete.click();
			}



}
