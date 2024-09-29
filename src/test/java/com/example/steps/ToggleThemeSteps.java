package com.example.steps;

import com.example.hooks.Hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;


public class ToggleThemeSteps {
    private WebDriver driver;
    private HomePage homePage;
    private String currentTheme;

    @Before
    public void setUp() {
        this.driver = Hooks.setUpDriver();
        this.homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Given("the app is in the initial mode")
    public void the_app_is_in_the_initial_mode() {
        homePage.navigateTo();
    }

    @When("I click the toggle theme button")
    public void i_click_the_toggle_theme_button() {
        this.currentTheme = homePage.themeMode();
        homePage.toggleTheme();
    }

    @Then("the app should switch to a different theme mode")
    public void the_app_should_switch_to_a_different_theme_mode() {
        Assert.assertNotEquals(this.currentTheme, homePage.themeMode());
    }

    @Given("the app's theme has changed")
    public void the_app_s_theme_has_changed() {
        this.currentTheme = homePage.themeMode();
    }

    @When("I refresh the app")
    public void i_refresh_the_app() {
        driver.navigate().refresh();
    }

    @Then("the app should still be same theme mode")
    public void the_app_should_still_be_same_theme_mode() {
        Assert.assertEquals(this.currentTheme, homePage.themeMode());
    }
}
