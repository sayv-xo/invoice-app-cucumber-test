package com.example.steps;

import com.example.hooks.Hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.InvoiceFormPage;
import java.util.List;

public class CreateInvoiceSteps {
    private WebDriver driver;
    private HomePage homePage;
    private InvoiceFormPage invoiceFormPage;
    private String street = "123 Elm Street";
    private String city = "San Francisco";
    private String postCode = "94105";
    private String country = "USA";
    private String name = "John Smith";
    private String email = "john.smith@gmail.com";
    private String date = "12122000";
    private String description = "Lorem ipsum dolor sit amet";
    private String itemName = "Fish";
    private String itemQuantity = "1";
    private String itemPrice = "12";

    @Before
    public void setUp() {
        this.driver = Hooks.setUpDriver();
        this.homePage = new HomePage(driver);
        this.invoiceFormPage = new InvoiceFormPage(driver);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I am on the invoice form page")
    public void i_am_on_the_invoice_form_page() {
        homePage.navigateTo();
        homePage.createInvoice();
    }

    @When("I input invoice details and press Save")
    public void i_input_invoice_details_and_press_Save() {
        invoiceFormPage.fillSenderDetails(street, city, postCode, country);
        invoiceFormPage.fillClientDetails(name, email, street, city, postCode, country);
        invoiceFormPage.addItem(itemName, itemQuantity, itemPrice);
        invoiceFormPage.fillInvoiceDetails(date, description);
        invoiceFormPage.submitAndSend();
    }

    @Then("Invoice should be created")
    public void invoice_should_be_created() {
        WebElement invoiceName = findInvoiceItemByName(name);
        Assert.assertNotNull(invoiceName);
    }

    public List<WebElement> getInvoiceItems() {
        By invoiceItemLocator = By.className("invoice-card");
        return driver.findElements(invoiceItemLocator);
    }

    public WebElement findInvoiceItemByName(String invoiceName) {
        List<WebElement> items = getInvoiceItems();

        for (WebElement item : items) {
            String id = item.findElement(By.className("name")).getText();
            if (id.contains(invoiceName)) {
                return item;
            }
        }
        return null;
    }

}
