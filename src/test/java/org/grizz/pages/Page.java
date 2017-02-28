package org.grizz.pages;

import org.grizz.config.WebDriverHolder;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Page {
    @Autowired
    private WebDriverHolder driverHolder;

    public String getCurrentUrl() {
        return driver().getCurrentUrl();
    }

    protected WebDriver driver() {
        return driverHolder.getDriver();
    }
}
