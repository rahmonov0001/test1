package test1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import resources.Base;

public class SearchVoiceTest extends Base {

	public WebDriver driver;
	HomePage hp;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void keyboardValidation()
			throws InterruptedException, IOException, UnsupportedAudioFileException, LineUnavailableException {
		hp = new HomePage(driver);
		hp.getVoiceSearch().click();
		Thread.sleep(2000);
		File file = new File("planeta.wav");
		AudioInputStream music = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(music);
		clip.start();
		
	  /*Scanner scan = new Scanner(System.in);
		scan.nextLine();
		scan.close();*/
	}

	@AfterTest
	public void teardown() throws InterruptedException {
		driver.close();
	}
}
