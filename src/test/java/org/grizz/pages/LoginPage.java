package org.grizz.pages;

import org.grizz.config.TestConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginPage extends Page {
    private final String url = "/zaloguj";

    @Autowired
    private TestConfig config;

    @Autowired
    private UserMenuPage userMenuPage;

    public Page login(String user, String password) {
        driver().get(config.baseUrl + url);

        getUsernameField().sendKeys(user);
        getPasswordField().sendKeys(password);
        getLoginButton().submit();

        return userMenuPage;
    }

    public WebElement getErrorMessage() {
        return driver().findElement(By.cssSelector(".login-form div.error"));
    }

    private WebElement getUsernameField() {
        return driver().findElement(By.cssSelector("#text1"));
    }

    private WebElement getPasswordField() {
        return driver().findElement(By.cssSelector("#text2"));
    }

    private WebElement getLoginButton() {
        return driver().findElement(By.cssSelector(".login-form input.submit"));
    }
}
