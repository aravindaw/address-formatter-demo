package com.aravinda.app.baseScript;

import org.openqa.selenium.WebDriver;

public class Driver {
    public WebDriver driver;

    private static Driver Driver = null;

    private Driver() {
    }

    public static synchronized Driver getInstance() {
        if (Driver == null) {
            Driver = new Driver();
        }
        return Driver;
    }
}
