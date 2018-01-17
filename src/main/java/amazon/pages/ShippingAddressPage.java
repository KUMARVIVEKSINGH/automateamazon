package amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShippingAddressPage extends AbstractPage {

	@FindBy(how = How.CSS, using = ".ship-to-this-address a")
	private WebElement linkShipToThisAddress;
	
	
	@FindBy(how = How.CSS, using = "[value='Continue']")
	private WebElement buttonContinue;

	public ShippingAddressPage(WebDriver driver){
		super(driver);
	}

	public void clickShipToThisAddress() {
		waitFor(ExpectedConditions.visibilityOf(linkShipToThisAddress));
		linkShipToThisAddress.click();
	}

	public void clickContinue() {
		waitFor(ExpectedConditions.visibilityOf(buttonContinue));
		buttonContinue.click();
	}
	
	
}
