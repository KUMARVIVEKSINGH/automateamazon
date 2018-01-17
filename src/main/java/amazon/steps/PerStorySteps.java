package amazon.steps;

import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;

import framework.WebDriverProvider;


public class PerStorySteps {
	private WebDriverProvider webDriverProvider;
	
	 public PerStorySteps(WebDriverProvider driverProvider) {
	        this.webDriverProvider=driverProvider;
	    }

	    @BeforeStory
	    public void beforeStory() throws Exception {
	    	webDriverProvider.initialize();
	    }

	    @AfterStory
	    public void afterStory() throws Exception {
	    	webDriverProvider.end();
	    }
}
