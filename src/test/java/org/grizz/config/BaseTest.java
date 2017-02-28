package org.grizz.config;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.class})
public abstract class BaseTest {
    @Autowired
    private WebDriverHolder driver;

    @Before
    public void setup() {
        driver.start();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
