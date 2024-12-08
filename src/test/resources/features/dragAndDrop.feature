@dag_and_drop
Feature: Validate drag and drop

  Scenario: Validate drag and drop
    Given Open the "https://www.lambdatest.com/selenium-playground"
    Then Click "Drag & Drop Sliders" under Input Forms.
    And check for "Default value 15" and drag the bar to make it "95"
    And Validate whether the range value shows "95".