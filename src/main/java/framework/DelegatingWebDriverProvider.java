package framework;

import org.openqa.selenium.WebDriver;


public abstract class DelegatingWebDriverProvider implements WebDriverProvider{
	protected ThreadLocal<WebDriver> delegate = new ThreadLocal<WebDriver>();

    public WebDriver get() {
        WebDriver webDriver = delegate.get();
        if (webDriver == null) {
            throw new DelegateWebDriverNotFound();
        }
        return webDriver;
    }

    public void end() {
        delegate.get().quit();
        delegate.remove();

    }

    @SuppressWarnings("serial")
    public static class DelegateWebDriverNotFound extends RuntimeException {
        public DelegateWebDriverNotFound() {
            super("WebDriver not initialized for this thread");
        }
    }
}
