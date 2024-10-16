package generalApp;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Test4 extends BaseClass {
	
	@Test
	public void test4() throws Exception {
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("android:id/text1")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"Algeria\"));"));
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Algeria']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ajsakz");
		
		driver.hideKeyboard();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		
		int size = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for (int i = 0; i < size; i++) {
			
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(productName.equalsIgnoreCase("Jordan 6 Rings")) {
				
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
			
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(2000);
		
		//longClickGesture(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
		
		driver.findElement(By.id("android:id/button1")).click();
		
		driver.findElement(By.className("android.widget.CheckBox")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		Thread.sleep(6000);
		
		driver.getContextHandles();
		driver.context("WEBVIEW_com.androidsample.generalstore");
		
		driver.findElement(By.name("q")).sendKeys("asasda");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
		
		
	}

}
