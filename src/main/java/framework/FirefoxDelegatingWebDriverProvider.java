package framework;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDelegatingWebDriverProvider extends
		DelegatingWebDriverProvider {

	public void initialize() {
		delegate.set(new FirefoxDriver());
	}

}
