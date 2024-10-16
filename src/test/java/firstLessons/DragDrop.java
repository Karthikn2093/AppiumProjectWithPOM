package firstLessons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragDrop extends BaseClass{
	
	@Test
	public void dragDrop() throws Exception {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		
		WebElement dragElement = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		WebElement dropElement = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) dragElement).getId(),
			    "endX", 638,
			    "endY", 662
			));
		
		Assert.assertEquals(driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).isDisplayed(), true);
		
		Thread.sleep(3000);
		
	}

}
