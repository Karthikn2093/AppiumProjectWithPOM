package firstLessons;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class BrowserTest extends BrowserTestBase{
	
	@Test
	public void test() {
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("asasda");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
	}

}
