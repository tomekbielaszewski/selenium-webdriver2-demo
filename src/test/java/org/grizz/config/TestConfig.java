package org.grizz.config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan("org.grizz")
public class TestConfig {
    @Value("${webdriver.chrome.driver}")
    private String webDriverPath;

    @Value("${application.base.url}")
    public String baseUrl;

    @Bean
    public WebDriverHolder webDriverHolder() {
        return new WebDriverHolder(ChromeDriver::new);
    }

    @PostConstruct
    public void init() {
        System.setProperty("webdriver.chrome.driver", webDriverPath);
    }
}