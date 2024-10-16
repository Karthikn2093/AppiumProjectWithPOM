package ApiumTut;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeMethod
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		
		 service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\Karthik\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("192.168.1.13").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 4a");
		options.setApp("C:\\Users\\Karthik\\eclipse-workspace\\AppiumProject\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		
		
		driver = new AndroidDriver(new URI("http://192.168.1.13:4723").toURL(),options);
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		service.stop();

		
	}
	
	public void longClickGesture(WebElement element) {
		
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "duration",2000
			));
		
	}
	
	public void swipeGesture(WebElement element, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "direction",direction,
			    "percent",0.75
			));
	}

}
