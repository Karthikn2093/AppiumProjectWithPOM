package generalApp;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Test1 extends BaseClass {
	
	
	  @Test 
	  public void test1() throws Exception {
	  
	  Thread.sleep(4000);
	  
	  driver.findElement(By.id("android:id/text1")).click();
	  
	  driver.findElement(AppiumBy.
	  androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"
	  ));
	  
	  driver.findElement(By.xpath("//android.widget.TextView[@text=\"Argentina\"]")
	  ).click();
	  
	  driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).
	  sendKeys("Wjaskas");
	  
	  driver.hideKeyboard();
	  
	  driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).
	  click(); }
	 
	
	@Test
	
	public void test2() throws Exception {
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		String message = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		
		Assert.assertEquals(message, "Please enter your name");
		
	}

}
