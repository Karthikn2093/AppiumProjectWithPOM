package generalApp;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TestCase1 extends BaseClass {
	
	@Test(enabled=false)
	public void test1() throws Exception {
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("android:id/text1")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"Chile\"));"));
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Chile']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ajsakz");
		
		driver.hideKeyboard();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	}
	
	@Test
	
	public void test2() throws InterruptedException {
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		
		
		Assert.assertEquals(driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name"), "Please enter your name");
		
	}

}
