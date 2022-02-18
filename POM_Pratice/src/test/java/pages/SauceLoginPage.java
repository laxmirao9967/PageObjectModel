package pages;

import javax.sql.rowset.WebRowSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SauceLoginPage {
	
	//static WebElement element = null;
	WebDriver driver=null;
	
	By username = By.id("user-name");
	By passowrd = By.id("password");
	By loginBtn = By.name("login-button");
	
	public SauceLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void username(String text) {
		
		driver.findElement(username).sendKeys(text);
	}
	
	public void password(String text) {
		
		driver.findElement(passowrd).sendKeys(text);;
		
	}
	
	public void login_button(){
		
		driver.findElement(loginBtn).click();
		
	}

}
