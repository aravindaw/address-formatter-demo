package com.aravinda.app.baseScript;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseDriver {

    protected static WebDriver driver;

    @Parameters({"browser"})
    @BeforeTest()
    public void createTestEnvironment(@Optional("chrome") String browser) {

        CompositeConfiguration config = new CompositeConfiguration();
        try {
            config.addConfiguration(new PropertiesConfiguration("src/main/resources/config.properties"));
        } catch (org.apache.commons.configuration.ConfigurationException e) {
            e.printStackTrace();
        }
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", config.getProperty("CHROME_DRIVER_PATH").toString());
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.chrome.driver", config.getProperty("FIREFOX_DRIVER_PATH").toString());
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", config.getProperty("IE_DRIVER_PATH").toString());
                driver = new ChromeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
        driver.get(config.getProperty("BASE_URL").toString());
    }

    @AfterTest
    public void exitTestEnvironment() {
        driver.quit();
    }

}
