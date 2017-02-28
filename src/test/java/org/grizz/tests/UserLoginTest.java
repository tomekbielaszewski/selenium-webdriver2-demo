package org.grizz.tests;

import org.grizz.config.BaseTest;
import org.grizz.pages.LoginPage;
import org.grizz.pages.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserLoginTest extends BaseTest {
    @Autowired
    private LoginPage loginPage;

    @Test
    public void userShouldLogin() {
        Page page = loginPage.login("tylkodotestow", "tylkodotestow");
        assertThat(page.getCurrentUrl(), is("http://www.wykop.pl/"));
    }

    @Test
    public void userShouldNotLoginWithBadCredentials() {
        loginPage.login("tylkodotestow", "tylkodotesto");
        assertThat(loginPage.getErrorMessage().getText(), is("Niepoprawny login lub hasło"));
    }
}
