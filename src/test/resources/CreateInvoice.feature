Feature: Create Invoice
  In order to create an invoice
  As a user
  I want to create an save invoices

  Scenario:
    Given I am on the invoice form page
    When I input invoice details and press Save
    Then Invoice should be created