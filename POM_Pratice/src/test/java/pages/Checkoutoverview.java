package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkoutoverview {

	WebDriver driver;
	By checkoutOverview=By.xpath("//span[@class='title' and text()='Checkout: Overview']");
	By finishbtn=By.id("finish");
	
	public Checkoutoverview(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement CheckoutOverviewPresent()
	{
		return driver.findElement(checkoutOverview);
	}
	
	public void finishBtn()
	{
		driver.findElement(finishbtn).click();
		
	}
}
