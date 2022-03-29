Feature: Manage Bank Accounts

   @Regression @AccountServices
  Scenario Outline: Navigate to bank accounts and validate fields
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When I click on Account Services
    And I click on Bank Accounts
    Then I should see the Bank Accounts title page and Add button
    And I should see the Back button and disclaimer footer in Bank Accounts page
    Then User is logged Out

    @SIT
    Examples: 
      | onlineid   | password |
      | Onlineid68 | Pass@123 |

 @UAT
 Examples: 
      | onlineid    | password |                  
      |   uatuser046 | Pass@1234 |
   @Regression @AccountServices
  Scenario Outline: Navigate to Add bank accounts and validate fields
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When I click on Account Services
    And I click on Bank Accounts
    When I click Add button
    Then I should see Add Bank Account page
    And I should see the Type Account - savings and checkings
    And I should see the Transit Routing Number and the Account Number
    And I should see Cancel and Next buttons in Add Bank Account page
    Then User is logged Out

    @SIT
    Examples: 
      | onlineid   | password |
      | Onlineid68 | Pass@123 |

 @UAT
 Examples: 
      | onlineid    | password |                  
      |   uatuser046 | Pass@1234 |
  @Regression @AccountServices
  Scenario Outline: Manage Bank Accounts - Add Bank Mandatory Fields Error Message
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When I click on Account Services
    And I click on Bank Accounts
    And I click Add button
    When I click Transit Routing Number edit text field and I do not entered data
    And I click Account Number edit text field and I do not entered data
    Then I should see that error messages are displayed for Type of Account, Transit Routing Number and Account Number
    And I should see that Next button is disabled inside the Add Bank page
    Then User is logged Out

    @SIT
    Examples: 
      | onlineid   | password |
      | Onlineid68 | Pass@123 |
      
       @UAT
 Examples: 
      | onlineid    | password |                  
      |   uatuser046 | Pass@1234 |

  @Regression @AccountServices
  Scenario Outline: Manage Bank Accounts - Add Bank Account Functionality
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When I click on Account Services
    And I click on Bank Accounts
    And I click Add button
    And I complete all the required fields "<Type of Account>", "<Transit Routing Number>" and "<Account Number>"
    And Click On Next
    Then I reach the Verify Bank Details Page and I should see that all elements "<Type of Account>", "<Transit Routing Number>" and "<Account Number>" are correct
    And I should see the Cancel and Submit buttons inside the Verify Bank Details Page
    Then User is logged Out

    @SIT
    Examples: 
      | onlineid   | password | Type of Account | Transit Routing Number | Account Number |
      | Onlineid68 | Pass@123 | Savings         |              123456789 |          12345 |
 @UAT
 Examples: 
      | onlineid    | password |                  
      |   uatuser046 | Pass@1234 |