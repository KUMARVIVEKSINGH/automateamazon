package amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import amazon.constants.AmazonConstants;

public abstract class AbstractPage {

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitFor(ExpectedCondition<WebElement> expectedCondition) {
		WebDriverWait wd = new WebDriverWait(driver, AmazonConstants.EXPLICIT_WAIT);
		wd.until(expectedCondition);
	}

}
