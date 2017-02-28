package org.grizz.config;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class WebDriverHolder {
    private final Supplier<WebDriver> webDriverSupplier;
    private WebDriver driver;

    public WebDriverHolder(Supplier<WebDriver> webDriverSupplier) {
        this.webDriverSupplier = webDriverSupplier;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void start() {
        this.driver = webDriverSupplier.get();
    }

    public void quit() {
        this.driver.quit();
    }
}
