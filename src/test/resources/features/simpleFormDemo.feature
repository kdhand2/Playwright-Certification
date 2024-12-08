@text_message_is_displayed
Feature: Validate whether the same text message is displayed

  Scenario: Validate whether the same text message is displayed
    Given  Open the "https://www.lambdatest.com/selenium-playground"
    Then Click "Simple Form Demo" under Input Forms.
    Then Validate that the URL contains "simple-form-demo".
    And Create a variable for a string value "Welcome to LambdaTest".
    Then Use this variable to enter values in the text box.
    And Click Get Checked Value.
    And Validate whether the same text message is displayed in the right-hand panel