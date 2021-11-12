package test1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import resources.Base;

public class SearchKeyboardTest extends Base {

	public WebDriver driver;
	HomePage hp;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void keyboardValidation() throws InterruptedException, IOException {
		hp = new HomePage(driver);
		hp.getKeyboard().click();
		Thread.sleep(1000);
		hp.getOptionButton().click();
		for(int i = 0; i < hp.getOptions().size(); i++) {
			if(hp.getOptions().get(i).getText().equalsIgnoreCase("English"))
				hp.getOptions().get(i).click();
		}
		String str = "planeta";
		String t = "";
		for (int i = 0; i < str.length(); i++) {
			t += str.charAt(i);
			for (int j = 0; j < hp.getKeyPanel().size(); j++) {
				if (hp.getKeyPanel().get(j).getText().equals(t)) {
					hp.getKeyPanel().get(j).click();
					t = "";
					break;
				}
			}
		}
		hp.getSearchButton().click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.getTitle().contains(str));
	}

	@AfterTest
	public void teardown() throws InterruptedException {
		driver.close();
	}
}
