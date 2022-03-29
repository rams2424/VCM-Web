Feature: Validate Account Activity page navigation and fields

  @Sanity12 @ViewAccountActivity 
  Scenario Outline: Validate navigation to Account Activity and validate fields
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Member clicks on "<holdingGroup>"
    Then Member can see "<particularAccount>"
    When Member clicks on "<particularAccount>" accounts
    Then verify Member is navigated to transactions page
    When Click on View Account Activity
    Then Verify That is navigated to Account Activity
    Then Verify transaction activity table is displayed
    When Click on range Dropdown
    Then verify four options are displayed
    When Select "<Option>" from dropdown
    Then verify stardate and endate is displayed
    Then verify Apply filter button is diplayed
    Then verify Apply filter is disabled by default
    Then verify format of text "MM/DD/YYYY"
    When Blank start date is set
    Then verify Start date error message is displayed
    When Blank end date is set
    Then verify End date error message is displayed
    When Valid date is given for startdate
    When Valid date is given for enddate
    Then verify Apply filter button is enabled
    When Valid date is given for startdate
    When Valid date is given for enddate
    When click on Apply filter button
    Then Verify transaction activity table is displayed
    Then Validate Back to Account button is displayed
    When Click on Back to Account button
    Then Verify it is navigated back to transactions page
    Then User is logged Out

    Examples: 
      | onlineid   | password | particularAccount | holdingGroup                | Option |
      | onlineid39 | Test@123 | XXXX0313          | General Investment Accounts | Custom |

  @Sanity @ViewAccountActivity 
  Scenario Outline: Validate navigation to Account Activity
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When Member clicks on "<holdingGroup>"
    Then Member can see "<particularAccount>"
    When Member clicks on "<particularAccount>" accounts
    Then verify Member is navigated to transactions page
    When Click on View Account Activity
    Then Verify That is navigated to Account Activity
    When Click on "<particularAccount>" link
    Then Verify it is navigated back to transactions page
    Then User is logged Out

    Examples: 
      | onlineid   | password | particularAccount | holdingGroup                |
      | onlineid39 | Test@123 | XXXX0313         | General Investment Accounts |
