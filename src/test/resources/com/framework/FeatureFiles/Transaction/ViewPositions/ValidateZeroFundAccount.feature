Feature: Validate Zero balance Accounts


   @Sanity @ViewAccountActivity

  Scenario Outline: Validate trade button for Zero balance Accounts
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Member clicks on "<holdingGroup>"
    Then Member can see "<particularAccount>"
    When Member clicks on "<particularAccount>" accounts
    Then verify Member is navigated to transactions page
    Then verify the current value
    Then verify fund accounts is displayed
    Then verify trade button is displayed
    When click on trade button
    Then Verify only "Buy" is displayed in dropdown
    Then User is logged Out
    

    Examples: 
      | onlineid   | password | particularAccount | holdingGroup        |
      | onlineid39 | Test@123 | XXXX3406  | Retirement Accounts |
      
 