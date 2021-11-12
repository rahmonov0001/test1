package pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		
	}
	private By login = By.xpath("//div[text()='Войти']");
	private By mail = By.xpath("//div[text()='Почта']");
	private By disk = By.xpath("//div[text()='Диск']");
	private By loginbar = By.cssSelector(".desk-notif-card__login-new-items");
	private By servicesbar = By.cssSelector(".services-new__list");
	private By weather = By.id("wd-wrapper-_weather-1");
	private By topnews = By.id("wd-wrapper-_topnews-1");
	private By searchBox = By.id("text");
	private By searchButton = By.cssSelector("button[type='submit']");
	private By sidebar = By.cssSelector(".sidebar-item-view__title");
	private By feedbar = By.cssSelector(".feed__row._items-count_1");
	private By keyboard = By.cssSelector(".b-ico.keyboard-loader__icon.b-ico-kbd");
	private By keypanel = By.cssSelector(".keyboard__key-m");
	private By options = By.xpath("//div[@role='option']/span");
	private By optionbutton = By.xpath("//td[@class='keyboard__row__cell']/div/div/div/span");
	private By voice = By.className("input__voice-search");
	
	public LoginPage getLogin() throws IOException {
		driver.findElement(login).click();
		return new LoginPage(driver);
	}
	public MailPage getMail() throws IOException {
		driver.findElement(mail).click();
		return new MailPage(driver);
	}
	public DiskPage getDisk() throws IOException {
		driver.findElement(disk).click();
		return new DiskPage(driver);
	}
	public WebElement getLoginBar() {
		return driver.findElement(loginbar);
	}
	public WebElement getWeather() {
		return driver.findElement(weather);
	}
	public WebElement getTopnews() {
		return driver.findElement(topnews);
	}
	public WebElement getServicesBar() {
		return driver.findElement(servicesbar);
	}
	public WebElement getSearchBox() {
		return driver.findElement(searchBox);
	}
	public WebElement getSearchButton() {
		return driver.findElement(searchButton);
	}
	public WebElement getKeyboard() {
		return driver.findElement(keyboard);
	}
	public WebElement getOptionButton() {
		return driver.findElement(optionbutton);
	}
	public WebElement getVoiceSearch() {
		return driver.findElement(voice);
	}
	public List<WebElement> getSideBarItem() {
		return driver.findElements(sidebar);
	}
	public List<WebElement> getFeedBar() {
		return driver.findElements(feedbar);
	}
	public List<WebElement> getKeyPanel() {
		return driver.findElements(keypanel);
	}
	public List<WebElement> getOptions() {
		return driver.findElements(options);
	}
	public String getHomePageUrl() {
		return driver.getCurrentUrl();
	}
}