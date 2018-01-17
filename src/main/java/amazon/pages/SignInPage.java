package amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends AbstractPage {

	
	@FindBy(how = How.CSS, using = "#nav-tools>#nav-link-accountList")
	private WebElement linkSignIn;

	@FindBy(how = How.CSS, using = "#ap_email")
	private WebElement inputUser;

	@FindBy(how = How.CSS, using = "#ap_password")
	private WebElement inputPassword;

	@FindBy(how = How.CSS, using = "#signInSubmit")
	private WebElement buttonSignIn;

	public SignInPage(WebDriver driver){
		super(driver);
	}

	public void enterUserName(String user) {
		waitFor(ExpectedConditions.visibilityOf(inputUser));
		inputUser.sendKeys(user);
	}

	public void enterPassword(String password) {
		inputPassword.sendKeys(password);
	}
	
	public void clickSignIn() {
		buttonSignIn.click();
	}

}
