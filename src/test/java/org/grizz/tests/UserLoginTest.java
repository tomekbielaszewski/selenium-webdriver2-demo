package org.grizz.tests;

import org.grizz.config.TestConfig;
import org.grizz.pages.LoginPage;
import org.grizz.pages.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.class})
public class UserLoginTest {
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
