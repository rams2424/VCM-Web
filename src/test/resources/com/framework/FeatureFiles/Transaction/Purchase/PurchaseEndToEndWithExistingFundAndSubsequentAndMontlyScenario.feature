Feature: Purchase End to End for Scenarios

 @Regression @Purchase
  Scenario Outline: Purchase End to end for Existing fund-Subsequent and Monthly
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User Click On Buy button From Place An Order
    Then Verify That it is navigated to Buy Page
    When Click on the Account Number "<Number>"
    When click on Next button
    Then Verify That it is navigated to Investment Page
    When User Click on "<FundName>" Fund
    When User Selects "Subsequent and Monthly" from dropdown
    And User gives value "<Initial Value>" in Initial
    And User gives value "<Monthly Value>" in Monthly
    And User gives a valid date as starting date
    When click on Next button
    Then Verify That it is navigated to Fund Source Page
    When Select "<fundsource>" as fund sourcewith "<accNo>"
    When click on Next button
    Then It should be on Review & confirm Page
    Then Verify Trade type is "Buy"
    And Verify "Subsequent Investment" amount is "<Initial Value>"
    And Verify "Monthly Investment" amount is "<Monthly Value>"
    And Verify Total Investment for monthly is sum of "<Initial Value>" "<Monthly Value>"
    When Click on Submit button
    Then confirmation Message Should be display as "<confirmationMsg>"
    And Navigate to HomePage
    When Member clicks on "<particularAccount>" accounts
    Then verify Member is navigated to transactions page
    When Click on View Account Activity
    Then Verify That is navigated to Account Activity
    When click On Cancel Transaction for fundSource "<fundsource>"
    Then User is logged Out

    Examples: 
      | onlineid    | password | Number  | Initial Value | fundsource   | Monthly Value | FundName                        | holdingGroup                | particularAccount | confirmationMsg | cancelMsg | accNo               |
      | onlineid140 | Test@123 | 6864836 |            52 | bank Account |           500 | USAA Government Securities Fund | General Investment Accounts |              4836 | Confirmation    | cancelled | WELLS FARGO BANK NA |
