package amazon.pages;

import framework.WebDriverProvider;

public class PageFactory {
	private final WebDriverProvider webDriverProvider;

	public PageFactory(WebDriverProvider webDriverProvider) {
		this.webDriverProvider = webDriverProvider;
	}

	public HomePage newHomePage() {
		return new HomePage(webDriverProvider.get());
	}

	public SignInPage newSignInPage() {
		return new SignInPage(webDriverProvider.get());
	}

	public SearchResultsPage newSearchResultsPage() {
		return new SearchResultsPage(webDriverProvider.get());
	}
	
	public ProductDetailsPage newProductDetailsPage() {
		return new ProductDetailsPage(webDriverProvider.get());
	}

	public ShoppingCartPage newShoppingCartPage() {
		return new ShoppingCartPage(webDriverProvider.get());
	}

	public ShippingAddressPage newShippingAddressPage() {
		return new ShippingAddressPage(webDriverProvider.get());
	}

	public PaymentPage newPaymentPage() {
		return new PaymentPage(webDriverProvider.get());
	}

}
