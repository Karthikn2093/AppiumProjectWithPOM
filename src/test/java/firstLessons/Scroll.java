package firstLessons;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class Scroll extends BaseClass {
	
	//@Test
	public void scrollTest() {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		  boolean canScrollMore = (Boolean) ((JavascriptExecutor)
		  driver).executeScript("mobile: scrollGesture", ImmutableMap.of( "left", 100,
		  "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0
		  ));
		 
		
	//	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Webview\"));"));
		
	}
	
	@Test
	public void scrollEnd() throws Exception {
		
		boolean canScrollMore;
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		do {
			
			canScrollMore = (Boolean) ((JavascriptExecutor)
					  driver).executeScript("mobile: scrollGesture", ImmutableMap.of( "left", 100,
					  "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0
					  ));
			
		}while(canScrollMore);
		
		Thread.sleep(3000);
	}

}
