Feature: Global Search Navigation Scenarios

  @Sanity @Dashboard @Regression
  Scenario Outline: Verify Global Search Navigations for account holder
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Verify Global Search icon is visible
    And click on Global Search icon
    And Verify Search box, clear and recent searches are displayed
    Then Enter search text "<searchText>"
    When Clicked Enter proxy is asked 
    Then Search results should be displayed in new tab
    When click on Search icon
    Then Enter search text as "<searchText>"
    When click on Search icon
    When click on any recent searches
    Then Search results should be displayed in new tab
 
 @SIT
    Examples: 
      | onlineid    | password | searchText                    |
      | onlineid140 | Test@123 | Victory RS Select Growth Fund |
     
       
 @UAT
 Examples: 
   | onlineid 		| password| searchText                    |
   |uatuser070| Pass@1234|Victory RS Select Growth Fund |

  @Sanity @Dashboard @Regression
  Scenario Outline: Verify Global Search clear button
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    Then Verify Global Search icon is visible
    And click on Global Search icon
    Then Enter text "<searchText>"
    When click on clear
    Then search box should be cleared
    Then User is logged Out
 @SIT
    Examples: 
      | onlineid    | password | searchText                    |
      | onlineid140 | Test@123 | Victory RS Select Growth Fund |
          
 @UAT
 Examples: 
   | onlineid | password| searchText                    |
   | uatuser184 | Pass@1234|Victory RS Select Growth Fund |
   
   
  @Sanity @Dashboard @Regression
  Scenario Outline: Verify Global Search Navigations for guest user
    Given User is on VCM login page with "<onlineid>" and "<password>"
    And Verify User is navigated to HomePage
    And click on Global Search icon
    And Verify Search box, clear and recent searches are displayed
    Then Enter search text "<searchText>"
    When Clicked Enter proxy is asked 
    Then Search results should be displayed in new tab
    When click on Search icon
    Then Enter search text as "<searchText>"
    When click on Search icon
    When click on any recent searches
    Then Search results should be displayed in new tab
 @SIT
    Examples: 
      | onlineid    | password | searchText                    |
      | onlineid140 | Test@123 | Victory RS Select Growth Fund |
     
       
 @UAT
 Examples: 
   | onlineid | password| searchText                    |
   | uatuser152 | Pass@1234|Victory RS Select Growth Fund |
