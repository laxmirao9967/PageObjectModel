package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutInfo {
	
	WebDriver driver;
	By CheckoutInfo=By.xpath("//span[@class='title' and text()='Checkout: Your Information']");
	By firstname=By.id("first-name");
	By lastname=By.name("lastName");
	By postalcode=By.id("postal-code");
	By continuebtn=By.id("continue");
	
	
	
	public CheckoutInfo(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public WebElement CheckoutInfoPresent()
	{
		
		return driver.findElement(CheckoutInfo);
		
	}

	
	public void Checkout_firstName(String text)
	{
		
		driver.findElement(firstname).sendKeys(text);
		
	}

	public void Checkout_lastName(String text)
	{
		
		driver.findElement(lastname).sendKeys(text);
		
	}

	
	public void Checkout_Zipcode(String text)
	{
		
		driver.findElement(postalcode).sendKeys(text);;
		
	}

	
	public void ContinueBtn()
	{
		driver.findElement(continuebtn).click();;
		
	}
	
}
