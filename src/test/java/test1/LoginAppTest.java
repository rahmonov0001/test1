package test1;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import resources.Base;
import resources.ExcelUtils;

public class LoginAppTest extends Base {

	public WebDriver driver;
	HomePage hp;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void loginAppValidation(String username, String password) throws IOException, InterruptedException {
		hp = new HomePage(driver);
		LoginPage lp = hp.getLogin();
		lp.getUsername().sendKeys(username);
		lp.getSubmit().click();
		lp.getPassword().sendKeys(password);
		lp.getSubmit().click();
		Thread.sleep(4000);
		Assert.assertEquals(driver.getCurrentUrl(), hp.getHomePageUrl());
	}

	@DataProvider
	public Object[][] getData() throws Exception {
		Object[][] testObjArray = ExcelUtils.getTableArray("TestData.xlsx", "Sheet1");
		return testObjArray;
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}