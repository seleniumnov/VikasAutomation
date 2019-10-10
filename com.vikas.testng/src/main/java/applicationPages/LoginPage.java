package applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automation.utilities.DriverInitialization;

public class LoginPage extends DriverInitialization {

	// public WebDriver driver;

	public LoginPage(WebDriver driver) {

		DriverInitialization.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// older version
	@FindBy(name = "username")
	private WebElement userName;

	public WebElement getUserName() {

		return userName;
	}

	@FindBy(how = How.NAME, using = "firstname")
	public WebElement userName1;

	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	public WebElement password;

	@FindBy(how = How.NAME, using = "submit")
	public WebElement signIn;

}
