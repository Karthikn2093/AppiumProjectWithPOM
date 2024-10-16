package ApiumTut;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class MiscActions extends BaseClass{
	
	@Test
	public void swipeGesture() {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();

		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		
		driver.rotate(landscape);
}

}
