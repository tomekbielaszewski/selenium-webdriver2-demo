package org.grizz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

@Service
public class UserMenuPage extends Page {

    public WebElement getAvatar() {
        return driver().findElement(By.cssSelector("li.logged-user img.avatar"));
    }
}
