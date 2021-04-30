package webdrivertests.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class JUnitTests {

	WebDriver driver;

	@Test
	void SuccessfullLogin() {
		Helper.navigateToPage(driver, "http://training.skillo-bg.com:4300/posts/all");

		LoginPage loginPage = new LoginPage();
		loginPage.login(driver, "xmas", "Christmas1");

		HeaderMenu headerMenu = new HeaderMenu();
		headerMenu.clickProfileLink(driver);

		ProfilePage profile = new ProfilePage();
		Assertions.assertTrue(profile.checkProfileName(driver, "xmas"));
		Assertions.assertEquals("xmas", profile.checkProfileName(driver, "xmas"));

	}

	@Test
	void newPostFromHeaderMenu() {

		Helper.navigateToPage(driver, "http://training.skillo-bg.com:4300/posts/all");

		LoginPage loginPage = new LoginPage();
		loginPage.login(driver, "xmas", "Christmas1");

		HeaderMenu headerMenu2 = new HeaderMenu();
		headerMenu2.clickNewPostLink(driver);

		WebElement postText = driver.findElement(By.xpath("//h3[contains(text(), Post a picture to share with your awesome followers "));
		Assertions.assertTrue(postText.isDisplayed());
		Assertions.assertEquals("Post a picture to share with your awesome follower", postText.getText());
		
		WebElement dropAnImage = driver.findElement(By.xpath("//label[contains(text(),'Drop an Image here')]"));
		Assertions.assertEquals("Drop an Image here", dropAnImage.getText());
		Assertions.assertTrue(dropAnImage.isDisplayed());

		WebElement createPostButton = driver.findElement(By.id("create-post"));
		Assertions.assertTrue(createPostButton.isDisplayed());
		Assertions.assertTrue(createPostButton.isEnabled());

	}

	@BeforeEach
	void test() {
		System.setProperty("webdriver.chrome.driver", "/Users/ivelinastoyanova/Desktop/untitled folder/chromedriver 2");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	@AfterEach
	void cleanUp() {
		driver.close();
	}

}