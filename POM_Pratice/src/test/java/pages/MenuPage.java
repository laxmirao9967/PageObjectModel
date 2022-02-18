package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage {
	
	WebDriver driver=null;
	
	By menuBtn = By.id("react-burger-menu-btn");
	By abtUslink = By.id("about_sidebar_link");
	By clickLogout = By.xpath("//a[@id='logout_sidebar_link' and text()='Logout']");
	By textPresent = By.xpath("//span[@class='title' and text()='Products']");
	
	public MenuPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickMenubtn()
	{
		driver.findElement(menuBtn).click();
	}

	public void clickAbtUs()
	{
		driver.findElement(abtUslink).click();
	}
	
	public void clicklogout()
	{
		driver.findElement(clickLogout).click();
	}
	
	public WebElement istextPresent()
	{
		return driver.findElement(textPresent);
		
	}
	
}
