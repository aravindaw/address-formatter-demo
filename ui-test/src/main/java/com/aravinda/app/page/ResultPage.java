package com.aravinda.app.page;

import com.aravinda.app.baseScript.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class ResultPage extends BaseDriver {
    private int timeout = 15;

    private final String pageLoadedText = "Result";

    private final String pageUrl = "/address";

    @FindBy(xpath = "//button[contains(text(),'Submit another address')]")
    private WebElement submitAnotherAddress;

    @FindBy(xpath = "(//p[contains(text(),'Given address:')]/../p)[2]")
    private WebElement givenAddress;

    @FindBy(xpath = "(//p[contains(text(),'Formatted address:')]/../p)[4]")
    private WebElement formattedAddress;

    public ResultPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Click on Submit Another Address Button.
     */
    public ResultPage clickSubmitAnotherAddressButton() {
        submitAnotherAddress.click();
        return this;
    }

    /**
     * Get given address.
     */
    public String getGivenAddress() {
        return givenAddress.getText();
    }

    /**
     * Click on Submit Another Address Button.
     */
    public String getFormattedAddress() {
        return formattedAddress.getText();
    }

    /**
     * Verify that the page loaded completely.
     */
    public ResultPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     */
    public ResultPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
