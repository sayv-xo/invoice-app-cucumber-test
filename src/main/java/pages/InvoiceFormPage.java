package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InvoiceFormPage {
    private final WebDriver driver;

    // Locators for form fields
    private final By senderStreetInput = By.id("senderStreet");
    private final By senderCityInput = By.id("senderCity");
    private final By senderCodeInput = By.id("senderPostCode");
    private final By senderCountryInput = By.id("senderCountry");

    private final By clientNameInput = By.id("clientName");
    private final By clientEmailInput = By.id("clientEmail");
    private final By clientStreetInput = By.id("clientStreet");
    private final By clientCityInput = By.id("clientCity");
    private final By clientCodeInput = By.id("clientPostCode");
    private final By clientCountryInput = By.id("clientCountry");

    private final By invoiceDateInput = By.id("createdAt");;
    private final By descriptionInput = By.id("description");


    private final By itemNameInput = By.id("itemName0");
    private final By itemQuantityInput = By.id("itemQuantity0");
    private final By itemPriceInput = By.id("itemPrice0");
    private final By paymentTermsSelect = By.id("paymentTerms");

    private final By addItemButton = By.className("save");
    private final By discardButton = By.className("discard");
    private final By draftButton = By.className("save-draft");

    public InvoiceFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to fill out the Bill From section
    public void fillSenderDetails(String street, String city, String code, String country) {
        driver.findElement(senderStreetInput).sendKeys(street);
        driver.findElement(senderCityInput).sendKeys(city);
        driver.findElement(senderCodeInput).sendKeys(code);
        driver.findElement(senderCountryInput).sendKeys(country);
    }

    // Method to fill out the Bill To section
    public void fillClientDetails(String name, String email, String street, String city, String code, String country) {
        driver.findElement(clientNameInput).sendKeys(name);
        driver.findElement(clientEmailInput).sendKeys(email);
        driver.findElement(clientStreetInput).sendKeys(street);
        driver.findElement(clientCityInput).sendKeys(city);
        driver.findElement(clientCodeInput).sendKeys(code);
        driver.findElement(clientCountryInput).sendKeys(country);
    }

    // Method to fill out the invoice details
    public void fillInvoiceDetails(String invoiceDate, String description) {

        driver.findElement(invoiceDateInput).sendKeys(invoiceDate);
        driver.findElement(descriptionInput).sendKeys(description);
        Select paymentTerm = new Select(driver.findElement(paymentTermsSelect));
        paymentTerm.selectByVisibleText("Net 1 Day");

    }

    // Method to add an item to the invoice
    public void addItem(String itemName, String quantity, String price) {
        driver.findElement(itemNameInput).sendKeys(itemName);
        driver.findElement(itemQuantityInput).sendKeys(quantity);
        driver.findElement(itemPriceInput).sendKeys(price);

    }

    public void submitAndSend() {
        driver.findElement(addItemButton).click();
    }
}
