package test;

import java.awt.RenderingHints.Key;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.SauceLoginPage;
import pages.MenuPage;
import pages.ProductsPage;
import pages.ShoppingCart;
import pages.CheckOutComplete;
import pages.CheckoutInfo;
import pages.Checkoutoverview;
import pages.CheckOutComplete;

public class SauceSetup {
	
	Properties prop;
	WebDriver driver;
	
	SauceLoginPage objsauceloginpage;
	MenuPage objMenuPage;
	ProductsPage objProductPages;
	ShoppingCart objShoppingCart;
	CheckoutInfo objcheckoutinfo;
	Checkoutoverview objCheckoutoverview;
	CheckOutComplete objCheckOutComplete;
	
	@BeforeTest
	public void setup() throws IOException
	{
		FileInputStream fi=new FileInputStream("C:\\Users\\laxmisrinivas.tanav\\eclipse-workspace\\POM_Pratice\\src\\test\\java\\config\\config.properties");
		prop = new Properties();
		prop.load(fi);
		String browserName= prop.getProperty("browser");
		String driverpath= prop.getProperty("driver_path");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", driverpath);
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", driverpath);
			driver=new FirefoxDriver();
		}else 
		{
			System.setProperty("webdriver.ie.driver", driverpath);
			driver=new InternetExplorerDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	//standard_user 
	
	@Test(priority=0)
	public void loginpage()
	{
		Assert.assertEquals("Swag Labs", driver.getTitle());
		objsauceloginpage = new SauceLoginPage(driver);
		objsauceloginpage.username("standard_user");
		objsauceloginpage.password("secret_sauce");
		objsauceloginpage.login_button();
	}
	
	@Test(priority=1)
	public void Menubtn()
	{
		objMenuPage = new MenuPage(driver);
		WebElement text=objMenuPage.istextPresent();
		boolean result=text.isDisplayed();
		Assert.assertTrue(result);
		objMenuPage.clickMenubtn();	
		objMenuPage.clickAbtUs();
		driver.navigate().back();
	}
	
	
	@Test(priority=2)
	public void ProductsPage() 
	{
		objProductPages=new ProductsPage(driver);
		WebElement cart=objProductPages.isShoppingCartLinkPresent();
		boolean cartresult=cart.isDisplayed();
		Assert.assertTrue(cartresult);
		objProductPages.AddBackPack();
		objProductPages.AddBikeLight();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0,200)");
		
		objProductPages.AddJacket();
		
		js.executeScript("scroll(0, -250)");
	}
	
	
	@Test(priority=3)
	public void ShoppingCart()
	{
		objShoppingCart=new ShoppingCart(driver);
		WebElement total_cart=objShoppingCart.totalcartPresent();
		boolean total_cart_result=total_cart.isDisplayed();
		Assert.assertTrue(total_cart_result);
		
		objShoppingCart.clickcart();
		objShoppingCart.Removefromcart();
		
		WebElement recent_cart=objShoppingCart.recentcartPresent();
		boolean recent_total_cart=recent_cart.isDisplayed();
		Assert.assertTrue(recent_total_cart);
		
		objShoppingCart.checkout();
	}
	
	@Test(priority=4)
	public void CheckoutInformation()
	{
		objcheckoutinfo=new CheckoutInfo(driver);
		WebElement checkinfo=objcheckoutinfo.CheckoutInfoPresent();
		boolean result_check=checkinfo.isDisplayed();
		Assert.assertTrue(result_check);
		
		objcheckoutinfo.Checkout_firstName("ABC");
		objcheckoutinfo.Checkout_lastName("PQR");
		objcheckoutinfo.Checkout_Zipcode("399323");
		objcheckoutinfo.ContinueBtn();
	
	}
	
	@Test(priority=5)
	public void CheckoutOverview()
	{
		objCheckoutoverview=new Checkoutoverview(driver);
		
		WebElement checkout_overview=objCheckoutoverview.CheckoutOverviewPresent();
		boolean result_overview=checkout_overview.isDisplayed();
		Assert.assertTrue(result_overview);
		
		objCheckoutoverview.finishBtn();
		
	}
	
	
	@Test(priority=6)
	public void CheckoutComplete()
	{
		objCheckOutComplete=new CheckOutComplete(driver);
		WebElement checkout_complete=objCheckOutComplete.checkoutcompletetext();
		boolean result_complete=checkout_complete.isDisplayed();
		Assert.assertTrue(result_complete);
		
		objCheckOutComplete.checkoutcomplete();
		
	}
	
	@Test(priority=7)
	public void logout()
	{
		WebElement text=objMenuPage.istextPresent();
		boolean result=text.isDisplayed();
		Assert.assertTrue(result);
		
		objMenuPage.clickMenubtn();
		objMenuPage.clicklogout();
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	

}
