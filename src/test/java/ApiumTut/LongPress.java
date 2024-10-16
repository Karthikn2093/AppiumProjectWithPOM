package ApiumTut;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseClass {
	
	@Test
	public void longPress() {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		WebElement elementToHold = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
		
		//Long Click is defined in a method in Base class
		longClickGesture(elementToHold);
				
		Assert.assertTrue((driver.findElement(By.id("android:id/title")).isDisplayed()));
		
	}

}
