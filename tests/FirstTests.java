package com.github.ddecolli.pom.tests;
import com.github.ddecolli.pom.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class FirstTests{

	private WebDriver driver;
	private HomePage homePage;
	private String baseUrl;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		//for headless browser, phantom JS execution
//		File file = new File("C:/Program Files/test/phantomjs-1.9.7-windows/phantomjs.exe");
//        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
//        driver = new PhantomJSDriver();
//        baseUrl = "http://www.amazon.com/";
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@BeforeMethod(alwaysRun = true)
	public void openHomePage() {
		homePage = new HomePage(driver).open();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
/////////////////////////////////////////////////////
	@Test
	public void testAddingItemToCard() {
		//Open Homepage of Amazon
		SearchResultsPage searchResultsPage = homePage.navigationMenu()
				.searchFor("Boardgame", "dead of winter");
		String itemTitle = searchResultsPage.getFirstResultTitle();
		ProductDetailsPage productDetailsPage = searchResultsPage.clickFirstResultTitle();
		assert (productDetailsPage.getProductTitle()
				.equals(itemTitle));
		AddToCartConfirmPage addToCartConfirmPage = productDetailsPage.addToCart();
		assert (addToCartConfirmPage.getConfirmationText()
				.equals("1 item added to Cart"));
		CartPage cartPage = addToCartConfirmPage.navigationMenu()
				.navigateToCartPage();
		assert (cartPage.getFirstItemText()
				.contains(itemTitle));
		cartPage.sendAsGift();
		cartPage.updateQuantity();
		assert (cartPage.getQuantity()
				.equals("6"));
		cartPage.deleteItem();
		
	}

}