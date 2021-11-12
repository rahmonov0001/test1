package test1;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import resources.Base;
import resources.ExcelUtils;

public class HomePageTest extends Base {

	public WebDriver driver;
	HomePage hp;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void topNewsBarValidation() {
		hp = new HomePage(driver);
		Assert.assertTrue(hp.getTopnews().isDisplayed());
	}

	@Test
	public void weatherBarValidation() {
		hp = new HomePage(driver);
		Assert.assertTrue(hp.getWeather().isDisplayed());
	}

	@Test
	public void loginBarValidation() {
		hp = new HomePage(driver);
		Assert.assertTrue(hp.getLoginBar().isDisplayed());
	}

	@Test
	public void servicesBarValidation() {
		hp = new HomePage(driver);
		Assert.assertTrue(hp.getServicesBar().isDisplayed());
	}

	@Test
	public void emptySearchValidation() {
		hp = new HomePage(driver);
		hp.getSearchButton().click();
		Assert.assertEquals(driver.getCurrentUrl(), hp.getHomePageUrl());
	}

	@Test
	public void sideBarValidation() throws Exception {
		hp = new HomePage(driver);
		ArrayList<String> expectedItems = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			expectedItems.add(ExcelUtils.getItemData(i, 0));
		ArrayList<String> actualItems = new ArrayList<>();
		for (int i = 0; i < hp.getSideBarItem().size(); i++)
			actualItems.add(hp.getSideBarItem().get(i).getText());
		Assert.assertEquals(actualItems, expectedItems);
	}

	@Test
	public void feedBarValidation() throws Exception {
		hp = new HomePage(driver);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int count = hp.getFeedBar().size();
		jse.executeScript("window.scrollBy(0,650)");
		Thread.sleep(3000L);
		if (count >= 5)
			jse.executeScript("window.scrollBy(0,650)");
		else
			System.out.println("Feed bar does not increase");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	@AfterSuite
	public void quit() {
		driver.quit();
	}
}