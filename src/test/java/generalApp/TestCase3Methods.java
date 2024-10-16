package generalApp;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;

public class TestCase3Methods extends BaseClass{
	
	@Test
	public void test3() throws Exception, Throwable {
		
		HomePage homePage = new HomePage(driver);
		homePage.setName("Name").clickGender("Female")
		.setCountry("Algeria").clickSubmitButton()
		.addProductsToCart().clickCart();
		CartPage cartPage = new CartPage(driver);
		double productSum = cartPage.getProductSum();
		Double totalAmountDisplayed = cartPage.getTotalAmountDisplayed();
		
		Assert.assertEquals(productSum, totalAmountDisplayed);
		
		
	}

}
