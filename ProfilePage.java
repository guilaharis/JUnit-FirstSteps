package webdrivertests.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
	public boolean checkProfileName (WebDriver driver, String username) {
	WebElement ProfileName = driver.findElement(By.xpath("//h2[contains(text()," + username + ")]"));
	if (ProfileName != null) {
		return true; } 
		else {
			return false; 
		}
	}
	
	public String getProfileNameText (WebDriver driver, String username) {
		WebElement ProfileName = driver.findElement(By.xpath("//h2[contains(text()," + username + ")]"));
		return ProfileName.getText(); 
		
		}
	
	

}
