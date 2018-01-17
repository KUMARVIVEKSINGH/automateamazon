package amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentPage extends AbstractPage {

	@FindBy(how = How.CSS, using = "#new-payment-methods")
	private WebElement paymentMethods;
	
	

	public PaymentPage(WebDriver driver){
		super(driver);
	}

	public boolean isPaymentMethodsDisplayed() {
		waitFor(ExpectedConditions.visibilityOf(paymentMethods));
		return paymentMethods.isDisplayed();
	}
	
	

}
