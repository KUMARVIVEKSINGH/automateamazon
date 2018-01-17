package amazon.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage extends AbstractPage {

	@FindBy(how = How.CSS, using = "#variation_size_name button span")
	private List<WebElement> buttonVariations;
	
	@FindBy(how = How.CSS, using = "#priceblock_ourprice")
	private WebElement price;
	
	@FindBy(how = How.CSS, using = "#regularprice_savings td.a-span12")
	private WebElement discount;
	
	@FindBy(how = How.CSS, using = "#quantity")
	private WebElement selectQuantity;
	
	@FindBy(how = How.CSS, using = "#add-to-cart-button")
	private WebElement buttonAddToCart;
	
	@FindBy(how = How.CSS, using = "#siNoCoverage-announce")
	private WebElement buttonSiNoCoverageAnnounce;

	public ProductDetailsPage(WebDriver driver){
		super(driver);
	}



	public void selectCapacity(String capacity) {
		for(WebElement ele:buttonVariations){
			if(ele.getText().equals(capacity)){
				ele.click();
				return;
			}
		}
	}



	public String getPrice() {
		return price.getText();
	}

	
	public String getDiscount() {
		return discount.getText();
	}



	public void selectQuantity(String quantity) {
		new Select(selectQuantity).selectByVisibleText(quantity);
		selectQuantity.sendKeys(Keys.TAB);
	}



	public void clickAddToCart() {
		buttonAddToCart.click();
		waitFor(ExpectedConditions.visibilityOf(buttonSiNoCoverageAnnounce));
		buttonSiNoCoverageAnnounce.click();
	}
	
	
	
}
