package com.github.ddecolli.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    private static final By SEARCH_RESULT_ITEM_TITLE = By.className("s-access-title");
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstResultTitle() {
        return driver.findElement(SEARCH_RESULT_ITEM_TITLE)
                .getText();
    }

    public ProductDetailsPage clickFirstResultTitle() {
        driver.findElement(SEARCH_RESULT_ITEM_TITLE)
                .click();
        return new ProductDetailsPage(driver);
    }
}