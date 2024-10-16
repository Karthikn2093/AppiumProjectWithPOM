package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pages.utils.AndroidActions;

public class GooglePage extends AndroidActions{
	
public AndroidDriver driver;
	
	private WebElement searchBox;
	
	public GooglePage(AndroidDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	public GooglePage getContextHandles() {
		
		driver.getContextHandles();
		driver.context("WEBVIEW_com.androidsample.generalstore");
		return this;
		
	}
	
	public GooglePage enterSearchTerm(String searchTerm) {
		
		searchBox.sendKeys(searchTerm + Keys.ENTER);
		return this;
		
	}
	
	public void pressBackKey() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	public void switchContext() {
		
		driver.context("NATIVE_APP");
		
	}

}
