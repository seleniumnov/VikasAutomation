package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automation.utilities.GenericMethods;
import com.automation.utilities.GlobalVariables;

public class LoginPage extends GenericMethods {
	
	
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//older version
	@FindBy(name="username")
	public WebElement userName;
	
	@FindBy(how=How.NAME,using = "username")
	public WebElement userName1;
	
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	public WebElement password;
	
	
	@FindBy(how=How.NAME,using = "submit")
	public WebElement signIn;

}
