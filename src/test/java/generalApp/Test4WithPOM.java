package generalApp;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pages.HomePage;

public class Test4WithPOM extends BaseClass {
	
	@Test
	public void test4() throws Exception {
		
		Thread.sleep(3000);
		

		HomePage homePage = new HomePage(driver);
		homePage.setName("Name").clickGender("Male")
		.setCountry("China").clickSubmitButton()
		.scrollToProduct("Jordan 6 Rings")
		.addProductToCart("Jordan 6 Rings")
		.clickCart()
		.longClickGestures().clickButton()
		.clickCheckBox()
		.clickProceedButton()
		.getContextHandles().enterSearchTerm("Hello")
		.pressBackKey();
		
		
		
	}

}
