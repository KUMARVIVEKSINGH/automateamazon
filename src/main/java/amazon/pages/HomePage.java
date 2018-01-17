package amazon.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage {

	
	@FindBy(how = How.CSS, using = "#nav-tools>#nav-link-accountList")
	private WebElement linkSignIn;
	
	@FindBy(how = How.CSS, using = "#twotabsearchtextbox")
	private WebElement inputSearch;
	
	@FindBy(how = How.CSS, using = "#nav-search-submit-text")
	private WebElement buttonSearch;

	@FindBy(how = How.CSS, using = "#nav-item-signout-sa")
	private WebElement buttonSignOut;

	public HomePage(WebDriver driver){
		super(driver);
	}

	public void open() {
		driver.get("http://www.amazon.com");
		driver.manage().window().maximize();
	}

	public void clickSignIn() {
		linkSignIn.click();
	}

	public void search(String productName) {
		waitFor(ExpectedConditions.visibilityOf(inputSearch));
		inputSearch.sendKeys(productName);
		inputSearch.sendKeys(Keys.ENTER);
	}

	public void clickLogout() {
		waitFor(ExpectedConditions.visibilityOf(linkSignIn));
		Action hover = new Actions(driver).moveToElement(linkSignIn).build();
		hover.perform();
		waitFor(ExpectedConditions.visibilityOf(buttonSignOut));
		buttonSignOut.click();

	}
	
}
