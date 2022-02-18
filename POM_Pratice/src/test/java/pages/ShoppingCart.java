package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCart {
	
	WebDriver driver;
	By totalcart=By.xpath("//span[@class='shopping_cart_badge' and text()='3']");
	By clickcart=By.xpath("//a[@class='shopping_cart_link']");
	By removeFromcart=By.name("remove-sauce-labs-fleece-jacket");
	By recentCartPresent=By.xpath("//span[@class='shopping_cart_badge' and text()='2']");
	By checkout=By.id("checkout");
	
	public ShoppingCart(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public WebElement totalcartPresent()
	{
		return driver.findElement(totalcart);
		
	}
	
	public void clickcart()
	{
		driver.findElement(clickcart).click();
		
	}
	
	public void Removefromcart()
	{
		driver.findElement(removeFromcart).click();
		
	}
	
	public WebElement recentcartPresent()
	{
	    return driver.findElement(recentCartPresent);
		
	}
	public void checkout()
	{
		driver.findElement(checkout).click();
		
	}

}
