package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pages.utils.AndroidActions;

public class HomePage extends AndroidActions{
	
	public AndroidDriver driver;
	
	public HomePage(AndroidDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text ='Female']")
	private WebElement femaleGender;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text ='Male']")
	private WebElement maleGender;
	
	@AndroidFindBy(id = "android:id/text1")
	private WebElement countryField;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement submitButton;
	
	public HomePage setName(String name) throws Exception {
		Thread.sleep(3000);
		nameField.sendKeys(name);
		driver.hideKeyboard();
		return this;
	}
	
	public HomePage clickGender(String gender) {
		if(gender.equalsIgnoreCase("Male")) {
			maleGender.click();
		}else if(gender.equalsIgnoreCase("Female")) {
			femaleGender.click();
		}
		return this;
	}
	
	public HomePage setCountry(String country) {
		countryField.click();
		scrollToText(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+country+"']")).click();
		return this;
	}
	
	public ProductPage clickSubmitButton() throws InterruptedException {
		submitButton.click();
		Thread.sleep(3000);
		return new ProductPage(driver);
	}

}
