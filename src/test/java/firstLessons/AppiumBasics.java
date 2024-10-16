package firstLessons;


import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;


public class AppiumBasics extends BaseClass {
	
	@Test
	public void appiumTest() throws MalformedURLException{
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		
		driver.findElement(By.id("android:id/checkbox")).click();
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		String actual = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(actual, "WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("WifiCharacter");
		
		driver.findElement(By.id("android:id/button1")).click();
		
	}

}
