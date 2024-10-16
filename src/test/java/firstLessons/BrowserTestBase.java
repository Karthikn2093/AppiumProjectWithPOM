package firstLessons;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BrowserTestBase {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;


	@BeforeClass
	public void configureBroswer() throws MalformedURLException {

		 service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C:\\Users\\Karthik\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 4a");
		options.setChromedriverExecutable("C:\\Users\\Karthik\\eclipse-workspace\\AppiumProject\\src\\test\\java\\resources\\chromedriver.exe");
		options.setCapability("browserName", "Chrome");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() {

		driver.quit();
		service.stop();

	}

}
