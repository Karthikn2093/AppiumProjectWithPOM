package ApiumTut;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;



public class ApiumBasics extends BaseClass {
	
	@Test
	public void appiumTest() throws Exception {
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		
		driver.findElement(By.id("android:id/checkbox")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]")).click();
		
		String actText = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(actText, "WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("WifiChar");
		
		driver.findElement(By.id("android:id/button1")).click();
		
		
		
	}
	
}
