Feature: Add New Bank Account Field Validations

  @Sanity12 @Purchase
  Scenario Outline: Add new Bank Account Sanity Scenarios, validation of fields
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When User Click On Buy button From Place An Order
    Then Verify That it is navigated to Buy Page
    When Click on the Account Number "<Number>"
    When click on Next button
    When User Click on "<FundName>" Fund
    When User Selects "Subsequent" from dropdown
    And User gives value "<Initial Value>" in Initial
    When click on Next button
    When Select "<fundsource>" as fund sourcewith "<accNo>"
    Then Verify two radio buttons Savings and Checking are displayed
    When User checks on "<radioButton>" radio button
    Then Verify error message for blank account number is diplayed
    Then Verify error message for blank router number is diplayed
    Then Verify minimum digit error message for Account number is diplayed
    Then Verify minimum digit error message for Routing number is diplayed
    When User enters "<validAccNumber>" as account number
    And User enters "<validRoutingNumber>" as routing number
    Then Verify add bank account button is enabled
    Then User is logged Out

    Examples: 
      | onlineid    | password | Number  | Initial Value | fundsource       | FundName                        | accNo               | validAccNumber | validRoutingNumber | radioButton |
      | onlineid140 | Test@123 | 6864836 |          5000 | Add Bank Account | USAA Government Securities Fund | WELLS FARGO BANK NA |     0000000018 |          122105278 | Savings     |
