package webdrivertests.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HeaderMenu {
	public void clickProfileLink (WebDriver driver) {
		WebElement Profile = driver.findElement(By.id("nav-link-profile"));
		Profile.click();
		
	}
	
	public void clickNewPostLink (WebDriver driver) {
		WebElement newPostLink = driver.findElement(By.id("nav-link-new-post"));
		newPostLink.click();
	}

}
