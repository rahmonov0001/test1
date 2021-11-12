package test1;

import java.io.IOException;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.MailPage;
import resources.Base;
import resources.ExcelUtils;

public class LoginMailTest extends Base {

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
		MailPage mp = hp.getMail();
		
		Iterator<String> it = driver.getWindowHandles().iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);
		
		Thread.sleep(2000);
		mp.getUsername().sendKeys(username);
		mp.getSubmit().click();
		mp.getPassword().sendKeys(password);
		mp.getSubmit().click();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl(), mp.getMailPageUrl());
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