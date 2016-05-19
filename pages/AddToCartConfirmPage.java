package com.github.ddecolli.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.ddecolli.pom.components.NavigationMenu;

public class AddToCartConfirmPage {
    private static final By CONFIRM_TEXT_FIELD = By.id("confirm-text");
    private final NavigationMenu navigationMenu;
    private WebDriver driver;

    public AddToCartConfirmPage(WebDriver driver) {
        this.driver = driver;
        this.navigationMenu = new NavigationMenu(driver);
    }

    public String getConfirmationText() {
        return driver.findElement(CONFIRM_TEXT_FIELD)
                .getText();
    }

    public NavigationMenu navigationMenu() {
        return navigationMenu;
    }
}