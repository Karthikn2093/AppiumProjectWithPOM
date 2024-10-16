package pages.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {

	AndroidDriver driver;

	public AndroidActions(AndroidDriver driver) {
		this.driver = driver;
	}

	public void scrollToText(String textString) {
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\""+textString+"\"));"));

	}

	public void longClickGesture(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));

	}

	public Double getformattedAmount(String text) {
		
		Double price = Double.parseDouble(text.substring(1));
		return price;
	}
	
	public void webDriverWait() {
		
	}

}
