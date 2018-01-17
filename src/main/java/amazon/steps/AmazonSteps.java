package amazon.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import amazon.constants.AmazonConstants;
import amazon.pages.HomePage;
import amazon.pages.PageFactory;
import amazon.pages.PaymentPage;
import amazon.pages.ProductDetailsPage;
import amazon.pages.SearchResultsPage;
import amazon.pages.ShippingAddressPage;
import amazon.pages.ShoppingCartPage;
import amazon.pages.SignInPage;

public class AmazonSteps {
	private HomePage homePage;
	private SignInPage signInPage;
	private SearchResultsPage searchResultsPage;
	private ProductDetailsPage productDetailsPage;
	private ShoppingCartPage shoppingCartPage;
	private ShippingAddressPage shippingAddressPage;
	private PaymentPage paymentPage;

	public AmazonSteps(PageFactory pageFactory) {
		homePage = pageFactory.newHomePage();
		signInPage = pageFactory.newSignInPage();
		searchResultsPage=pageFactory.newSearchResultsPage();
		productDetailsPage=pageFactory.newProductDetailsPage();
		shoppingCartPage = pageFactory.newShoppingCartPage();
		shippingAddressPage = pageFactory.newShippingAddressPage();
		paymentPage = pageFactory.newPaymentPage();
	}

	@Given("I login to the amazon website")
	public void givenILoginToTheAmazonWebsite() {
		homePage.open();
		homePage.clickSignIn();
		signInPage.enterUserName(System.getProperty(AmazonConstants.USER_NAME));
		signInPage.enterPassword(System.getProperty(AmazonConstants.PASSWORD));
		signInPage.clickSignIn();
	}
	
	@When("I Click on Add to cart")
	public void whenIClickOnAddToCart(){
		productDetailsPage.clickAddToCart();
	}
	
	@Then("I can Look for payment options")
	public void thenICanLookForPaymentOptions(){
		shippingAddressPage.clickShipToThisAddress();
		shippingAddressPage.clickContinue();
		assertTrue(paymentPage.isPaymentMethodsDisplayed());
	}
	
	@Then("I can Logout")
	public void thenICanLogout(){
		homePage.open();
		homePage.clickLogout();
	}
	
	@Given("Search for a product <productName>")
	public void givenSearchForAProductproductName(@Named("productName") String productName){
		homePage.search(productName);
	}
	
	@Given("I click on the first record")
	public void givenIClickOnTheFirstRecord(){
		searchResultsPage.clickOnFirstRecord();
	}
	
	@When("I Click on proceed to checkout")
	public void whenIClickOnProceedToCheckout(){
		shoppingCartPage.clickProceedToCheckout();
	}
	
	@Then("I can View the product details <price> and <discount>")
	public void thenICanViewTheProductDetailspriceAndcolour(@Named("price") String price, @Named("discount") String discount){
		assertEquals(price, productDetailsPage.getPrice());
		assertEquals(discount, productDetailsPage.getDiscount());
	}
	
	@When("I Select <quantity>")
	public void whenISelectquantity(@Named("quantity") String quantity){
		productDetailsPage.selectQuantity(quantity);
	}
	
	@When("I select capacity <capacity>")
	public void whenISelectCapacitycapacity(@Named("capacity") String capacity){
		productDetailsPage.selectCapacity(capacity);
	}
}
