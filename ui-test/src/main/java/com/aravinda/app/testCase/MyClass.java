package com.aravinda.app.testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MyClass {
    @Test
    public void myMethod() {
        System.setProperty("webdriver.gecko.driver", "/Users/aravindaweerasekara/Downloads/WebDrivers/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://localhost:8080/address-formatter-0.0.1-SNAPSHOT");
        driver.quit();
    }
}
