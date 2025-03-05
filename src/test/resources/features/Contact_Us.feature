Feature: WebDriver University - Contact Us Page

  Scenario: Validate Successful Submission - Unique Data
    Given I access the WebDriver University - Contact Us Page
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on the submit button
    Then I should be presented with a successful contact us submission message
    Then I should be able to write on the CSV file

  Scenario: Enter First Name
    Given I access the WebDriver University - Contact Us Page
    When I enter a unique first name

  Scenario: Enter Last Name
    Given I access the WebDriver University - Contact Us Page
    When I enter a unique last name

  Scenario: Enter Email Address
    Given I access the WebDriver University - Contact Us Page
    When I enter a unique email address