package ApiumTut;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class Assignment1 extends BaseClass {

	public void appClick() {

		driver.findElement(AppiumBy.accessibilityId("App")).click();

	}

	@Test(enabled = false)
	public void test1() {

		appClick();

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Alert Dialogs\"]")).click();

		driver.findElement(By.id("io.appium.android.apis:id/select_button")).click();

		List<WebElement> findElements = driver
				.findElements(By.xpath("android.widget.TextView[@resource-id='android:id/text1']"));

		for (WebElement webElement : findElements) {

			if (webElement.getText().equalsIgnoreCase("Command two")) {

				webElement.click();
			}

		}

	}

	@Test(enabled = false)
	public void test2() throws Exception {

		appClick();

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Alert Dialogs\"]")).click();

		driver.findElement(AppiumBy.accessibilityId("Single choice list")).click();

		Thread.sleep(3000);

		Assert.assertEquals(driver.findElement(By.className("android.widget.TextView")).getText(),
				"Single choice list");

		List<WebElement> singleChoiceList = driver.findElements(By.className("android.widget.CheckedTextView"));

		System.out.println(singleChoiceList);

		System.out.println("***************");

		for (WebElement webElement : singleChoiceList) {

			if (webElement.getText().equalsIgnoreCase("Traffic")) {

				System.out.println(webElement.getText());
				webElement.click();

			}

		}

		driver.findElement(By.id("android:id/button1")).click();

		Thread.sleep(3000);

	}

	@Test
	public void test3() throws Exception {

		Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.ApiDemos");

		((JavascriptExecutor) driver).executeScript("mobile: startActivity",
				ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.ApiDemos"));

	}

}
