package test1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import resources.Base;

public class SearchBoxTest extends Base {

	public WebDriver driver;
	HomePage hp;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void searchValidation() throws InterruptedException, IOException {
		hp = new HomePage(driver);
		String str = "planeta";
		hp.getSearchBox().sendKeys(str);
		Thread.sleep(1000);
		hp.getSearchButton().click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getTitle().contains(str));
	}

	@AfterTest
	public void teardown() throws InterruptedException {
		driver.close();
	}
}
