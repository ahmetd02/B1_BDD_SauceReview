Feature: Login and E2E Test
  @wip
  Scenario: Login and End to End Test
    Given The user is on the login page
    When The user enters "standard_user" and "secret_sauce"
    Then The user should be able to login and see "Products" header
    And The user should be able to sort products "Price (high to low)"
    When The user clicks cheapest as "7.99" and the second costline as "29.99" products
    And The user opens the basket
    And The user clicks on checkout button
    And The user enters details as "Jack" "Sparrow" "GB0124" and finish purchase
    Then The user verifies that the items are "41.02" and total is "Total: $41.02"