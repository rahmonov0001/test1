package test1;

import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.DiskPage;
import pageobjects.HomePage;
import resources.Base;
import resources.ExcelUtils;

public class LoginDisklTest2 extends Base {

	public WebDriver driver;
	HomePage hp;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void loginMailValidation(String username, String password) throws IOException, InterruptedException {
		hp = new HomePage(driver);
		DiskPage dp = hp.getDisk();
		
		Iterator<String> it = driver.getWindowHandles().iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);
		
		Thread.sleep(2000);
		dp.getUsername().sendKeys(username);
		dp.getSubmit().click();
		dp.getPassword().sendKeys(password);
		dp.getSubmit().click();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl(), dp.getDiskPageUrl());
	}

	@DataProvider
	public Object[][] getData() throws Exception {
		Object[][] testObjArray = ExcelUtils.getTableArray("TestData.xlsx", "Sheet1");
		return testObjArray;
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}