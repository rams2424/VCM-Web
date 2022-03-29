Feature: Validating Personal Info page fields

  

@Sanity @AccountOpening
  Scenario Outline: Validate navigation to Personal Info page for IRA Accounts and validate fields
    Given User is on VCM login page with "<onlineid>" and "<password>"
    When click on open a new Account button
    Then User Should be navigate to open Account Page
    And Click on IRA Account
    And Click On Next
    And User should be navigated to Account type page
    When User selects type "<accountType>"
    And Verify PersonalInfo Page is displaying
    When Enter zip code ""
    Then Verify error message for zip code is displaying
    When Enter zip code "<invalidZip>"
    Then Verify error message for zip code is displaying
    When Enter zip code "<validZip>"
    Then Verify USPS Recommendation is displaying
    When Click on this address button
    When Blank benefeciary type is selected
    Then Verify error message for benefeciary type is displaying
    When Enter distribution percentage ""
    Then Verify error message for distribution percentage is displaying
    When Enter firstname ""
    Then Verify error message for first name is displaying
    When Enter lastname ""
    Then Verify error message for last name is displaying
    When Enter distribution percentage "<percentage>"
    And Click On Next
    Then Verify error message for distribution percentage is displaying
    Then User is logged Out
    
    @SIT
    Examples: 
      | onlineid    | password | accountType     | invalidZip | validZip   	| percentage |
      | onlineid140 | Pass@123 | Traditional IRA |        123 | 10036		 |         12 |
   
   @UAT
   Examples: 
      | onlineid     | password | accountType     | invalidZip | validZip   	| percentage |
      | uatuser070 	|Pass@1234 | Traditional IRA |        123 | 10036		 |         12 |