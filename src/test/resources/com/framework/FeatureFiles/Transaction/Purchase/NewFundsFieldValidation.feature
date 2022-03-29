Feature: New funds fields validation

  @Sanity12 @Purchase
  Scenario Outline: Validates New Funds fields
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User Click On Buy button From Place An Order
    Then Verify That it is navigated to Buy Page
    When Click on the Account Number "<Number>"
    When click on Next button
    When User Click on "<FundName>" Fund
    Then Verify Dropdown "Initial Investment" and "Initial and Monthly Investment" options
    When User Selects "Initial Investment" from dropdown
    Then verify less than minimum amount in Initial Investment-error message is displayed
    When User Selects "Initial and Monthly Investment" from dropdown
    Then verify less than minimum amount in Initial and Monthly Investment-error message is displayed
    Then Monthly textbox and Start date should be displayed
    When User Selects "Initial and Monthly Investment" from dropdown
    And User gives value "<Initial Value>" in Initial
    And User gives value "<Monthly Value>" in Monthly
    Then total should be updated with "<Initial Value>" and "<Monthly Value>" and displayed
    When User Selects "Initial and Monthly Investment" from dropdown
    Then User gives Blank start date
    When click on Next button
    Then date error message should be displayed
    When User Click on Remove button
    Then All details should be removed
    Then User is logged Out

    Examples: 
      | onlineid    | password | Number   | FundName                     | Initial Value | Monthly Value |
      | onlineid150 | Pass@123 | 84510163 | USAA Cornerstone Equity Fund |          5000 |           500 |
