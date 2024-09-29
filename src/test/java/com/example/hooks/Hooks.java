package com.example.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class Hooks {

    public static WebDriver setUpDriver() {
        String seleniumHubUrl = System.getenv("SELENIUM_REMOTE_URL");

        if (seleniumHubUrl != null && !seleniumHubUrl.isEmpty()) {
            // Running inside Docker, use RemoteWebDriver
            try {
                ChromeOptions options = new ChromeOptions();
                options.setCapability("platformName", "linux");

                System.out.println("Connecting to Selenium Hub at: " + seleniumHubUrl);

                return new RemoteWebDriver(new URL(seleniumHubUrl), options);
            } catch (MalformedURLException e) {
                throw new RuntimeException("The URL provided for the Selenium Hub is malformed: " + e.getMessage());
            } catch (Exception e) {
                throw new RuntimeException("Failed to connect to Selenium Hub: " + e.getMessage(), e);
            }
        } else {
            try {
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                return new ChromeDriver();
            } catch (Exception e) {
                throw new RuntimeException("Failed to initialize Chrome Driver: " + e.getMessage(), e);
            }
        }
    }
}