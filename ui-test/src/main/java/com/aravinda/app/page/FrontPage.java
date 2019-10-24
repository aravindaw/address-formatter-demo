package com.aravinda.app.page;

import com.aravinda.app.baseScript.BaseDriver;
import com.aravinda.app.baseScript.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrontPage extends BaseDriver {

    private int timeout = 15;

    private final String pageLoadedText = "Welcome to Address Formatter page";

    private final String pageUrl = "/";

    @FindBy(xpath = "//button[@id='continue']")
    private WebElement clickToContinue;

    public FrontPage() {
        PageFactory.initElements(Driver.getInstance().driver, this);
    }

    /**
     * Click on Click To Continue Button.
     */
    public FrontPage clickContinueButton() {
        clickToContinue.click();
        return this;
    }


    /**
     * Verify that the page loaded completely.
     */
    public FrontPage verifyPageLoaded() {
        (new WebDriverWait(Driver.getInstance().driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     */
    public FrontPage verifyPageUrl() {
        (new WebDriverWait(Driver.getInstance().driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
