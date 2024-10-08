package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String BASE_URL = "https://invoice-app-6rkf.vercel.app/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateTo() {
        driver.get(BASE_URL);
    }

    public void toggleTheme() {
        driver.findElement(By.className("toggle-theme")).click();
    }

    public String themeMode() {
        return driver.findElement(By.tagName("html")).getAttribute("data-theme");
    }

    public void createInvoice() {
        driver.findElement(By.cssSelector(".create")).click();
    }
}