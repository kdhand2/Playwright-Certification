@submit_message
Feature: Validate submit form

  Scenario: Validate submit form

    Given Open the "https://www.lambdatest.com/selenium-playground"
    Then Click "Input Form Submit" under Input Forms.
    Then Click Submit button
    Then validate error message "Please fill out this field."
    Then Fill mandatory parameters
    Then Click Submit button
    Then validate the success message "Thanks for contacting us, we will get back to you shortly."