Feature: Existing funds field validation

  @Sanity @Purchase
  Scenario Outline: Validates Existing Funds Fields
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User Click On Buy button From Place An Order
    Then Verify That it is navigated to Buy Page
    When Click on the Account Number "<Number>"
    When click on Next button
    When User Click on "<FundName>" Fund
    Then Verify Dropdown "Subsequent" and "Subsequent and Monthly" options
    When User Selects "Subsequent" from dropdown
    Then verify less than minimum amount in subsequent-error message is displayed
    When User Selects "Subsequent and Monthly" from dropdown
    Then verify less than minimum amount in Subsequent & Monthly Functioning-error message is displayed
    When User Selects "Subsequent and Monthly" from dropdown
    Then Monthly textbox and Start date should be displayed
    When User Selects "Subsequent and Monthly" from dropdown
    And User gives value "<Initial Value>" in Initial
    And User gives value "<Monthly Value>" in Monthly
    Then total should be updated with "<Initial Value>" and "<Monthly Value>" and displayed
    When User Selects "Subsequent and Monthly" from dropdown
    Then User gives Blank start date
    When click on Next button
    Then date error message should be displayed
    When User Click on Remove button
    Then All details should be removed
    Then User is logged Out

    Examples: 
      | onlineid    | password | Number  | FundName                        | Initial Value | Monthly Value |
      | onlineid140 | Test@123 | 6864836 | USAA Government Securities Fund |          1000 |          2000 |
