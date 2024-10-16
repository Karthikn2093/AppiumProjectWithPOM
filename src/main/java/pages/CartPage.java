package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pages.utils.AndroidActions;

public class CartPage extends AndroidActions {

	public AndroidDriver driver;

	double sum;

	public CartPage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']")
	public List<WebElement> productPrices;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement termsButton;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement button1;

	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement checkBox;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement proceedButton;

	public List<WebElement> getProductList() {

		return productPrices;

	}

	public double getProductSum() {

		for (WebElement webElement : productPrices) {

			String priceText = webElement.getText();

			double price = getformattedAmount(priceText);

			sum += price;

		}

		return sum;

	}

	public Double getTotalAmountDisplayed() {

		return getformattedAmount(totalAmount.getText());

	}

	public CartPage longClickGestures() {

		longClickGesture(termsButton);
		return this;

	}

	public CartPage clickButton() {

		button1.click();
		return this;
	}

	public CartPage clickCheckBox() {

		checkBox.click();
		return this;
	}

	public GooglePage clickProceedButton() {

		proceedButton.click();
		return new GooglePage(driver);
	}

}
