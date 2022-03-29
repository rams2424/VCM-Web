Feature: Purchase End to End for Scenarios

  @Regression @Purchase
  Scenario Outline: Purchase End to end for IRA account-Existing fund-Subsequent and Monthly
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User Click On Buy button From Place An Order
    Then Verify That it is navigated to Buy Page
    When Click on the Account Number "<Number>"
    When click on Next button
    When User Click on "<FundName>" Fund
    When User Selects "Subsequent and Monthly" from dropdown
    And User gives value "<Initial Value>" in Initial
    And User gives value "<Monthly Value>" in Monthly
    And User gives a valid date as starting date
    When click on Next button
    When Select "<fundsource>" as fund sourcewith "<accNo>"
    When Select IRA contributions "<iraContribution>"
    When click on Next button
    Then Click on proceed
    And Verify "Subsequent Investment" amount is "<Initial Value>"
    And Verify "Monthly Investment" amount is "<Monthly Value>"
    And Verify Total Investment for monthly is sum of "<Initial Value>" "<Monthly Value>"
    And Verify IRA contribution is "<iraContribution>"
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
      | FundName                    | onlineid    | password | Number   | Initial Value | fundsource   | Monthly Value | iraContribution | accNo               | confirmationMsg | holdingGroup        | particularAccount        |
      | USAA Aggressive Growth Fund | onlineid150 | Pass@123 | 22942792 |           500 | bank Account |           500 | Current Year    | WELLS FARGO BANK NA | Confirmation    | Retirement Accounts | Traditional IRA-XXXX2792 |

  @Regression @Purchase
  Scenario Outline: Purchase End to end for IRA account existing fund-subsequent
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User Click On Buy button From Place An Order
    When Click on the Account Number "<Number>"
    When click on Next button
    When User Click on "<FundName>" Fund
    When User Selects "Subsequent" from dropdown
    And User gives value "<Initial Value>" in Initial
    When click on Next button
    When Select "<fundsource>" as fund sourcewith "<accNo>"
    When Select IRA contributions "<iraContribution>"
    When click on Next button
    Then Click on proceed
    Then Verify Trade type is "Buy"
    And Verify "Subsequent Investment" amount is "<Initial Value>"
    And Verify Total Investment is "<Initial Value>"
    And Verify IRA contribution is "<iraContribution>"
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
      | FundName                    | onlineid    | password | Number   | Initial Value | fundsource   | Monthly Value | iraContribution | accNo               | confirmationMsg | holdingGroup        | particularAccount        |
      | USAA Aggressive Growth Fund | onlineid150 | Pass@123 | 22942792 |           500 | bank Account |           500 | Current Year    | WELLS FARGO BANK NA | Confirmation    | Retirement Accounts | Traditional IRA-XXXX2792 |

  @Regression @Purchase
  Scenario Outline: Purchase End to end for IRA account existing fund-subsequent
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User Click On Buy button From Place An Order
    When Click on the Account Number "<Number>"
    When click on Next button
    When User Click on "<FundName>" Fund
    When User Selects "Subsequent" from dropdown
    And User gives value "<Initial Value>" in Initial
    When click on Next button
    When Select "<fundsource>" as fund sourcewith "<accNo>"
    When Select IRA contributions "<iraContribution>"
    When click on Next button
    Then Click on proceed
    Then Verify Trade type is "Buy"
    And Verify "Subsequent Investment" amount is "<Initial Value>"
    And Verify Total Investment is "<Initial Value>"
    And Verify IRA contribution is "<iraContribution>"
    When Click on Submit button
    Then confirmation Message Should be display as "<confirmationMsg>"
    Then User is logged Out

    Examples: 
      | FundName                    | onlineid    | password | Number   | Initial Value | fundsource    | Monthly Value | iraContribution | accNo               | confirmationMsg |
      | USAA Aggressive Growth Fund | onlineid150 | Pass@123 | 22942792 |           500 | Check         |           500 | Current Year    | WELLS FARGO BANK NA | Confirmation    |
      | USAA Aggressive Growth Fund | onlineid150 | Pass@123 | 22942792 |           500 | Wire Transfer |           500 | Current Year    | WELLS FARGO BANK NA | Confirmation    |
