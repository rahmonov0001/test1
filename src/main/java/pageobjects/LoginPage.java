package pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) throws IOException {
		this.driver = driver;
	}
	
	private By username = By.cssSelector("input[name='login']");
	private By submit = By.cssSelector("button[type='submit']");
	private By password = By.id("passp-field-passwd");
	
	public WebElement getUsername() throws IOException {
		return driver.findElement(username);
	}
	public WebElement getSubmit() throws IOException {
		return driver.findElement(submit);
	}
	public WebElement getPassword() throws IOException {
		return driver.findElement(password);
	}
}