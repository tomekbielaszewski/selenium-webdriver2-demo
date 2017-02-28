package org.grizz.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Page {
    @Autowired
    protected WebDriver driver;

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
