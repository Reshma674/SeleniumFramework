package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page
{
	public Login_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(name="user_name")
	private WebElement usertextField;
	
	@FindBy(name="user_password")
	private WebElement passwordtextField;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;

	public WebElement getUsertextfElement() {
		return usertextField;
	}

	public WebElement getPasswordtextfElement() {
		return passwordtextField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	//Bussiness Logics
	public void loginToApp(String username,String password)
	{
		usertextField.sendKeys(username);
		passwordtextField.sendKeys(password);
		submitButton.click();
	}

	

}
