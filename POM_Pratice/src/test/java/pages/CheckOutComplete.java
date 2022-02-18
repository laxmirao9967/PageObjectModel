package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutComplete {


	WebDriver driver;
	
	By checkoutcomplete=By.name("back-to-products");
	By checkoutcompletetext=By.xpath("//span[@class='title' and text()='Checkout: Complete!']");
	
	public CheckOutComplete(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement checkoutcompletetext()
	{
		return driver.findElement(checkoutcompletetext);
		
	}
	
	public void checkoutcomplete()
	{
		driver.findElement(checkoutcomplete).click();
		
	}
}
