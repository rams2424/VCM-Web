Feature: Purchase End to End for Scenarios

  @Regression @Purchase
  Scenario Outline: Purchase End to end for New fund-initial and monthly investment
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User Click On Buy button From Place An Order
    Then Verify That it is navigated to Buy Page
    When Click on the Account Number "<Number>"
    When click on Next button
    When User Click on "<FundName>" Fund
    When User Selects "Initial and Monthly Investment" from dropdown
    And User gives value "<Initial Value>" in Initial
    And User gives value "<Monthly Value>" in Monthly
    And User gives a valid date as starting date
    When click on Next button
    When Select "<fundsource>" as fund sourcewith "<accNo>"
    Then verify Dividends and Capital Gains Preferences section is displayed or not
    When Select IRA contributions "<iraContribution>"
    When click on Next button
    Then Click on proceed
    Then Verify Trade type is "Buy"
    And Verify "Initial Investment" amount is "<Initial Value>"
    And Verify "Monthly Investment" amount is "<Monthly Value>"
    And Verify Total Investment for monthly is sum of "<Initial Value>" "<Monthly Value>"
    When click on Next button
    Then Click on terms acceptance checkbox
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
      | FundName                     | onlineid    | password | Number   | Initial Value | fundsource   | Monthly Value | iraContribution | holdingGroup        | particularAccount        | confirmationMsg | cancelMsg | accNo               | Monthly Value |
      | USAA Cornerstone Equity Fund | onlineid150 | Pass@123 | 22942792 |           500 | bank Account |           500 | Current Year    | Retirement Accounts | Traditional IRA-XXXX2792 | Confirmation    | cancelled | WELLS FARGO BANK NA |          1000 |

  @Regression @Purchase
  Scenario Outline: Purchase End to end for IRA-New fund-initial investment
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User Click On Buy button From Place An Order
    Then Verify That it is navigated to Buy Page
    When Click on the Account Number "<Number>"
    When click on Next button
    When User Click on "<FundName>" Fund
    When User Selects "Initial Investment" from dropdown
    And User gives value "<Initial Value>" in Initial
    When click on Next button
    Then Verify That it is navigated to Fund Source Page
    When Select "<fundsource>" as fund sourcewith "<accNo>"
    Then verify Dividends and Capital Gains Preferences section is displayed or not
    When Select IRA contributions "<iraContribution>"
    When click on Next button
    Then Click on proceed
    Then Verify Trade type is "Buy"
    When click on Next button
    Then Click on terms acceptance checkbox
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
      | FundName                     | onlineid    | password | Number   | Initial Value | fundsource   | Monthly Value | iraContribution | holdingGroup        | particularAccount        | confirmationMsg | cancelMsg | accNo               |
      | USAA Cornerstone Equity Fund | onlineid150 | Pass@123 | 22942792 |           500 | bank Account |           500 | Current Year    | Retirement Accounts | Traditional IRA-XXXX2792 | Confirmation    | cancelled | WELLS FARGO BANK NA |

  @Regression @Purchase
  Scenario Outline: Purchase End to end for IRA-New fund-initial investment
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User Click On Buy button From Place An Order
    Then Verify That it is navigated to Buy Page
    When Click on the Account Number "<Number>"
    When click on Next button
    When User Click on "<FundName>" Fund
    When User Selects "Initial Investment" from dropdown
    And User gives value "<Initial Value>" in Initial
    When click on Next button
    Then Verify That it is navigated to Fund Source Page
    When Select "<fundsource>" as fund sourcewith "<accNo>"
    Then verify Dividends and Capital Gains Preferences section is displayed or not
    When Select IRA contributions "<iraContribution>"
    When click on Next button
    Then Click on proceed
    Then Verify Trade type is "Buy"
    When click on Next button
    Then Click on terms acceptance checkbox
    When Click on Submit button
    Then confirmation Message Should be display as "<confirmationMsg>"
    Then User is logged Out

    Examples: 
      | FundName                     | onlineid    | password | Number   | Initial Value | fundsource    | Monthly Value | iraContribution | confirmationMsg | cancelMsg | accNo               |
      | USAA Cornerstone Equity Fund | onlineid150 | Pass@123 | 22942792 |           500 | Check         |           500 | Current Year    | Confirmation    | cancelled | WELLS FARGO BANK NA |
      | USAA Cornerstone Equity Fund | onlineid150 | Pass@123 | 22942792 |           500 | Wire Transfer |           500 | Current Year    | Confirmation    | cancelled | WELLS FARGO BANK NA |
