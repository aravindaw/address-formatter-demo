package com.aravinda.app.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumx.util.PageObject;

public class AddressFormatterPage extends PageObject {

    private int timeout = 15;

    private final String pageLoadedText = "Enter your address here:";

    private final String pageUrl = "/address";

    @FindBy(id = "btn")
    private WebElement formatAddress;

    @FindBy(id = "reset")
    private WebElement resetButton;

    @FindBy(xpath = "//input[@id='address']")
    private WebElement setAddress;

    public AddressFormatterPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Click on Format Address Button.
     */
    public AddressFormatterPage clickFormatAddressButton() {
        formatAddress.click();
        return this;
    }

    /**
     * Click on Reset Address Button.
     */
    public AddressFormatterPage clickResetButton() {
        resetButton.click();
        return this;
    }

    /**
     * Set Address.
     */
    public AddressFormatterPage setAddress(String address) {
        setAddress.sendKeys(address);
        return this;
    }

    /**
     * Set Address.
     */
    public boolean addressFormatterButtonVisible() {
        return formatAddress.isDisplayed();
    }

    /**
     * Get current value in Address field.
     */
    public String  getAddressFieldValue() {
        return setAddress.getAttribute("value");
    }

    /**
     * Verify that the page loaded completely.
     */
    public AddressFormatterPage verifyPageLoaded() {
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
    public AddressFormatterPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
