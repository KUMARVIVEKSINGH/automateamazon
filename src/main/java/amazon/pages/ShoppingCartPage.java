package amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends AbstractPage {

	@FindBy(how = How.CSS, using = "#hlb-ptc-btn-native")
	private WebElement linkProceedToCheckout;
	
	

	public ShoppingCartPage(WebDriver driver){
		super(driver);
	}

	public void clickProceedToCheckout() {
		waitFor(ExpectedConditions.visibilityOf(linkProceedToCheckout));
		linkProceedToCheckout.click();
	}
	
	
}
