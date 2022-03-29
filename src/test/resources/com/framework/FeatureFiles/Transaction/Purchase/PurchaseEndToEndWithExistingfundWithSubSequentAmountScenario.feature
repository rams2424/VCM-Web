Feature: Purchase End to End for Scenarios

  @Regression @Purchase @a
  Scenario Outline: Purchase End to end for existing fund-subsequent
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User Click On Buy button From Place An Order
    Then Verify That it is navigated to Buy Page
    When Click on the Account Number "<Number>"
    When click on Next button
    Then Verify That it is navigated to Investment Page
    When User Click on "<FundName>" Fund
    When User Selects "Subsequent" from dropdown
    And User gives value "<Initial Value>" in Initial
    When click on Next button
    Then Verify That it is navigated to Fund Source Page
    When Select "<fundsource>" as fund sourcewith "<accNo>"
    When click on Next button
    Then It should be on Review & confirm Page
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
      | onlineid    | password | Number  | Initial Value | fundsource   | FundName                        | holdingGroup                | particularAccount | confirmationMsg | cancelMsg | accNo               |
      | onlineid140 | Test@123 | 6864836 |            52 | bank Account | USAA Government Securities Fund | General Investment Accounts |              4836 | Confirmation    | cancelled | WELLS FARGO BANK NA |

  @Regression @Purchase
  Scenario Outline: Purchase End to end for existing fund-subsequent
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User Click On Buy button From Place An Order
    Then Verify That it is navigated to Buy Page
    When Click on the Account Number "<Number>"
    When click on Next button
    Then Verify That it is navigated to Investment Page
    When User Click on "<FundName>" Fund
    When User Selects "Subsequent" from dropdown
    And User gives value "<Initial Value>" in Initial
    When click on Next button
    Then Verify That it is navigated to Fund Source Page
    When Select "<fundsource>" as fund sourcewith "<accNo>"
    When click on Next button
    Then It should be on Review & confirm Page
    When Click on Submit button
    Then confirmation Message Should be display as "<confirmationMsg>"
    Then User is logged Out

    Examples: 
      | onlineid    | password | Number  | Initial Value | fundsource    | FundName                        | confirmationMsg | cancelMsg | accNo               |
      | onlineid140 | Test@123 | 6864836 |            52 | Check         | USAA Government Securities Fund | Confirmation    | cancelled | WELLS FARGO BANK NA |
      | onlineid140 | Test@123 | 6864836 |            52 | Wire Transfer | USAA Government Securities Fund | Confirmation    | cancelled | WELLS FARGO BANK NA |
