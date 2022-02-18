package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
	
	static WebElement element=null;
	WebDriver driver;
	
	By shoppingCartLink=By.xpath("//a[@class='shopping_cart_link']");
	By addBackPack=By.id("add-to-cart-sauce-labs-backpack");
	By addBikeLight=By.xpath("//button[@name='add-to-cart-sauce-labs-bike-light']");
	By addJacket=By.xpath("//button[@name='add-to-cart-sauce-labs-fleece-jacket']");
	
	
	public ProductsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement isShoppingCartLinkPresent()
	{
		return driver.findElement(shoppingCartLink);
	}
	
	public void AddBackPack()
	{
		driver.findElement(addBackPack).click();
	}
	
	public void AddBikeLight()
	{
		driver.findElement(addBikeLight).click();
	}

	public void AddJacket()
	{
		driver.findElement(addJacket).click();
	}
	
}
