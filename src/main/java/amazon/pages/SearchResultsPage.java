package amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultsPage extends AbstractPage {

	@FindBy(how = How.CSS, using = "#result_0 .s-access-detail-page")
	private WebElement linkFirstResult;
	
	

	public SearchResultsPage(WebDriver driver){
		super(driver);
	}

	public void clickOnFirstRecord() {
		waitFor(ExpectedConditions.visibilityOf(linkFirstResult));
		linkFirstResult.click();
	}

	
	
}
