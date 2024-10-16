package ApiumTut;


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
		
	}

}
