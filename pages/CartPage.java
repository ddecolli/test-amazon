package com.github.ddecolli.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private static final By LIST_ITEM = By.className("a-list-item");
    private static final By ADD_GIFT_TO_BASKET = By.id("a-checkbox");
    private static final By QUANTITY_DROPDOWN_SIX = By.id("#dropdown1_5");
    private static final By VERIFY_QUANTITY = By.id("#dropdown1_5");
    private static final By DELETE_LINK = By.id(".a-spacing-base");
    
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstItemText() {
        return driver.findElement(LIST_ITEM)
                .getText();
    }
    
    public void sendAsGift() {
        driver.findElement(ADD_GIFT_TO_BASKET)
                .click();
    }
    
    public void updateQuantity() {
    	driver.findElement(QUANTITY_DROPDOWN_SIX)
        .click();
    }
    
    public String getQuantity() {
    	return driver.findElement(VERIFY_QUANTITY)
        .getText();
    }
    
    public void deleteItem() {
    	 driver.findElement(DELETE_LINK)
        .click();
    }
}

