Feature: View Positions


  @Sanity @ViewAccountActivity 

  Scenario Outline: Verify member can navigate to accounts page and validates fields
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Member clicks on "<holdingGroup>"
    Then Member can see "<particularAccount>"
    When Member clicks on "<particularAccount>" accounts
    Then verify Member is navigated to transactions page
    Then verify the current value
    Then verify fund accounts is displayed
    Then verify trade button is displayed
    When click on trade button
    Then Verify "Buy" "Sell" and "Exchange" is displayed in dropdown
    Then verify ticker is displayed
    When click on ticker
    Then Verify "Buy" "Sell" "Exchange" and "View Details" is displayed in dropdown
	Then User is logged Out	
    Examples: 
      | onlineid   | password | particularAccount   | holdingGroup                |
      | onlineid39 | Test@123 | XXXX0313 | General Investment Accounts |



  @Sanity  @ViewAccountActivity 

  Scenario Outline: Validate back to portfolio button
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Member clicks on "<holdingGroup>"
    Then Member can see "<particularAccount>"
    When Member clicks on "<particularAccount>" accounts
    Then verify Member is navigated to transactions page
    When Member clicks on back to portfolio
    Then Member is navigated to home page
    Then User is logged Out
		
    Examples: 
      | onlineid   | password | particularAccount   | holdingGroup                |
      | onlineid39 | Test@123 | XXXX0313 | General Investment Accounts |



  @Sanity @ViewAccountActivity 

  Scenario Outline: Validate navigation to buy
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Member clicks on "<holdingGroup>"
    Then Member can see "<particularAccount>"
    When Member clicks on "<particularAccount>" accounts
    Then verify Member is navigated to transactions page
    When click on trade button
    When Member clicks on option "Buy"
    Then Verify that it is navigated to Buy Page
	Then User is logged Out	
    Examples: 
      | onlineid   | password | particularAccount   | holdingGroup                |
      | onlineid39 | Test@123 | XXXX0313 | General Investment Accounts |


  @Sanity @ViewAccountActivity 

  Scenario Outline: Validate navigation to Sell
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Member clicks on "<holdingGroup>"
    Then Member can see "<particularAccount>"
    When Member clicks on "<particularAccount>" accounts
    Then verify Member is navigated to transactions page
    When click on trade button
    When Member clicks on option "Sell"
    Then Verify That it is navigated to Sell Page
	Then User is logged Out	
    Examples: 
      | onlineid   | password | particularAccount   | holdingGroup                |
      | onlineid39 | Test@123 | XXXX0313 | General Investment Accounts |



 @Sanity @ViewAccountActivity 

  Scenario Outline: Validate navigation to Exchange
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Member clicks on "<holdingGroup>"
    Then Member can see "<particularAccount>"
    When Member clicks on "<particularAccount>" accounts
    Then verify Member is navigated to transactions page
    When click on trade button
    When Member clicks on option "Exchange"
    Then Verify That it is navigated to Exchange Page
    Then User is logged Out
    Examples: 
      | onlineid   | password | particularAccount   | holdingGroup                |
      | onlineid39 | Test@123 | XXXX0313 | General Investment Accounts |


   @Sanity @ViewAccountActivity 

  Scenario Outline: Validate navigation to buy
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Member clicks on "<holdingGroup>"
    Then Member can see "<particularAccount>"
    When Member clicks on "<particularAccount>" accounts
    Then verify Member is navigated to transactions page
    When click on ticker
    When Member clicks on option "Buy"
    Then Verify that it is navigated to Buy Page
  	Then User is logged Out	
    Examples: 
      | onlineid   | password | particularAccount   | holdingGroup                |
      | onlineid39 | Test@123 | XXXX0313 | General Investment Accounts |


   @Sanity @ViewAccountActivity 

  Scenario Outline: Validate navigation to Sell
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Member clicks on "<holdingGroup>"
    Then Member can see "<particularAccount>"
    When Member clicks on "<particularAccount>" accounts
    Then verify Member is navigated to transactions page
    When click on ticker
    When Member clicks on option "Sell"
    Then Verify That it is navigated to Sell Page
  	Then User is logged Out	
    Examples: 
      | onlineid   | password | particularAccount   | holdingGroup                |
      | onlineid39 | Test@123 | XXXX0313 | General Investment Accounts |


   @Sanity @ViewAccountActivity 

  Scenario Outline: Validate navigation to Exchange
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Member clicks on "<holdingGroup>"
    Then Member can see "<particularAccount>"
    When Member clicks on "<particularAccount>" accounts
    Then verify Member is navigated to transactions page
    When click on ticker
    When Member clicks on option "Exchange"
    Then Verify That it is navigated to Exchange Page
  	Then User is logged Out	
    Examples: 
      | onlineid   | password | particularAccount   | holdingGroup                |
      | onlineid39 | Test@123 |XXXX0313 | General Investment Accounts |


   @Sanity @ViewAccountActivity 

  Scenario Outline: Validate navigation to View details
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Member clicks on "<holdingGroup>"
    Then Member can see "<particularAccount>"
    When Member clicks on "<particularAccount>" accounts
    Then verify Member is navigated to transactions page
    When click on ticker
    When Member clicks on option "View Details"
    Then Verify That it is navigated to View Details Page
  	Then User is logged Out		
    Examples: 
      | onlineid   | password | particularAccount   | holdingGroup                |
      | onlineid39 | Test@123 | XXXX0313 | General Investment Accounts |
