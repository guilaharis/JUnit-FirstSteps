package webdrivertests.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public void login (WebDriver driver, String username, String password) {
		WebElement loginLink = driver.findElement(By.id("nav-link-login"));
		loginLink.click();
		WebElement usernameField = driver.findElement(By.id("defaultLoginFormUsername"));
		usernameField.sendKeys(username);
		WebElement passwordField = driver.findElement(By.id("defaultLoginFormPassword"));
		passwordField.sendKeys(password);
		WebElement signIn = driver.findElement(By.id("sign-in-button"));
		signIn.click();
	}

}
