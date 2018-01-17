package framework;

import org.openqa.selenium.WebDriver;

public interface WebDriverProvider {

	WebDriver get();

    void initialize();

    void end();
}
