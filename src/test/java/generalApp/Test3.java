package generalApp;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Test3 extends BaseClass{
	
	@Test
	public void test3() throws Exception {
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("android:id/text1")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"Algeria\"));"));
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Algeria']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ajsakz");
		
		driver.hideKeyboard();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		List<WebElement> priceList = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productPrice']"));
		
		double sum = 0.0;
		
		for (WebElement webElement : priceList) {
			
			String priceText = webElement.getText();
			
			double price = Double.parseDouble(priceText.substring(1));
			
			sum += price;
			
		}
		
		System.out.println(sum);
		
		String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		
		double totalPrice = Double.parseDouble(total.substring(1));
		
		System.out.println(totalPrice);
		
		Assert.assertEquals(sum, totalPrice);
		
	}

}
