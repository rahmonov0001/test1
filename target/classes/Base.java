package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		String pathOfDataProp = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(pathOfDataProp);
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
			options.setExperimentalOption("prefs", prefs);
			String pathOfChromedriver = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", pathOfChromedriver);
			if (browserName.contains("headless")) {
				options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		} else 
			if (browserName.equals("firefox")) {
			String pathOfFirefoxriver = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", pathOfFirefoxriver);
			driver = new FirefoxDriver();
		} else 
			if (browserName.equals("IE")) {
			String pathOfIEdriver = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", pathOfIEdriver);
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
}
