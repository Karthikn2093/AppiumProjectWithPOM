package generalApp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Test2 extends BaseClass {
	
	@Test
	public void test1() throws Exception {
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("android:id/text1")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"Algeria\"));"));
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Algeria']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ajsakz");
		
		driver.hideKeyboard();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		System.out.println(productCount);
		
		for (int i = 0; i < productCount; i++) {
			
			
			String name = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(name.equalsIgnoreCase("Jordan 6 Rings")) {
				
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				
			}
			
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		Assert.assertEquals(driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText(),"Jordan 6 Rings");
		
	}

}
